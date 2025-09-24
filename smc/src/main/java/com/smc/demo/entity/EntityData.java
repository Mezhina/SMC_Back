package com.smc.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "entities")
public class EntityData {
    
    @Id
    @Column(name = "id")
    private String id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "label", nullable = false)
    private String label;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "nameFieldLabel", nullable = false)
    private String nameFieldLabel;
    
    @Column(name = "color")
    private String color;
    
    @Column(name = "icon")
    private String icon;
    
    @Column(name = "visible")
    private Boolean visible;
    
    @Column(name = "howOwner")
    private String howOwner;
    
    @Column(name = "showDivision")
    private Boolean showDivision;
    
    
    

    // Конструкторы
    public EntityData() {}

    public EntityData(String id, String name, String label, String description, String nameFieldLabel, 
                     String color, String icon, Boolean visible, String howOwner, Boolean showDivision) {
        this.id = id;
        this.name = name;
        this.label = label;
        this.description = description;
        this.nameFieldLabel = nameFieldLabel;
        this.color = color;
        this.icon = icon;
        this.visible = visible;
        this.howOwner = howOwner;
        this.showDivision = showDivision;
    }

    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNameFieldLabel() {
        return nameFieldLabel;
    }

    public void setNameFieldLabel(String nameFieldLabel) {
        this.nameFieldLabel = nameFieldLabel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getHowOwner() {
        return howOwner;
    }

    public void setHowOwner(String howOwner) {
        this.howOwner = howOwner;
    }

    public Boolean getShowDivision() {
        return showDivision;
    }

    public void setShowDivision(Boolean showDivision) {
        this.showDivision = showDivision;
    }




    @Override
    public String toString() {
        return "EntityData{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", label='" + label + '\'' +
               ", description='" + description + '\'' +
               ", nameFieldLabel='" + nameFieldLabel + '\'' +
               ", color='" + color + '\'' +
               ", icon='" + icon + '\'' +
               ", visible=" + visible +
               ", howOwner='" + howOwner + '\'' +
               ", showDivision=" + showDivision +
               '}';
    }
}