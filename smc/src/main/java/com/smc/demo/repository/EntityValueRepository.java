package com.smc.demo.repository;


import com.smc.demo.model.EntityValue;
import com.smc.demo.model.FieldDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EntityValueRepository extends JpaRepository<EntityValue, String> {
    List<EntityValue> findByField_IdAndRecordId(String fieldId, String recordId);
    List<EntityValue> findByRecordId(String recordId);
    List<EntityValue> findByField_Entity_IdAndRecordId(String entityId, String recordId);
    List<EntityValue> findByField_Entity_Id(String entityId);
    List<EntityValue> findByField_Entity_IdAndField_Id(String entityId, String fieldId);
    List<EntityValue> findByField_Entity_IdAndField_Name(String entityId, String fieldName);
}