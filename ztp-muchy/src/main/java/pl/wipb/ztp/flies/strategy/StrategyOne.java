package pl.wipb.ztp.flies.strategy;

import java.awt.*;

public class StrategyOne implements Strategy {
    private Color color ;
    private Boolean clock;
    public StrategyOne()
    {
        color = Color.black;
        if(Math.random() < 0.5)
            clock = true;
        else
            clock = false;
    }
    @Override
    public void Move(Mucha mucha) {
        double angle = Math.PI * 0.02;
        if(!clock)
            angle=-angle;
        double x, y, vx, vy;
        vx = Math.cos(angle) * mucha.vx - Math.sin(angle) * mucha.vy;
        vy = Math.sin(angle) * mucha.vx + Math.cos(angle) * mucha.vy;
        x = mucha.x + vx;
        y = mucha.y + vy;
        if(x<0) { x = -x;  vx = -vx; vy = -vy;  clock=!clock;}
        if(x>1) { x = 2-x; vx = -vx; vy = -vy;  clock=!clock;}
        if(y<0) { y = -y;  vx = -vx; vy = -vy;  clock=!clock;}
        if(y>1) { y = 2-y; vx = -vx; vy = -vy;  clock=!clock;}
        mucha.x=x;
        mucha.y=y;
        mucha.vx=vx;
        mucha.vy=vy;
        /*mucha.x += mucha.vx;
        mucha.y += mucha.vy;
        if(mucha.x<0) { mucha.x = -mucha.x; mucha.vx = -mucha.vx; }
        if(mucha.x>1) { mucha.x = 2-mucha.x;mucha.vx = -mucha.vx; }
        if(mucha.y<0) { mucha.y = -mucha.y; mucha.vy = -mucha.vy; }
        if(mucha.y>1) { mucha.y = 2-mucha.y;mucha.vy = -mucha.vy; }*/

    }

    @Override
    public Color getColor() {
        return this.color;
    }
}
