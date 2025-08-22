package com.zeezaglobal.BeanBarrelBackend.Repositories;

import com.zeezaglobal.BeanBarrelBackend.Entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    Sale findByBillNumber(Long billNumber);
}
