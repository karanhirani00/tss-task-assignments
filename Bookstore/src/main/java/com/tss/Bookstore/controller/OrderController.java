package com.tss.Bookstore.controller;

import com.tss.Bookstore.dto.request.OrderRequestDto;
import com.tss.Bookstore.dto.response.OrderResponseDto;
import com.tss.Bookstore.services.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@Valid @RequestBody OrderRequestDto request) {
        OrderResponseDto  orderResponseDto = orderService.createOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponseDto);
    }
}