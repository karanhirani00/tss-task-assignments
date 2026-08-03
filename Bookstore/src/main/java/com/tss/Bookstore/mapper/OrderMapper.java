package com.tss.Bookstore.mapper;

import com.tss.Bookstore.dto.response.OrderItemResponseDto;
import com.tss.Bookstore.dto.response.OrderResponseDto;
import com.tss.Bookstore.entity.Order;
import com.tss.Bookstore.entity.OrderItem;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public OrderResponseDto toDto(Order order) {
        if (order == null) {
            return null;
        }

        List<OrderItemResponseDto> itemDtos = (order.getItems() == null)
                ? Collections.emptyList()
                : order.getItems().stream()
                .map(this::toItemDto)
                .collect(Collectors.toList());

        return OrderResponseDto.builder()
                .id(order.getId())
                .userId(order.getUser() != null ? order.getUser().getId() : null)
                .userEmail(order.getUser() != null ? order.getUser().getEmail() : null)
                .status(order.getStatus())
                .totalAmount(order.getTotalAmount())
                .createdAt(order.getCreatedAt())
                .items(itemDtos)
                .build();
    }

    private OrderItemResponseDto toItemDto(OrderItem item) {
        if (item == null) {
            return null;
        }

        BigDecimal subtotal = BigDecimal.ZERO;
        if (item.getPriceAtPurchase() != null && item.getQuantity() != null) {
            subtotal = item.getPriceAtPurchase().multiply(BigDecimal.valueOf(item.getQuantity()));
        }

        return OrderItemResponseDto.builder()
                .id(item.getId())
                .bookId(item.getBook() != null ? item.getBook().getId() : null)
                .bookTitle(item.getBook() != null ? item.getBook().getTitle() : null)
                .quantity(item.getQuantity())
                .priceAtPurchase(item.getPriceAtPurchase())
                .subtotal(subtotal)
                .build();
    }
}