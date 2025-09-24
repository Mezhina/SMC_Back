package com.smc.demo.repository;

import com.smc.demo.entity.EntityData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository extends JpaRepository<EntityData, String> {
}
