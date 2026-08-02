package com.tss.Bookstore.services;
import com.tss.Bookstore.dto.request.CategoryRequestDto;
import com.tss.Bookstore.dto.response.CategoryResponseDto;
import com.tss.Bookstore.dto.response.PagedResponse;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    CategoryResponseDto create(CategoryRequestDto request);

    CategoryResponseDto getById(Long id);

    PagedResponse<CategoryResponseDto> getAll(Pageable pageable);

    CategoryResponseDto update(Long id, CategoryRequestDto request);

    void delete(Long id);
}