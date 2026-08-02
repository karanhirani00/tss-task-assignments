package com.tss.Bookstore.services;
import com.tss.Bookstore.dto.request.AuthorRequestDto;
import com.tss.Bookstore.dto.response.AuthorResponseDto;
import com.tss.Bookstore.dto.response.PagedResponse;
import org.springframework.data.domain.Pageable;

public interface AuthorService {

    AuthorResponseDto create(AuthorRequestDto request);

    AuthorResponseDto getById(Long id);

    PagedResponse<AuthorResponseDto> getAll(Pageable pageable);

    AuthorResponseDto update(Long id, AuthorRequestDto request);

    void delete(Long id);
}