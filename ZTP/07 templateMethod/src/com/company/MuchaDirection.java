package com.company;

import java.awt.*;

public class MuchaDirection extends Mucha{
    private Color color;

    public MuchaDirection(){
        super();
        this.color = new Color(107, 0, 44);
    }

    public Color getColor() {
        return color;
    }
    public void move() {
        double angle = Math.random() * Math.PI / 10 - (Math.PI / 20);
        double temp = Math.cos(angle) * vx - Math.sin(angle) * vy;
        vy = Math.sin(angle) * vx + Math.cos(angle) * vy;
        vx = temp;
        x += vx;
        y += vy;
        if(x<0) { x = -x;  vx = -vx; }
        if(x>1) { x = 2-x; vx = -vx; }
        if(y<0) { y = -y;  vy = -vy; }
        if(y>1) { y = 2-y; vy = -vy; }
    }
}
