package com.tss.Bookstore.services;

import com.tss.Bookstore.dto.request.OrderRequestDto;
import com.tss.Bookstore.dto.response.OrderResponseDto;
import com.tss.Bookstore.dto.response.PagedResponse;
import com.tss.Bookstore.entity.Order;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    OrderResponseDto createOrder(@Valid OrderRequestDto request);

    OrderResponseDto getById(Long id);

    PagedResponse<OrderResponseDto> getOrdersByUserId(Long userId, Pageable pageable);
}
