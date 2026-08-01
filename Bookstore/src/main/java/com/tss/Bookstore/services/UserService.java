package com.tss.Bookstore.services;
;
import com.tss.Bookstore.dto.PagedResponse;
import com.tss.Bookstore.dto.UserCreateRequestDto;
import com.tss.Bookstore.dto.UserResponseDto;
import com.tss.Bookstore.dto.UserUpdateRequestDto;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserResponseDto create(UserCreateRequestDto request);

    UserResponseDto getById(Long id);

    PagedResponse<UserResponseDto> getAll(Pageable pageable);

    UserResponseDto update(Long id, UserUpdateRequestDto request);

    void delete(Long id);
}