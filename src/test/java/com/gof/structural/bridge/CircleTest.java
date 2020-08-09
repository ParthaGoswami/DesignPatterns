package com.gof.structural.bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void drawCircleUsingVectorRenderer() {

        Renderer renderer = new VectorRenderer();
        Shape shape = new Circle(renderer);
        final String result = shape.draw();
        assertEquals(result , "Drawing Circle Using  VectorRenderer Rendering.... ");

    }

    @Test
    void drawCircleUsingRastorRenderer() {


        Renderer renderer = new RastorRenderer();
        Shape shape = new Circle(renderer);
        final String result = shape.draw();
        assertEquals(result , "Drawing Circle Using RastorRenderer rendering...");
    }
}