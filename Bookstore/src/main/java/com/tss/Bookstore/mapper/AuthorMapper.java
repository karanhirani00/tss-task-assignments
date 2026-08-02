package com.tss.Bookstore.mapper;



import com.tss.Bookstore.dto.response.AuthorResponseDto;
import com.tss.Bookstore.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public AuthorResponseDto toDto(Author author) {
        return new AuthorResponseDto(author.getId(), author.getName());
    }
}