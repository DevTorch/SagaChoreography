package com.github.devtorch.saga.stockservice.infrastructure;

import com.github.devtorch.saga.stockservice.domain.MobileDevice;
import com.github.devtorch.saga.stockservice.domain.MobileDeviceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileDeviceRepository extends JpaRepository<MobileDevice, MobileDeviceId> {

    @Query("select m from MobileDevice m where m.id = :id")
    MobileDevice findMobileDeviceById(MobileDeviceId id);
}
