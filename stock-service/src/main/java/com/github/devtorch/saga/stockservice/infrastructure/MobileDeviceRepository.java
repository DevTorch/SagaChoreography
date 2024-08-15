package com.github.devtorch.saga.stockservice.infrastructure;

import com.github.devtorch.saga.stockservice.domain.MobileDevice;
import com.github.devtorch.saga.stockservice.domain.MobileDeviceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileDeviceRepository extends JpaRepository<MobileDevice, MobileDeviceId> {
}
