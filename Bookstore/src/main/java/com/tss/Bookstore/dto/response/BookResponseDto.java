package com.tss.Bookstore.dto.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class BookResponseDto {
    private Long id;
    private String title;
    private String isbn;
    private BigDecimal price;
    private Integer stockCount;
    private String publisherName;
    private String categoryName;
    private Set<String> authorNames;
}