package com.company;

import java.awt.*;

public class StrategyDirection implements  IStrategy {
    private static Color color;

    public StrategyDirection() {
        color = new Color(107, 0, 44);
    }

    public Color getColor() {
        return color;
    }

    public double[] Move(double old_x, double old_y, double old_vx, double old_vy) {
        double angle = Math.random() * Math.PI / 10 - (Math.PI / 20);
        double x, y, vx, vy;
        vx = Math.cos(angle) * old_vx - Math.sin(angle) * old_vy;
        vy = Math.sin(angle) * old_vx + Math.cos(angle) * old_vy;
        x = old_x + vx;
        y = old_y + vy;
        if(x<0) { x = -x;  vx = -vx; }
        if(x>1) { x = 2-x; vx = -vx; }
        if(y<0) { y = -y;  vy = -vy; }
        if(y>1) { y = 2-y; vy = -vy; }
        double[] return_values = new double[4];
        return_values[0] = x;
        return_values[1] = y;
        return_values[2] = vx;
        return_values[3] = vy;
        return return_values;
    }
}
