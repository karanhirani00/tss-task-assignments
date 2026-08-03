package com.tss.Bookstore.services;

import com.tss.Bookstore.dto.request.BookRequestDto;
import com.tss.Bookstore.dto.response.BookResponseDto;
import com.tss.Bookstore.dto.response.PagedResponse;
import org.springframework.data.domain.Pageable;

public interface BookService {

    BookResponseDto create(BookRequestDto request);

    BookResponseDto getById(Long id);


    PagedResponse<BookResponseDto> getAll(Pageable pageable);



}