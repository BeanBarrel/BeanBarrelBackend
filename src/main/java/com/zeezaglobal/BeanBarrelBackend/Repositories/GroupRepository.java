package com.zeezaglobal.BeanBarrelBackend.Repositories;

import com.zeezaglobal.BeanBarrelBackend.Entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {
}
