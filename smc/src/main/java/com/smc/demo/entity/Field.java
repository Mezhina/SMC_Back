package com.smc.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fields")
public class Field {
    
    @Id
    @Column(name = "id")
    private String id;
    
    @Column(name = "entities_id")
    private String entitiesId;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "label")
    private String label;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "unique")
    private Boolean unique;
    
    @Column(name = "readOnly")
    private Boolean readOnly;
    
    @Column(name = "required")
    private Boolean required;
    
    @Column(name = "createdDate")
    private LocalDateTime createdDate;
    
    @Column(name = "createdBy")
    private String createdBy;
    
    @Column(name = "updatedDate")
    private LocalDateTime updatedDate;
    
    @Column(name = "updatedBy")
    private String updatedBy;

    // Конструкторы
    public Field() {}

    public Field(String id, String entitiesId, String name, String label, String type, 
                Boolean unique, Boolean readOnly, Boolean required,
                LocalDateTime createdDate, String createdBy, LocalDateTime updatedDate, String updatedBy) {
        this.id = id;
        this.entitiesId = entitiesId;
        this.name = name;
        this.label = label;
        this.type = type;
        this.unique = unique;
        this.readOnly = readOnly;
        this.required = required;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.updatedDate = updatedDate;
        this.updatedBy = updatedBy;
    }

    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntitiesId() {
        return entitiesId;
    }

    public void setEntitiesId(String entitiesId) {
        this.entitiesId = entitiesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getUnique() {
        return unique;
    }

    public void setUnique(Boolean unique) {
        this.unique = unique;
    }

    public Boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
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
        return "Field{" +
               "id='" + id + '\'' +
               ", entitiesId='" + entitiesId + '\'' +
               ", name='" + name + '\'' +
               ", label='" + label + '\'' +
               ", type='" + type + '\'' +
               ", unique=" + unique +
               ", readOnly=" + readOnly +
               ", required=" + required +
               ", createdDate=" + createdDate +
               ", createdBy='" + createdBy + '\'' +
               ", updatedDate=" + updatedDate +
               ", updatedBy='" + updatedBy + '\'' +
               '}';
    }
}
