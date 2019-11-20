package pl.wipb.ztp.flies.template;

import java.awt.*;

public class MuchaZmiana extends Mucha {
    private Boolean clock;
    public MuchaZmiana()
    {
        this.color=Color.blue;
        if(Math.random() < 0.5)
            clock = true;
        else
            clock = false;
    }
    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void move() {
        double angle = Math.PI * 0.02;
        if(!clock)
            angle=-angle;
        double x, y, vx, vy;
        vx = Math.cos(angle) * this.vx - Math.sin(angle) * this.vy;
        vy = Math.sin(angle) * this.vx + Math.cos(angle) * this.vy;
        x = this.x + vx;
        y = this.y + vy;
        if(x<0) { x = -x;  vx = -vx; vy = -vy;  clock=!clock;}
        if(x>1) { x = 2-x; vx = -vx; vy = -vy;  clock=!clock;}
        if(y<0) { y = -y;  vx = -vx; vy = -vy;  clock=!clock;}
        if(y>1) { y = 2-y; vx = -vx; vy = -vy;  clock=!clock;}
        this.x=x;
        this.y=y;
        this.vx=vx;
        this.vy=vy;
    }
}
