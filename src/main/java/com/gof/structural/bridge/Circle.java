package com.gof.structural.bridge;

public class Circle extends Shape {

    public Circle(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String draw() {
        return "Drawing Circle Using " + getRenderer().render();
    }
}
