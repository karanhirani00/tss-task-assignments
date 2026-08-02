package com.tss.Bookstore.mapper;

import com.tss.Bookstore.dto.response.CategoryResponseDto;
import com.tss.Bookstore.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryResponseDto toDto(Category category) {
        return new CategoryResponseDto(category.getId(), category.getName());
    }
}