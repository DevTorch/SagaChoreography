package com.github.devtorch.saga.stockservice.domain.mapper;

import com.github.devtorch.saga.stockservice.domain.Book;
import com.github.devtorch.saga.stockservice.domain.MobileDevice;
import com.github.devtorch.saga.stockservice.domain.dto.BookRequestDto;
import com.github.devtorch.saga.stockservice.domain.dto.BookResponseDto;
import com.github.devtorch.saga.stockservice.domain.dto.MobileRequestDto;
import com.github.devtorch.saga.stockservice.domain.dto.MobileResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StockServiceDtoMapper {

    BookResponseDto bookToBookResponseDto(Book book);

    @Mapping(target = "id", ignore = true)
    Book toBookEntity(BookRequestDto bookRequestDto);

    MobileResponseDto toMobileResponseDto(MobileDevice mobileDevice);

    @Mapping(target = "id", ignore = true)
    MobileDevice toMobileDeviceEntity(MobileRequestDto mobileRequestDto);
}
