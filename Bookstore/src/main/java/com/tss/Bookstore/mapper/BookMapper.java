package com.tss.Bookstore.mapper;

import com.tss.Bookstore.dto.response.BookResponseDto;
import com.tss.Bookstore.entity.Author;
import com.tss.Bookstore.entity.Book;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BookMapper {

    public BookResponseDto toDto(Book book) {
        return new BookResponseDto(
                book.getId(),
                book.getTitle(),
                book.getIsbn(),
                book.getPrice(),
                book.getStockCount(),
                book.getPublisher().getName(),
                book.getCategory().getName(),
                book.getAuthors().stream().map(Author::getName).collect(Collectors.toSet())
        );
    }
}