package com.github.devtorch.saga.stockservice.infrastructure.controller;

import com.github.devtorch.saga.common.dto.ProductRequestDto;
import com.github.devtorch.saga.common.enums.ProductTypeEnum;
import com.github.devtorch.saga.stockservice.infrastructure.service.BookService;
import com.github.devtorch.saga.stockservice.infrastructure.service.MobileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final BookService bookService;
    private final MobileService mobileService;

    //PostMethod допускается
    @PostMapping(value = "/exists")
    public Boolean isProductAvailable(@RequestBody ProductRequestDto productRequestDto) {

        if (productRequestDto.productType().equals(ProductTypeEnum.BOOK)) {

            return bookService.isBookAvailable(productRequestDto.productId());

        } else if (productRequestDto.productType().equals(ProductTypeEnum.MOBILE)) {

            return mobileService.isMobileAvailable(productRequestDto.productId());

        } else {
            return false;
        }
    }
}
