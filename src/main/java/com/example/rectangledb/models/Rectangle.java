package com.example.rectangledb.models;

import jakarta.persistence.*;

@Entity
@Table(name="rectangles")
public class Rectangle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String name;
    private String color;
    private int width;
    private int height;

    // Default constructor
    public Rectangle() {
        // Default constructor is required by JPA
    }

    public Rectangle(String name, String color, int width, int height) {
        this.name = name;
        this.color = color;
        this.width = width;
        this.height = height;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
}
