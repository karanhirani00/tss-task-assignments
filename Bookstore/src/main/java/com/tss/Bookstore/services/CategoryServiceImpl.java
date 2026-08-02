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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override

    public CategoryResponseDto create(CategoryRequestDto request) {
        if (categoryRepository.existsByName(request.getName())) {
            throw new DuplicateResourceException("Category already exists: " + request.getName());
        }
        Category category = new Category();
        category.setName(request.getName());
        return categoryMapper.toDto(categoryRepository.save(category));
    }

    @Override
    public CategoryResponseDto getById(Long id) {
        return categoryMapper.toDto(findOrThrow(id));
    }

    @Override
    public PagedResponse<CategoryResponseDto> getAll(Pageable pageable) {
        Page<CategoryResponseDto> page = categoryRepository.findAll(pageable).map(categoryMapper::toDto);
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
        return categoryMapper.toDto(categoryRepository.save(category));
    }

    @Override
    public void delete(Long id) {
        Category category =categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
        category.setIsDeleted(true);
        categoryRepository.save(category);
    }

    private Category findOrThrow(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
    }
}