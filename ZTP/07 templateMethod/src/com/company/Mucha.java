package com.company;

import java.awt.*;

public abstract class Mucha {
    double x, y; // pozycja muchy
    double vx, vy; // predkosc muchy

    protected Mucha()	{
        double k = 0.01;
        x = Math.random();
        y = Math.random();
        vx = k *(Math.random() - Math.random());
        vy = k *(Math.random() - Math.random());
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        Rectangle rc = g.getClipBounds();
        int a = (int)(x*rc.getWidth()),
                b = (int)(y*rc.getHeight());
        g.fillOval(a, b, 5, 5);
    }

    public void move(){
        calculatePosition();
    }

    protected abstract void calculatePosition();
    protected abstract Color getColor();
}
