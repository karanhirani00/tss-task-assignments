package com.tss.Bookstore.controller;

import com.tss.Bookstore.dto.request.AuthorRequestDto;
import com.tss.Bookstore.dto.response.AuthorResponseDto;
import com.tss.Bookstore.dto.response.PagedResponse;
import com.tss.Bookstore.services.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorResponseDto> create(@Valid @RequestBody AuthorRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getById(id));
    }

    @GetMapping
    public ResponseEntity<PagedResponse<AuthorResponseDto>> getAll(
            @PageableDefault(size = 10, sort = "id") Pageable pageable) {
        return ResponseEntity.ok(authorService.getAll(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> update(
            @PathVariable Long id, @Valid @RequestBody AuthorRequestDto request) {
        return ResponseEntity.ok(authorService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        authorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}