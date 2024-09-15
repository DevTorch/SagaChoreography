package com.github.devtorch.saga.stockservice.infrastructure.service;

import com.github.devtorch.saga.stockservice.domain.dto.MobileRequestDto;
import com.github.devtorch.saga.stockservice.domain.dto.MobileResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MobileService {
    MobileResponseDto addNewMobileDevice(MobileRequestDto mobileRequestDto);

    Optional<MobileResponseDto> getMobileDeviceById(UUID id);

    Boolean isMobileAvailable(UUID mobileDeviceId, Integer quantity);

    Page<MobileResponseDto> getList(Pageable pageable);

    List<MobileResponseDto> createMany(List<MobileRequestDto> dtos);

}
