package com.tss.Bookstore.services;

import com.tss.Bookstore.dto.request.BookRequestDto;
import com.tss.Bookstore.dto.response.BookResponseDto;
import com.tss.Bookstore.dto.response.PagedResponse;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

public interface BookService {

    BookResponseDto create(BookRequestDto request);

    BookResponseDto getById(Long id);


    PagedResponse<BookResponseDto> getAll(Pageable pageable);

    PagedResponse<BookResponseDto> search(
            String title,
            Long categoryId,
            Long authorId,
            BigDecimal minPrice,
            BigDecimal maxPrice,
            Boolean inStock,
            Pageable pageable
    );
}