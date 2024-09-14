package com.github.devtorch.saga.stockservice.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.Assert;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @EmbeddedId
    private BookId id;
    private String title;
    private String author;
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "ISBN"))
    private Isbn isbn;
    private BigDecimal cost;
    @Min(1)
    private Integer quantity;

    public Book(String title, String author, Isbn isbn, BigDecimal cost) {
        Assert.notNull(title, "title must not be null");
        Assert.notNull(author, "author must not be null");
        Assert.notNull(isbn, "ISBN must not be null");
        Assert.notNull(cost, "cost must not be null");
        this.id = new BookId();
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.cost = cost;
    }
}
