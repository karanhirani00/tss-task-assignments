package com.tss.Bookstore.controller;

import com.tss.Bookstore.dto.request.PublisherRequestDto;
import com.tss.Bookstore.dto.response.PagedResponse;
import com.tss.Bookstore.dto.response.PublisherResponseDto;
import com.tss.Bookstore.services.PublisherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/publishers")
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;

    @PostMapping
    public ResponseEntity<PublisherResponseDto> create(@Valid @RequestBody PublisherRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(publisherService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(publisherService.getById(id));
    }

    @GetMapping
    public ResponseEntity<PagedResponse<PublisherResponseDto>> getAll(
            @PageableDefault(size = 10, sort = "id") Pageable pageable) {
        return ResponseEntity.ok(publisherService.getAll(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublisherResponseDto> update(
            @PathVariable Long id, @Valid @RequestBody PublisherRequestDto request) {
        return ResponseEntity.ok(publisherService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        publisherService.delete(id);
        return ResponseEntity.noContent().build();
    }
}