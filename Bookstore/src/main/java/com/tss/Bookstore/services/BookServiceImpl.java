package com.tss.Bookstore.services;

import com.tss.Bookstore.dto.response.PagedResponse;
import com.tss.Bookstore.dto.request.BookRequestDto;
import com.tss.Bookstore.dto.response.BookResponseDto;
import com.tss.Bookstore.entity.Author;
import com.tss.Bookstore.entity.Book;
import com.tss.Bookstore.entity.Category;
import com.tss.Bookstore.entity.Publisher;
import com.tss.Bookstore.exception.DuplicateResourceException;
import com.tss.Bookstore.exception.ResourceNotFoundException;
import com.tss.Bookstore.mapper.BookMapper;
import com.tss.Bookstore.repository.AuthorRepository;
import com.tss.Bookstore.repository.BookRepository;
import com.tss.Bookstore.repository.CategoryRepository;
import com.tss.Bookstore.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;
    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    @Override
    public BookResponseDto create(BookRequestDto request) {

        if (bookRepository.existsByIsbn(request.getIsbn())) {
            throw new DuplicateResourceException("Book already exists with ISBN: " + request.getIsbn());
        }

        Publisher publisher = publisherRepository.findById(request.getPublisherId())
                .orElseThrow(() -> new ResourceNotFoundException("Publisher not found with id: " + request.getPublisherId()));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + request.getCategoryId()));

        Set<Author> authors = new HashSet<>();
        for (Long authorId : request.getAuthorIds()) {
            Author author = authorRepository.findById(authorId)
                    .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + authorId));
            authors.add(author);
        }

        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setIsbn(request.getIsbn());
        book.setPrice(request.getPrice());
        book.setStockCount(request.getStockCount());
        book.setPublisher(publisher);
        book.setCategory(category);
        book.setAuthors(authors);

        Book saved = bookRepository.save(book);
        logger.info("Successfully created book with ID: {}",saved.getId());
        return bookMapper.toDto(saved);
    }

    @Override
    public BookResponseDto getById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        logger.info("Successfully fetched book with ID: {}", id);
        return bookMapper.toDto(book);
    }

    @Override
    public PagedResponse<BookResponseDto> getAll(Pageable pageable) {
        Page<BookResponseDto> page = bookRepository.findAll(pageable)
                .map(bookMapper::toDto);
        logger.info("Successfully retrieved books page {}", page.getNumber());
        return PagedResponse.from(page);
    }

    @Override
    public PagedResponse<BookResponseDto> search(
            String title,
            Long categoryId,
            Long authorId,
            BigDecimal minPrice,
            BigDecimal maxPrice,
            Boolean inStock,
            Pageable pageable) {

        Page<BookResponseDto> page = bookRepository.searchBooks(title, categoryId, authorId, minPrice, maxPrice, inStock, pageable)
                .map(bookMapper::toDto);
        logger.info("Successfully executed serch");

        return PagedResponse.from(page);
    }
}