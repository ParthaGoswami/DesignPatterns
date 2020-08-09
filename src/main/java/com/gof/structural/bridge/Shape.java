package com.gof.structural.bridge;

public abstract class Shape {

    private Renderer renderer;

    public Shape(Renderer renderer){
        this.renderer = renderer;
    }

    public Renderer getRenderer(){
        return renderer;
    }

    public abstract String draw();

}
