package pl.wipb.ztp.flies.strategy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

class Mucha {
	private Color color;
	private final double k = 0.01;
	double x, y; // pozycja muchy
	double vx, vy; // predkosc muchy

	private Strategy strategy;

	public Mucha() {

		x = Math.random();
		y = Math.random();
		vx = k * (Math.random() - Math.random());
		vy = k * (Math.random() - Math.random());

	}
	public void SetStrategy(Strategy strategy)
	{
		this.strategy = strategy;
	}

	public void draw(Graphics g) {
		g.setColor(strategy.getColor());
		Rectangle rc = g.getClipBounds();
		int a = (int)(x*rc.getWidth()),
			b = (int)(y*rc.getHeight());
		g.fillOval(a, b, 5, 5);
	}
	
	public void move() {
		strategy.Move(Mucha.this);

	}
}