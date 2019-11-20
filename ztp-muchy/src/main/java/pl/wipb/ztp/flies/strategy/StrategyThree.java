package pl.wipb.ztp.flies.strategy;

import java.awt.*;

public class StrategyThree implements Strategy {
    private Color color = Color.gray;
    @Override
    public void Move(Mucha mucha) {
        mucha.x += mucha.vx;
        mucha.y += mucha.vy;
        if(mucha.x<0) { mucha.x = -mucha.x; mucha.vx = -mucha.vx; }
        if(mucha.x>1) { mucha.x = 2-mucha.x;mucha.vx = -mucha.vx; }
        if(mucha.y<0) { mucha.y = -mucha.y; mucha.vy = -mucha.vy; }
        if(mucha.y>1) { mucha.y = 2-mucha.y;mucha.vy = -mucha.vy; }

    }

    @Override
    public Color getColor() {
        return this.color;
    }
}
