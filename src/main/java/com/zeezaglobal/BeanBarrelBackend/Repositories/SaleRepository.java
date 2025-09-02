package com.zeezaglobal.BeanBarrelBackend.Repositories;

import com.zeezaglobal.BeanBarrelBackend.Entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    Sale findByBillNumber(Long billNumber);

    List<Sale> findByStoreAndDateTimeBetween(int store, LocalDateTime start, LocalDateTime end);
}
