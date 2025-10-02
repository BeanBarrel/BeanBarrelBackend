package com.zeezaglobal.BeanBarrelBackend.Repositories;

import com.zeezaglobal.BeanBarrelBackend.Entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    Optional<Sale> findByBillNumber(Long billNumber);

    Page<Sale> findByStoreAndDateTimeBetween(
            int store,
            LocalDateTime start,
            LocalDateTime end,
            Pageable pageable
    );

    @Query("SELECT FUNCTION('DATE_FORMAT', s.dateTime, '%Y-%m') AS month, COUNT(s), SUM(s.totalAmount) " +
            "FROM Sale s GROUP BY FUNCTION('DATE_FORMAT', s.dateTime, '%Y-%m') ORDER BY month")
    List<Object[]> getMonthlySalesSummary();

    @Query("SELECT s.paymentMethod, COUNT(s) FROM Sale s GROUP BY s.paymentMethod")
    List<Object[]> getSalesByPaymentMethod();

    @Query("SELECT s.status, COUNT(s) FROM Sale s GROUP BY s.status")
    List<Object[]> getSalesByStatus();

    @Query("SELECT s.store, SUM(s.totalAmount) FROM Sale s GROUP BY s.store")
    List<Object[]> getStoreSales();
}
