package com.github.devtorch.saga.stockservice.infrastructure.repository;

import com.github.devtorch.saga.stockservice.domain.MobileDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MobileDeviceRepository extends JpaRepository<MobileDevice, UUID> {

    @Query("select m from MobileDevice m where m.id = :id")
    MobileDevice findMobileDeviceById(UUID id);
}
