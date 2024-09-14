package com.github.devtorch.saga.stockservice.infrastructure.service;

import com.github.devtorch.saga.stockservice.domain.BookId;
import com.github.devtorch.saga.stockservice.domain.dto.BookRequestDto;
import com.github.devtorch.saga.stockservice.domain.dto.BookResponseDto;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {

    BookResponseDto addNewBook(BookRequestDto bookRequestDto);

    Optional<BookResponseDto> getBookById(BookId id);

    Boolean isBookAvailable(BookId bookId);

    List<BookResponseDto> addBooksMany(@Valid List<BookRequestDto> dtos);

    Page<BookResponseDto> getList(Pageable pageable);
}
