package com.tss.Bookstore.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@AllArgsConstructor
public class PagedResponse<T> {
    private List<T> content;
    private long totalElements;
    private int totalPages;
    private int currentPage;

    public static <T> PagedResponse<T> from(Page<T> page) {
        return new PagedResponse<>(
                page.getContent(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.getNumber()
        );
    }
}