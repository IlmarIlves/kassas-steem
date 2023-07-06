package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer quantity;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "baking_item_id")
    private BakingItem bakingItem;

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BakingItem getBakingItem() {
        return bakingItem;
    }

    public void setBakingItem(BakingItem bakingItem) {
        this.bakingItem = bakingItem;
    }
}
