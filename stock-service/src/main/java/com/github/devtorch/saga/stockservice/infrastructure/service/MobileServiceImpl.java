package com.github.devtorch.saga.stockservice.infrastructure.service;

import com.github.devtorch.saga.stockservice.domain.MobileDevice;
import com.github.devtorch.saga.stockservice.domain.dto.MobileRequestDto;
import com.github.devtorch.saga.stockservice.domain.dto.MobileResponseDto;
import com.github.devtorch.saga.stockservice.domain.mapper.StockServiceDtoMapper;
import com.github.devtorch.saga.stockservice.infrastructure.repository.MobileDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
    @Transactional
    public List<MobileResponseDto> createMany(List<MobileRequestDto> dtos) {
        var mobiles = mobileDeviceRepository.saveAll(dtos.stream()
                .map(stockServiceDtoMapper::toMobileDeviceEntity).toList());
        return mobiles.stream().map(stockServiceDtoMapper::toMobileResponseDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MobileResponseDto> getMobileDeviceById(UUID id) {
        var mobileDevice = mobileDeviceRepository.findMobileDeviceById(id);
        return Optional.ofNullable(mobileDevice).map(stockServiceDtoMapper::toMobileResponseDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<MobileResponseDto> getList(Pageable pageable) {
        Page<MobileDevice> mobileDevices = mobileDeviceRepository.findAll(pageable);
        return mobileDevices.map(stockServiceDtoMapper::toMobileResponseDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean isMobileAvailable(UUID mobileDeviceId, Integer quantity) {
        return mobileDeviceRepository.findMobileDeviceById(mobileDeviceId) != null
                && mobileDeviceRepository.findMobileDeviceById(mobileDeviceId).getQuantity() >= quantity;
    }
}
