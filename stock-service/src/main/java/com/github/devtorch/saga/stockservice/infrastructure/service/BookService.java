package com.github.devtorch.saga.stockservice.infrastructure.service;

import com.github.devtorch.saga.stockservice.domain.BookId;
import com.github.devtorch.saga.stockservice.domain.dto.BookRequestDto;
import com.github.devtorch.saga.stockservice.domain.dto.BookResponseDto;

import java.util.Optional;

public interface BookService {

    BookResponseDto addNewBook(BookRequestDto bookRequestDto);

    Optional<BookResponseDto> getBookById(BookId id);

    Boolean isBookAvailable(BookId bookId);
}
