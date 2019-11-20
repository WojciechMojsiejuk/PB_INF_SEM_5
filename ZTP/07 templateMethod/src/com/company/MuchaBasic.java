package com.company;

import java.awt.*;

class MuchaBasic extends Mucha {
    private Color color;

    public MuchaBasic(){
        super();
        this.color = Color.BLACK;
    }

    public Color getColor() {
        return color;
    }

    public void move() {
        x += vx;
        y += vy;
        if(x<0) { x = -x;  vx = -vx; }
        if(x>1) { x = 2-x; vx = -vx; }
        if(y<0) { y = -y;  vy = -vy; }
        if(y>1) { y = 2-y; vy = -vy; }
    }
}
