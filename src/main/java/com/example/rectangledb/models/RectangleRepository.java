package com.example.rectangledb.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RectangleRepository extends JpaRepository<Rectangle,Integer> {
    List<Rectangle> findByWidth(int width);
    List<Rectangle> findByHeight(int height);
    List<Rectangle> findByNameAndColor(String name, String color);
}
