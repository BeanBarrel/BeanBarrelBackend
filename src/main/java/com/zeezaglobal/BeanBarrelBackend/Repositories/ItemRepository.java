package com.zeezaglobal.BeanBarrelBackend.Repositories;

import com.zeezaglobal.BeanBarrelBackend.Entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}