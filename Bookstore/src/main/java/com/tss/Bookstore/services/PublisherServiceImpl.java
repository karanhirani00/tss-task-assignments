package com.tss.Bookstore.services;

import com.tss.Bookstore.dto.request.PublisherRequestDto;
import com.tss.Bookstore.dto.response.PagedResponse;
import com.tss.Bookstore.dto.response.PublisherResponseDto;
import com.tss.Bookstore.entity.Publisher;
import com.tss.Bookstore.exception.ResourceNotFoundException;
import com.tss.Bookstore.mapper.PublisherMapper;
import com.tss.Bookstore.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    @Override
    public PublisherResponseDto create(PublisherRequestDto request) {
        Publisher publisher = new Publisher();
        publisher.setName(request.getName());
        return publisherMapper.toDto(publisherRepository.save(publisher));
    }

    @Override
    public PublisherResponseDto getById(Long id) {
        return publisherMapper.toDto(publisherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publisher not found with id: " + id)));
    }

    @Override
    public PagedResponse<PublisherResponseDto> getAll(Pageable pageable) {
        Page<PublisherResponseDto> page = publisherRepository.findAll(pageable).map(publisherMapper::toDto);
        return PagedResponse.from(page);
    }

    @Override

    public PublisherResponseDto update(Long id, PublisherRequestDto request) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publisher not found with id: " + id));
        publisher.setName(request.getName());
        return publisherMapper.toDto(publisherRepository.save(publisher));
    }

    @Override
    public void delete(Long id) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publisher not found with id: " + id));
        publisher.setIsDeleted(true);
        publisherRepository.save(publisher);
    }


}