package com.company;

import java.awt.*;

class MuchaCircle extends Mucha{
    private Color color;
    private Boolean clockwise;

    public MuchaCircle(){
        super();
        this.color = new Color(0, 90, 197);
        if(Math.random() < 0.5)
            clockwise = true;
        else
            clockwise = false;
    }

    public Color getColor() {
        return color;
    }
    public void calculatePosition() {
        double angle = Math.PI * 0.02;
        if (!clockwise)
            angle = -angle;
        double temp = Math.cos(angle) * vx - Math.sin(angle) * vy;
        vy = Math.sin(angle) * vx + Math.cos(angle) * vy;
        vx = temp;
        x += vx;
        y += vy;
        if(x<0) { x = -x;  vx = -vx; vy = -vy; clockwise = !clockwise; }
        if(x>1) { x = 2-x; vx = -vx; vy = -vy; clockwise = !clockwise; }
        if(y<0) { y = -y;  vx = -vx; vy = -vy; clockwise = !clockwise; }
        if(y>1) { y = 2-y; vx = -vx; vy = -vy; clockwise = !clockwise; }
    }

}
