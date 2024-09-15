package com.github.devtorch.saga.stockservice.infrastructure.service;

import com.github.devtorch.saga.stockservice.domain.dto.BookRequestDto;
import com.github.devtorch.saga.stockservice.domain.dto.BookResponseDto;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {

    BookResponseDto addNewBook(BookRequestDto bookRequestDto);

    Optional<BookResponseDto> getBookById(UUID id);

    Boolean isBookAvailable(UUID bookId, Integer quantity);

    List<BookResponseDto> addBooksMany(@Valid List<BookRequestDto> dtos);

    Page<BookResponseDto> getList(Pageable pageable);
}
