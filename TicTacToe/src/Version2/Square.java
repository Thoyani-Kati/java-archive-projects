package Version2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Square {
	public enum Type {
		EMPTY, Xsymbol, Osymbol;
	}

	public Type getSquareType() {
		return SquareType;
	}

	public void setSquareType(Type squareType) {
		SquareType = squareType;
	}

	public boolean isEmpty() {
		return this.SquareType.equals(Type.EMPTY);
	}

	private Type SquareType;
	private int x, y;
	public static final int SIZE = 100;

	public Square(int row, int col) {
		this.SquareType = Type.EMPTY;
		this.x = (col * SIZE);
		this.y = (row * SIZE);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void drawSquare(Graphics2D g2) {
		g2.setStroke(new BasicStroke(5));
		g2.setColor(Color.BLACK);
		g2.drawRect(x, y, SIZE, SIZE);
		if (this.SquareType == Type.Xsymbol) {
			g2.setColor(Color.BLUE);
			g2.drawLine(x + 10, y + 10, x + SIZE - 10, y + SIZE - 10);
			g2.drawLine(x + SIZE - 10, y + 10, x + 10, y + SIZE - 10);

		} else if (this.SquareType == Type.Osymbol) {
			g2.setColor(Color.RED);
			g2.drawOval(x + 10, y + 10, SIZE - 20, SIZE - 20);

		}
	}

}
