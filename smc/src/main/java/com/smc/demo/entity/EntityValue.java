package com.smc.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "entity_values")
public class EntityValue {
    
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "field_id")
    private String fieldId;
    
    @Column(name = "entity_id")
    private String entityId;
    
    @Column(name = "`value`")
    private String value;
    
    @Column(name = "createdDate")
    private LocalDateTime createdDate;
    
    @Column(name = "createdBy")
    private String createdBy;
    
    @Column(name = "updatedDate")
    private LocalDateTime updatedDate;
    
    @Column(name = "updatedBy")
    private String updatedBy;
    
    // Конструкторы
    public EntityValue() {}
    
    public EntityValue(Integer id, String fieldId, String entityId, String value, 
                      LocalDateTime createdDate, String createdBy, LocalDateTime updatedDate, String updatedBy) {
        this.id = id;
        this.fieldId = fieldId;
        this.entityId = entityId;
        this.value = value;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.updatedDate = updatedDate;
        this.updatedBy = updatedBy;
    }
    
    // Геттеры и сеттеры
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getFieldId() {
        return fieldId;
    }
    
    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }
    
    public String getEntityId() {
        return entityId;
    }
    
    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
    
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
    
    public String getCreatedBy() {
        return createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    
    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }
    
    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
    
    public String getUpdatedBy() {
        return updatedBy;
    }
    
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    
    @Override
    public String toString() {
        return "EntityValue{" +
               "id=" + id +
               ", fieldId='" + fieldId + '\'' +
               ", entityId='" + entityId + '\'' +
               ", value='" + value + '\'' +
               ", createdDate=" + createdDate +
               ", createdBy='" + createdBy + '\'' +
               ", updatedDate=" + updatedDate +
               ", updatedBy='" + updatedBy + '\'' +
               '}';
    }
}