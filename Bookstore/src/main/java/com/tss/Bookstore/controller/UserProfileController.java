package com.tss.Bookstore.controller;

import com.tss.Bookstore.dto.request.UserProfileRequestDto;
import com.tss.Bookstore.dto.response.UserProfileResponseDto;
import com.tss.Bookstore.entity.UserProfile;
import com.tss.Bookstore.services.UserProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/{userId}/profile")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

    @PostMapping
    public ResponseEntity<UserProfileResponseDto> create(
            @PathVariable Long userId,
            @Valid @RequestBody UserProfileRequestDto request) {
        UserProfileResponseDto created = userProfileService.create(userId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<UserProfile> get(@PathVariable Long userId) {
        return ResponseEntity.ok(userProfileService.getByUserId(userId));
    }

    @PutMapping
    public ResponseEntity<UserProfileResponseDto> update(
            @PathVariable Long userId,
            @Valid @RequestBody UserProfileRequestDto request) {
        return ResponseEntity.ok(userProfileService.update(userId, request));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long userId) {
        userProfileService.delete(userId);
        return ResponseEntity.noContent().build();
    }
}