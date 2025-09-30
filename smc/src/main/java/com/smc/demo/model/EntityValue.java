package com.smc.demo.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "entity_values", uniqueConstraints = @UniqueConstraint(columnNames = {"field_id", "record_id"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntityValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    // link to field definition
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_id", nullable = false)
    private FieldDefinition field;

    // id of the record instance (application defined). Можно использовать UUID, Long и т.д.
    @Column(name = "record_id", nullable = false)
    private String recordId;

    // value always stored as text (парсится по field.dataType)
    @Column(columnDefinition = "TEXT")
    private String value;

    private Instant createdAt;
    private Instant updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
        updatedAt = createdAt;
    }
    @PreUpdate
    public void preUpdate() {
        updatedAt = Instant.now();
    }
}