package com.tss.Bookstore.services;
import com.tss.Bookstore.dto.request.PublisherRequestDto;
import com.tss.Bookstore.dto.response.PagedResponse;
import com.tss.Bookstore.dto.response.PublisherResponseDto;
import org.springframework.data.domain.Pageable;

public interface PublisherService {

    PublisherResponseDto create(PublisherRequestDto request);

    PublisherResponseDto getById(Long id);

    PagedResponse<PublisherResponseDto> getAll(Pageable pageable);

    PublisherResponseDto update(Long id, PublisherRequestDto request);

    void delete(Long id);
}