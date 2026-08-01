package com.tss.Bookstore.dto.request;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserProfileRequestDto {

    @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "Phone must be a valid number (7-15 digits)")
    private String phone;

    private String address;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dob;

}
