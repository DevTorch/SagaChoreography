package com.github.devtorch.saga.stockservice.infrastructure.service;

import com.github.devtorch.saga.stockservice.domain.MobileDeviceId;
import com.github.devtorch.saga.stockservice.domain.dto.MobileRequestDto;
import com.github.devtorch.saga.stockservice.domain.dto.MobileResponseDto;
import com.github.devtorch.saga.stockservice.domain.mapper.StockServiceDtoMapper;
import com.github.devtorch.saga.stockservice.infrastructure.MobileDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MobileServiceImpl implements MobileService {

    private final MobileDeviceRepository mobileDeviceRepository;
    private final StockServiceDtoMapper stockServiceDtoMapper;

    @Override
    @Transactional
    public MobileResponseDto addNewMobileDevice(MobileRequestDto mobileRequestDto) {
        var newMobileDevice = mobileDeviceRepository.save(stockServiceDtoMapper.toMobileDeviceEntity(mobileRequestDto));
        return stockServiceDtoMapper.toMobileResponseDto(newMobileDevice);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MobileResponseDto> getMobileDeviceById(MobileDeviceId id) {
        var mobileDevice = mobileDeviceRepository.findMobileDeviceById(id);
        return Optional.ofNullable(mobileDevice).map(stockServiceDtoMapper::toMobileResponseDto);
    }

    @Override
    public Boolean isMobileAvailable(MobileDeviceId mobileDeviceId) {
        return Optional.ofNullable(mobileDeviceRepository.findMobileDeviceById(mobileDeviceId)).isPresent();
    }
}
