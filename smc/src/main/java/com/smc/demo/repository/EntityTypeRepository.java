package com.smc.demo.repository;


import com.smc.demo.model.EntityType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EntityTypeRepository extends JpaRepository<EntityType, String> {
    Optional<EntityType> findByCode(String code);
}
