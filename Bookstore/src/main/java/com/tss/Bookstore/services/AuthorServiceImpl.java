package com.tss.Bookstore.services;

import com.tss.Bookstore.dto.request.AuthorRequestDto;
import com.tss.Bookstore.dto.response.AuthorResponseDto;
import com.tss.Bookstore.dto.response.PagedResponse;
import com.tss.Bookstore.entity.Author;
import com.tss.Bookstore.exception.ResourceNotFoundException;
import com.tss.Bookstore.mapper.AuthorMapper;
import com.tss.Bookstore.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor

public class AuthorServiceImpl implements  AuthorService{
    private  final AuthorRepository authorRepository;
    private  final AuthorMapper authorMapper;
    private static final Logger logger = LoggerFactory.getLogger(AuthorServiceImpl.class);
    @Override
    public AuthorResponseDto create(AuthorRequestDto request) {
        Author  author =  new Author();
        author.setName(request.getName());
        logger.info("Successfully created author with ID: {}",author.getId());

        return authorMapper.toDto(authorRepository.save(author));
    }

    @Override
    public AuthorResponseDto getById(Long id) {
          Author  author =authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
         logger.info("Successfully fetched author with ID: {}", id);
          return  authorMapper.toDto(author);
    }

    @Override
    public PagedResponse<AuthorResponseDto> getAll(Pageable pageable) {
        Page<AuthorResponseDto>  authors = authorRepository.findAll(pageable).map(authorMapper::toDto);
        logger.info("Successfully retrieved");
        return  PagedResponse.from(authors);
    }

    @Override
    public AuthorResponseDto update(Long id, AuthorRequestDto request) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));

        author.setName(request.getName());
        Author updatedAuthor = authorRepository.save(author);

        logger.info("Successfully updated author with ID: {}", updatedAuthor.getId());
        return authorMapper.toDto(updatedAuthor);
    }
    @Override
    public void delete(Long id) {
        Author  author =authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
        author.setIsDeleted(true);
        authorRepository.save(author);
        logger.info("Successfully soft-deleted author with ID: {}", id);

    }
}
