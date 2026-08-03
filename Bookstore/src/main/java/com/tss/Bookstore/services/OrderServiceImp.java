package com.tss.Bookstore.services;

import com.tss.Bookstore.dto.request.OrderRequestDto;
import com.tss.Bookstore.dto.response.OrderResponseDto;
import com.tss.Bookstore.entity.Book;
import com.tss.Bookstore.entity.Order;
import com.tss.Bookstore.entity.OrderItem;
import com.tss.Bookstore.entity.User;
import com.tss.Bookstore.enums.OrderStatus;
import com.tss.Bookstore.exception.ResourceNotFoundException;
import com.tss.Bookstore.mapper.OrderMapper;
import com.tss.Bookstore.repository.BookRepository;
import com.tss.Bookstore.repository.OrderRepository;
import com.tss.Bookstore.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements OrderService {
    private  final UserRepository userRepository;
    private  final BookRepository bookRepository;
    private  final OrderRepository orderRepository;
    private  final OrderMapper orderMapper;

    @Override
    @Transactional
    public OrderResponseDto createOrder(OrderRequestDto request) {
        User user = userRepository.findByIdAndIsDeletedFalse(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + request.getUserId()));

        Order order = new Order();
        order.setUser(user);
        order.setStatus(OrderStatus.PLACED);

        List<OrderItem> orderItemList = new ArrayList<>();
        BigDecimal totalAmount = BigDecimal.ZERO;

        List<OrderRequestDto.OrderItemRequest> orderitemsrequestlist = request.getItems();

        for (OrderRequestDto.OrderItemRequest orderItemRequest : orderitemsrequestlist) {
            Book book = bookRepository.findById(orderItemRequest.getBookId())
                    .orElseThrow(() -> new ResourceNotFoundException("this bookId was not found: " + orderItemRequest.getBookId()));

            OrderItem orderItem = new OrderItem();
            orderItem.setBook(book);
            orderItem.setQuantity(orderItemRequest.getQuantity());
            BigDecimal currentPrice = book.getPrice();
            orderItem.setPriceAtPurchase(currentPrice);

            orderItem.setOrder(order);
            BigDecimal itemSubtotal = currentPrice.multiply(BigDecimal.valueOf(orderItemRequest.getQuantity()));
            totalAmount = totalAmount.add(itemSubtotal);

            orderItemList.add(orderItem);
        }

        order.setItems(orderItemList);
        order.setTotalAmount(totalAmount);

        Order savedOrder = orderRepository.save(order);
        return orderMapper.toDto(savedOrder);
    }





}
