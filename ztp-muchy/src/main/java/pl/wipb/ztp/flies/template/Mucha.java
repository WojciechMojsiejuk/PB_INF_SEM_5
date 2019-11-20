package pl.wipb.ztp.flies.template;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

abstract class Mucha {

	private final double k = 0.01;
	double x, y; // pozycja muchy
	double vx, vy; // predkosc muchy
	protected Color color;

	public Mucha() {
		x = Math.random();
		y = Math.random();
		vx = k * (Math.random() - Math.random());
		vy = k * (Math.random() - Math.random());
	}
	public abstract Color getColor();


	public void draw(Graphics g) {
		g.setColor(getColor());
		Rectangle rc = g.getClipBounds();
		int a = (int)(x*rc.getWidth()),
			b = (int)(y*rc.getHeight());
		g.fillOval(a, b, 5, 5);
	}
	
	public abstract void move();
}