package com.tss.Bookstore.controller;

import com.tss.Bookstore.dto.response.PagedResponse;
import com.tss.Bookstore.dto.request.UserCreateRequestDto;
import com.tss.Bookstore.dto.response.UserResponseDto;
import com.tss.Bookstore.dto.request.UserUpdateRequestDto;
import com.tss.Bookstore.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@Valid @RequestBody UserCreateRequestDto request) {
        UserResponseDto created = userService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping
    public ResponseEntity<PagedResponse<UserResponseDto>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size)
    {
        Pageable pageable = PageRequest.of(page ,size, Sort.by("name"));

        return ResponseEntity.ok(userService.getAll(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable Long id,
                                                  @Valid @RequestBody UserUpdateRequestDto request) {
        return ResponseEntity.ok(userService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}