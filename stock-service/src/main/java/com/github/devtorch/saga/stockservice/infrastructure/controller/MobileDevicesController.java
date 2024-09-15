package com.github.devtorch.saga.stockservice.infrastructure.controller;

import com.github.devtorch.saga.stockservice.domain.dto.MobileRequestDto;
import com.github.devtorch.saga.stockservice.domain.dto.MobileResponseDto;
import com.github.devtorch.saga.stockservice.infrastructure.service.MobileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/mobile")
@RequiredArgsConstructor
public class MobileDevicesController {

    private final MobileService mobileDeviceService;

    @GetMapping("/{id}")
    public ResponseEntity<MobileResponseDto> getOne(@PathVariable UUID id) {
        var mobileDevice = mobileDeviceService.getMobileDeviceById(id);
        return mobileDevice.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public Page<MobileResponseDto> getList(Pageable pageable) {
        return mobileDeviceService.getList(pageable);
    }

    @PostMapping
    public ResponseEntity<MobileResponseDto> addNewMobileDevice(@RequestBody @Valid MobileRequestDto dto) {
        var response = mobileDeviceService.addNewMobileDevice(dto);
        return response == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(response);
    }

    @PostMapping("/bulk")
    public List<MobileResponseDto> addNewManyMobileDevices(@RequestBody @Valid List<MobileRequestDto> dtos) {
        return mobileDeviceService.createMany(dtos);
    }
}

