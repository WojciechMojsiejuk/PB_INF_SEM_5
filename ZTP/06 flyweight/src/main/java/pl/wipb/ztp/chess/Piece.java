package pl.wipb.ztp.chess;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

interface IPiece {
	int TILESIZE = 32;
	void draw( Graphics2D g, int x, int y);
	IPiece getPiece();
}

class Piece implements  IPiece {
	private static Image image;
	private static Map<Integer, Piece> pieces = new HashMap<>();
	
	static {
		try {
			image = Chessboard.loadImage("/img/pieces4.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int index;

	private Piece(int idx) {
		index = idx;
	}

	public static Piece getPiece(int id) {
		if (!pieces.containsKey(id))
			pieces.put(id, new Piece(id));
		return pieces.get(id);
	}

	public void draw(Graphics2D g, int x, int y) {
		g.drawImage(image, x, y, x + 1, y + 1, index * TILESIZE, 0, (index + 1) * TILESIZE, TILESIZE,
				null);
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

	public void draw(Graphics2D g, int x, int y) {
		AffineTransform temp = g.getTransform();
		g.transform(affineTransform);
		this.piece.draw(g, x, y);
		g.setTransform(temp);
	}

	public IPiece getPiece() { return this.piece; }
}