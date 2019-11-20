package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Mucha {
    private final double k = 0.01;
    private IStrategy iStrategy;
    double x, y; // pozycja muchy
    double vx, vy; // predkosc muchy

    public Mucha(IStrategy iStrategy)	{
        this.iStrategy = iStrategy;
        x = Math.random();
        y = Math.random();
        vx = k*(Math.random() - Math.random());
        vy = k*(Math.random() - Math.random());
    }

    public void draw(Graphics g) {
        g.setColor(iStrategy.getColor());
        Rectangle rc = g.getClipBounds();
        int a = (int)(x*rc.getWidth()),
                b = (int)(y*rc.getHeight());
        g.fillOval(a, b, 5, 5);
    }
    public void move() {
        double[] values = iStrategy.Move(x, y, vx, vy);
        x = values[0];
        y = values[1];
        vx = values[2];
        vy = values[3];
    }
}

public class Muchy extends JPanel implements Runnable {
    private Mucha[] ar;
    public Muchy()	{
        this.setPreferredSize(new Dimension(640, 480));
        ar = new Mucha[30];
        for(int i = 0; i < ar.length; ++i){
            if (Math.random() < 0.5)
                ar[i] = new Mucha(new StrategyDirection());
            else
                ar[i] = new Mucha(new StrategyCircle());
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(int i = 0; i < ar.length; ++i)
            ar[i].draw(g);
    }

    public void run() {
        while (true) {
            for(int i = 0; i < ar.length; ++i)
                ar[i].move();
            repaint();
            try {
                Thread.currentThread().sleep(20);
            } catch(InterruptedException e){ e.printStackTrace();}
        }
    }

    public static void main(String[] args)	{
        JFrame frame = new JFrame("Muchy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Muchy m = new Muchy();
        frame.getContentPane().add(m);
        frame.pack();
        frame.setVisible(true);
        new Thread(m).start();
    }
}