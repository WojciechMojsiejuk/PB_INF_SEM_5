package pl.wipb.ztp.chess;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.io.IOException;

interface IPiece {
	int TILESIZE = 32;
	void draw( Graphics2D g);
	int getX();
	int getY();
	void moveTo(int xx, int yy);
	IPiece getPiece();
}

class Piece implements  IPiece {
	private static Image image;
	
	static {
		try {
			image = Chessboard.loadImage("/img/pieces4.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int index, x, y;

	public Piece(int idx, int xx, int yy) {
		index = idx;
		x = xx;
		y = yy;
	}

	public void draw(Graphics2D g) {
		g.drawImage(image, x, y, x + 1, y + 1, index * TILESIZE, 0, (index + 1) * TILESIZE, TILESIZE,
				null);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void moveTo(int xx, int yy) {
		x = xx;
		y = yy;
	}

	public IPiece getPiece() { return null; }
}

class DecoratorPiece implements IPiece {
	private IPiece piece;
	private AffineTransform affineTransform;

	public DecoratorPiece(IPiece piece, AffineTransform affineTransform) {
		this.piece = piece;
		this.affineTransform = affineTransform;
	}

	public void draw(Graphics2D g) {
		AffineTransform temp = g.getTransform();
		g.transform(affineTransform);
		this.piece.draw(g);
		g.setTransform(temp);
	}

	public int getX() { return this.piece.getX(); }

	public int getY() { return this.piece.getY(); }

	public void moveTo(int xx, int yy) { this.piece.moveTo(xx, yy);	}

	public IPiece getPiece() { return this.piece; }
}