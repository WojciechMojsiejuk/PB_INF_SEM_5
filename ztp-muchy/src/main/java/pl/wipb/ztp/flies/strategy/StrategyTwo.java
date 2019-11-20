package pl.wipb.ztp.flies.strategy;

import java.awt.*;

public class StrategyTwo implements Strategy {
    private Color color ;
    public StrategyTwo(){
        color = Color.blue;
    }
    private int X;
    private int Y;
    @Override
    public void Move(Mucha mucha) {
        double angle = Math.PI * 0.02;

        double x, y, vx, vy;
        vx = Math.cos(angle) * mucha.vx - Math.sin(angle) * mucha.vy;
        vy = Math.sin(angle) * mucha.vx + Math.cos(angle) * mucha.vy;
        x = mucha.x + vx;
        y = mucha.y + vy;
        if(x<0) { x = -x;  vx = -vx;  }
        if(x>1) { x = 2-x; vx = -vx; }
        if(y<0) { y = -y;  vx = -vx; }
        if(y>1) { y = 2-y; vx = -vx; }
        mucha.x=x;
        mucha.y=y;
        mucha.vx=vx;
        mucha.vy=vy;
    }

    public Color getColor() {
        return this.color;
    }
}
