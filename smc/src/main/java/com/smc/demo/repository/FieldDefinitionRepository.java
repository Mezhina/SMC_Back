package com.smc.demo.repository;

import com.smc.demo.model.FieldDefinition;
import com.smc.demo.model.EntityType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FieldDefinitionRepository extends JpaRepository<FieldDefinition, String> {
    List<FieldDefinition> findByEntityOrderByOrdinalAsc(EntityType entity);
    List<FieldDefinition> findByEntity_IdOrderByOrdinalAsc(String entityId);
}

