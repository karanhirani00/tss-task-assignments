package com.tss.Bookstore.services;

import com.tss.Bookstore.dto.request.UserProfileRequestDto;
import com.tss.Bookstore.dto.response.UserProfileResponseDto;
import com.tss.Bookstore.entity.User;
import com.tss.Bookstore.entity.UserProfile;
import com.tss.Bookstore.exception.DuplicateResourceException;
import com.tss.Bookstore.exception.ResourceNotFoundException;
import com.tss.Bookstore.mapper.UserProfileMapper;
import com.tss.Bookstore.repository.UserProfileRepository;
import com.tss.Bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final UserProfileMapper userProfileMapper;
    private final UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserProfileServiceImpl.class);

    @Override
    public UserProfileResponseDto create(Long userId, UserProfileRequestDto request) {

        if (!validateAge(request.getDob())) {
            logger.warn("Profile creation failed: User age validation failed for userId: {}, DOB: {}", userId, request.getDob());
            throw new RuntimeException("user age is more then 10");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        if (userProfileRepository.existsByUserId(userId)) {

            throw new DuplicateResourceException("Profile already exists for user id: " + userId);
        }

        UserProfile profile = new UserProfile();
        profile.setUser(user);
        applyRequest(profile, request);

        UserProfile saved = userProfileRepository.save(profile);
        logger.info("Successfully created user profile with id: {} for userId: {}", saved.getId(), userId);

        return userProfileMapper.toDto(saved);
    }

    @Override
    public UserProfile getByUserId(Long userId) {

        UserProfile userProfile = userProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user Profile not found"));

        logger.info("Successfully retrieved profile for userId: {}", userId);
        return userProfile;
    }

    @Override
    public UserProfileResponseDto update(Long userId, UserProfileRequestDto request) {

        if (!validateAge(request.getDob())) {
            logger.warn("Profile update failed: User age validation failed for userId: {}, DOB: {}", userId, request.getDob());
            throw new RuntimeException("user age is more then 10");
        }

        UserProfile userProfile = userProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user Profile not found"));

        applyRequest(userProfile, request);
        UserProfile updated = userProfileRepository.save(userProfile);

        logger.info("Successfully updated profile for userId: {}", userId);
        return userProfileMapper.toDto(updated);
    }

    @Override
    public void delete(Long userId) {

        UserProfile userProfile = userProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user Profile not found"));

        userProfileRepository.delete(userProfile);
        logger.info("Successfully deleted profile for userId: {}", userId);
    }

    private void applyRequest(UserProfile profile, UserProfileRequestDto request) {
        profile.setPhone(request.getPhone());
        profile.setAddress(request.getAddress());
        profile.setDob(request.getDob());
    }

    private Boolean validateAge(LocalDate localDate) {
        if (localDate == null) {
            return false;
        }
        int minAge = 10;
        int currentYear = LocalDate.now().getYear();
        return minAge <= (currentYear - localDate.getYear());
    }
}