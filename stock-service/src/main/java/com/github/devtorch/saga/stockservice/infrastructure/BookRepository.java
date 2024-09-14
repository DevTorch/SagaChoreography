package com.github.devtorch.saga.stockservice.infrastructure;

import com.github.devtorch.saga.stockservice.domain.Book;
import com.github.devtorch.saga.stockservice.domain.BookId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, BookId> {
    Optional<Book> findBookById(BookId id);
}
