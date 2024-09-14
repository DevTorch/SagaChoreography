package com.github.devtorch.saga.stockservice.infrastructure.service;

import com.github.devtorch.saga.stockservice.domain.MobileDeviceId;
import com.github.devtorch.saga.stockservice.domain.dto.MobileRequestDto;
import com.github.devtorch.saga.stockservice.domain.dto.MobileResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MobileService {
    MobileResponseDto addNewMobileDevice(MobileRequestDto mobileRequestDto);

    Optional<MobileResponseDto> getMobileDeviceById(MobileDeviceId id);

    Boolean isMobileAvailable(MobileDeviceId mobileDeviceId);

    Page<MobileResponseDto> getList(Pageable pageable);

    List<MobileResponseDto> createMany(List<MobileRequestDto> dtos);

}
