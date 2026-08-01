package com.tss.Bookstore.mapper;




import com.tss.Bookstore.dto.response.UserResponseDto;
import com.tss.Bookstore.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}