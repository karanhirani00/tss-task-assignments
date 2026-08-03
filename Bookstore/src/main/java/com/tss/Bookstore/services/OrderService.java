package com.tss.Bookstore.services;

import com.tss.Bookstore.dto.request.OrderRequestDto;
import com.tss.Bookstore.dto.response.OrderResponseDto;
import com.tss.Bookstore.entity.Order;
import jakarta.validation.Valid;

public interface OrderService {

    OrderResponseDto createOrder(@Valid OrderRequestDto request);
}
