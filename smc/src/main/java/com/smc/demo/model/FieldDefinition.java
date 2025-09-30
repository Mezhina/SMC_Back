package com.smc.demo.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "fields", uniqueConstraints = @UniqueConstraint(columnNames = {"entity_id", "name"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FieldDefinition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entity_id", nullable = false)
    private EntityType entity;

    @Column(nullable = false)
    private String name; // internal key

    private String label;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "data_type", nullable = false)
    private String dataType; // string, integer, decimal, boolean, date, json

    private Integer ordinal;

    private Boolean required;

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