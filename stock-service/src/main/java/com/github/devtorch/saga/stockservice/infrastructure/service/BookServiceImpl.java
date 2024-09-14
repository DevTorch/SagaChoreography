package com.github.devtorch.saga.stockservice.infrastructure.service;

import com.github.devtorch.saga.stockservice.domain.BookId;
import com.github.devtorch.saga.stockservice.domain.dto.BookRequestDto;
import com.github.devtorch.saga.stockservice.domain.dto.BookResponseDto;
import com.github.devtorch.saga.stockservice.domain.mapper.StockServiceDtoMapper;
import com.github.devtorch.saga.stockservice.infrastructure.BookRepository;
import com.github.devtorch.saga.stockservice.infrastructure.MobileDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final StockServiceDtoMapper stockServiceDtoMapper;

    private final MobileDeviceRepository mobileDeviceRepository;

    @Override
    public BookResponseDto addNewBook(BookRequestDto bookRequestDto) {
        var newBook = bookRepository.save(stockServiceDtoMapper.toBookEntity(bookRequestDto));
        return stockServiceDtoMapper.bookToBookResponseDto(newBook);
    }

    @Override
    public Optional<BookResponseDto> getBookById(BookId id) {
        return bookRepository.findBookById(id).map(stockServiceDtoMapper::bookToBookResponseDto);
    }
}
