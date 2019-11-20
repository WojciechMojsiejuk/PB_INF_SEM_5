package com.company;

import java.awt.*;

public class StrategyCircle implements IStrategy{
    private Color color;
    private Boolean clockwise;

    public StrategyCircle() {
        color = new Color(0, 90, 197);
        if(Math.random() < 0.5)
            clockwise = true;
        else
            clockwise = false;
    }

    public Color getColor() {
        return color;
    }

    public double[] Move(double old_x, double old_y, double old_vx, double old_vy) {
        double angle = Math.PI * 0.02;
        if (!clockwise)
            angle = -angle;
        double x, y, vx, vy;
        vx = Math.cos(angle) * old_vx - Math.sin(angle) * old_vy;
        vy = Math.sin(angle) * old_vx + Math.cos(angle) * old_vy;
        x = old_x + vx;
        y = old_y + vy;
        if(x<0) { x = -x;  vx = -vx; vy = -vy; clockwise = !clockwise; }
        if(x>1) { x = 2-x; vx = -vx; vy = -vy; clockwise = !clockwise; }
        if(y<0) { y = -y;  vx = -vx; vy = -vy; clockwise = !clockwise; }
        if(y>1) { y = 2-y; vx = -vx; vy = -vy; clockwise = !clockwise; }
        double[] return_values = new double[4];
        return_values[0] = x;
        return_values[1] = y;
        return_values[2] = vx;
        return_values[3] = vy;
        return return_values;
    }
}
