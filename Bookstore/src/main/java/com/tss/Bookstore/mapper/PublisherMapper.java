package com.tss.Bookstore.mapper;

import com.tss.Bookstore.dto.response.PublisherResponseDto;
import com.tss.Bookstore.entity.Publisher;
import org.springframework.stereotype.Component;

@Component
public class PublisherMapper {

    public PublisherResponseDto toDto(Publisher publisher) {
        return new PublisherResponseDto(publisher.getId(), publisher.getName());
    }
}
