package com.github.devtorch.saga.stockservice.infrastructure.controller;

import com.github.devtorch.saga.stockservice.domain.BookId;
import com.github.devtorch.saga.stockservice.domain.dto.BookRequestDto;
import com.github.devtorch.saga.stockservice.domain.dto.BookResponseDto;
import com.github.devtorch.saga.stockservice.infrastructure.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponseDto> addNewBook(@RequestBody @Valid BookRequestDto bookRequestDto) {
        return ResponseEntity.ok(bookService.addNewBook(bookRequestDto));
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable("id") BookId id) {
        return ResponseEntity.ok(bookService.getBookById(id)

                //TODO Add Exception and error handling

                .orElseThrow(() -> new RuntimeException("Book not found")));
    }
}

