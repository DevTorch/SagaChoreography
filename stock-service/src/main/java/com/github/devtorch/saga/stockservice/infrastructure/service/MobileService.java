package com.github.devtorch.saga.stockservice.infrastructure.service;

import com.github.devtorch.saga.stockservice.domain.MobileDeviceId;
import com.github.devtorch.saga.stockservice.domain.dto.MobileRequestDto;
import com.github.devtorch.saga.stockservice.domain.dto.MobileResponseDto;

import java.util.Optional;

public interface MobileService {
    MobileResponseDto addNewMobileDevice(MobileRequestDto mobileRequestDto);

    Optional<MobileResponseDto> getMobileDeviceById(MobileDeviceId id);

    Boolean isMobileAvailable(MobileDeviceId mobileDeviceId);
}
