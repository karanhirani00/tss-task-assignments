package com.tss.Bookstore.mapper;

import com.tss.Bookstore.dto.response.UserProfileResponseDto;
import com.tss.Bookstore.entity.UserProfile;
import org.springframework.stereotype.Component;

@Component
public class UserProfileMapper {

    public UserProfileResponseDto toDto(UserProfile profile) {
        return new UserProfileResponseDto(
                profile.getId(),
                profile.getUser().getId(),
                profile.getPhone(),
                profile.getAddress(),
                profile.getDob()
        );
    }
}