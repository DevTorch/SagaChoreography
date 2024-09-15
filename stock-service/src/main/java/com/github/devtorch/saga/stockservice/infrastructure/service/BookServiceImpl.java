package com.github.devtorch.saga.stockservice.infrastructure.service;

import com.github.devtorch.saga.stockservice.domain.Book;
import com.github.devtorch.saga.stockservice.domain.dto.BookRequestDto;
import com.github.devtorch.saga.stockservice.domain.dto.BookResponseDto;
import com.github.devtorch.saga.stockservice.domain.mapper.StockServiceDtoMapper;
import com.github.devtorch.saga.stockservice.infrastructure.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
    @Transactional
    public List<BookResponseDto> addBooksMany(List<BookRequestDto> dtos) {
        var books = bookRepository.saveAll(dtos.stream().map(stockServiceDtoMapper::toBookEntity).toList());
        return books.stream().map(stockServiceDtoMapper::bookToBookResponseDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BookResponseDto> getBookById(UUID id) {
        var book = bookRepository.findBookById(id);
        return Optional.ofNullable(book).map(stockServiceDtoMapper::bookToBookResponseDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean isBookAvailable(UUID bookId, Integer quantity) {

        return bookRepository.findBookById(bookId) != null
               && bookRepository.findBookById(bookId).getQuantity() >= quantity;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BookResponseDto> getList(Pageable pageable) {
        Page<Book> books = bookRepository.findAll(pageable);
        return books.map(stockServiceDtoMapper::bookToBookResponseDto);
    }
}
