package com.tss.Bookstore.services;

import com.tss.Bookstore.dto.PagedResponse;
import com.tss.Bookstore.dto.UserCreateRequestDto;
import com.tss.Bookstore.dto.UserResponseDto;
import com.tss.Bookstore.dto.UserUpdateRequestDto;
import com.tss.Bookstore.entity.User;
import com.tss.Bookstore.exception.DuplicateResourceException;
import com.tss.Bookstore.exception.ResourceNotFoundException;
import com.tss.Bookstore.mapper.UserMapper;
import com.tss.Bookstore.repository.userRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements UserService{
    private  final  userRepository userRepository;
    private  final UserMapper userMapper;


    @Override
    public UserResponseDto create(UserCreateRequestDto request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email already registered: " + request.getEmail());
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        User saved = userRepository.save(user);
        return userMapper.toDto(saved);
    }

    @Override
    public UserResponseDto getById(Long id) {
        User user = userRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return userMapper.toDto(user);
    }

    @Override
    public PagedResponse<UserResponseDto> getAll(Pageable pageable) {
        Page<UserResponseDto> page = userRepository.findByIsDeletedFalse(pageable)
                .map(userMapper::toDto);
        return PagedResponse.from(page);
    }

    @Override
    public UserResponseDto update(Long id, UserUpdateRequestDto request) {
        User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("id was not found"));
        if (userRepository.existsByEmail(request.getEmail()) && !(user.getEmail().equals(request.getEmail()))) {
            throw new DuplicateResourceException("Email already registered: " + request.getEmail());
        }

        user.setEmail(request.getEmail());
        user.setName(request.getName());

        if (request.getPassword() != null && !request.getPassword().isBlank()) {
            user.setPassword(request.getPassword());
        }
        userRepository.save(user);
        return  userMapper.toDto(user);
    }

    @Override
    public void delete(Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id : " + id));


        if (Boolean.TRUE.equals(user.getIsDeleted())) {
            throw new ResourceNotFoundException("User is already deleted.");
        }

        user.setIsDeleted(true);
        userRepository.save(user);
    }
}
