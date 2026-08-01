package com.tss.Bookstore.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class UserProfileResponseDto {
    private Long id;
    private Long userId;
    private String phone;
    private String address;
    private LocalDate dob;

}