package com.tss.Bookstore.services;


import com.tss.Bookstore.dto.request.UserProfileRequestDto;
import com.tss.Bookstore.dto.response.UserProfileResponseDto;
import com.tss.Bookstore.entity.UserProfile;

public interface UserProfileService {

    UserProfileResponseDto create(Long userId, UserProfileRequestDto request);

    UserProfile getByUserId(Long userId);

    UserProfileResponseDto update(Long userId, UserProfileRequestDto request);

    void delete(Long userId);
}