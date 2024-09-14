package com.github.devtorch.saga.stockservice.infrastructure.service;

import com.github.devtorch.saga.stockservice.domain.BookId;
import com.github.devtorch.saga.stockservice.domain.dto.BookRequestDto;
import com.github.devtorch.saga.stockservice.domain.dto.BookResponseDto;
import com.github.devtorch.saga.stockservice.domain.mapper.StockServiceDtoMapper;
import com.github.devtorch.saga.stockservice.infrastructure.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final StockServiceDtoMapper stockServiceDtoMapper;

    @Override
    @Transactional
    public BookResponseDto addNewBook(BookRequestDto bookRequestDto) {
        var newBook = bookRepository.save(stockServiceDtoMapper.toBookEntity(bookRequestDto));
        return stockServiceDtoMapper.bookToBookResponseDto(newBook);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BookResponseDto> getBookById(BookId id) {
        var book = bookRepository.findBookById(id);
        return Optional.ofNullable(book).map(stockServiceDtoMapper::bookToBookResponseDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean isBookAvailable(BookId bookId) {
        return Optional.ofNullable(bookRepository.findBookById(bookId)).isPresent();
    }
}
