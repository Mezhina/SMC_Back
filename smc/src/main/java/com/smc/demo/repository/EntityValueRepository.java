package com.smc.demo.repository;

import com.smc.demo.entity.EntityValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntityValueRepository extends JpaRepository<EntityValue, Integer> {
    
    // Найти по entity_id
    List<EntityValue> findByEntityId(String entityId);
    
    // Найти по field_id
    List<EntityValue> findByFieldId(String fieldId);
    
    // Найти по entity_id и field_id
    EntityValue findByEntityIdAndFieldId(String entityId, String fieldId);
    
    // Найти по значению (частичное совпадение)
    List<EntityValue> findByValueContainingIgnoreCase(String value);
}

