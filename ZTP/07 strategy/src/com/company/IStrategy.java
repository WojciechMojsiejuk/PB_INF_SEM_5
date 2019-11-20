package com.company;

import java.awt.*;

interface IStrategy {
    double[] Move(double x, double y, double vx, double vy);
    Color getColor();
}
