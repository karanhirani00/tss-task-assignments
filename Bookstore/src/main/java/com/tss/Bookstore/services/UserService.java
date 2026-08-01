package com.tss.Bookstore.services;
;
import com.tss.Bookstore.dto.response.PagedResponse;
import com.tss.Bookstore.dto.request.UserCreateRequestDto;
import com.tss.Bookstore.dto.response.UserResponseDto;
import com.tss.Bookstore.dto.request.UserUpdateRequestDto;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserResponseDto create(UserCreateRequestDto request);

    UserResponseDto getById(Long id);

    PagedResponse<UserResponseDto> getAll(Pageable pageable);

    UserResponseDto update(Long id, UserUpdateRequestDto request);

    void delete(Long id);
}