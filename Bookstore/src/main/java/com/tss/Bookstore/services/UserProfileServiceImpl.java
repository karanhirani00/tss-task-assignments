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
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class UserProfileServiceImpl implements UserProfileService{
    private  final UserProfileRepository userProfileRepository;
    private  final UserProfileMapper userProfileMapper;
    private  final UserRepository userRepository;


    @Override
    public UserProfileResponseDto create(Long userId, UserProfileRequestDto request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        if (userProfileRepository.existsByUserId(userId)) {
            throw new DuplicateResourceException("Profile already exists for user id: " + userId);
        }
        UserProfile profile = new UserProfile();
        profile.setUser(user);
        applyRequest(profile, request);

        UserProfile saved = userProfileRepository.save(profile);
        return userProfileMapper.toDto(saved);
    }

    @Override
    public UserProfile getByUserId(Long userId) {
        UserProfile userProfile = userProfileRepository.findByUserId(userId).orElseThrow(
                ()->new ResourceNotFoundException("user Profile not  found"));
        return  userProfile;

    }

    @Override
    public UserProfileResponseDto update(Long userId, UserProfileRequestDto request) {
        UserProfile userProfile = userProfileRepository.findByUserId(userId).orElseThrow(
                ()->new ResourceNotFoundException("user Profile not  found"));
        applyRequest(userProfile, request);
        return userProfileMapper.toDto(userProfileRepository.save(userProfile));
    }

    @Override
    public void delete(Long userId) {
        UserProfile userProfile = userProfileRepository.findByUserId(userId).orElseThrow(
                ()->new ResourceNotFoundException("user Profile not  found"));
        userProfileRepository.delete(userProfile);

    }

    private void applyRequest(UserProfile profile, UserProfileRequestDto request) {
        profile.setPhone(request.getPhone());
        profile.setAddress(request.getAddress());
        profile.setDob(request.getDob());

    }
}
