package com.tss.Bookstore.services;

import com.tss.Bookstore.dto.request.CategoryRequestDto;
import com.tss.Bookstore.dto.response.CategoryResponseDto;
import com.tss.Bookstore.dto.response.PagedResponse;
import com.tss.Bookstore.entity.Category;
import com.tss.Bookstore.exception.DuplicateResourceException;
import com.tss.Bookstore.exception.ResourceNotFoundException;
import com.tss.Bookstore.mapper.CategoryMapper;
import com.tss.Bookstore.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Override
    public CategoryResponseDto create(CategoryRequestDto request) {
        if (categoryRepository.existsByName(request.getName())) {
            throw new DuplicateResourceException("Category already exists: " + request.getName());
        }

        Category category = new Category();
        category.setName(request.getName());

        Category savedCategory = categoryRepository.save(category);
        logger.info("Successfully created category with ID: {}" , savedCategory.getId());

        return categoryMapper.toDto(savedCategory);
    }

    @Override
    public CategoryResponseDto getById(Long id) {
        Category category = findOrThrow(id);

        logger.info("Successfully fetched category with ID: {}", id);
        return categoryMapper.toDto(category);
    }

    @Override
    public PagedResponse<CategoryResponseDto> getAll(Pageable pageable) {
        Page<CategoryResponseDto> page = categoryRepository.findAll(pageable).map(categoryMapper::toDto);

        logger.info("Successfully retrieved categories page ");


        return PagedResponse.from(page);
    }

    @Override
    public CategoryResponseDto update(Long id, CategoryRequestDto request) {
        Category category = findOrThrow(id);

        if (!category.getName().equals(request.getName())
                && categoryRepository.existsByName(request.getName())) {
            throw new DuplicateResourceException("Category already exists: " + request.getName());
        }

        category.setName(request.getName());
        Category updatedCategory = categoryRepository.save(category);

        logger.info("Successfully updated category with ID: {}", updatedCategory.getId());
        return categoryMapper.toDto(updatedCategory);
    }

    @Override
    public void delete(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));

        category.setIsDeleted(true);
        categoryRepository.save(category);

        logger.info("Successfully soft-deleted category with ID: {}", id);
    }

    private Category findOrThrow(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
    }
}