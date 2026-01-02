package Version2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Version2.Square.Type;

public class Gameboard extends JPanel {
	private GameBoardData data = new GameBoardData();

	public Gameboard() {
		this.setBoardSize();
		this.setFocusable(true);
		this.requestFocusInWindow(true);
		this.setPreferredSize(new Dimension(Integer.parseInt(data.boardSize) * Square.SIZE + Square.SIZE * 2,
				Integer.parseInt(data.boardSize) * Square.SIZE + Square.SIZE * 2));
		this.setVisible(true);
		this.setBackground(Color.GRAY);

		this.setBoard();
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				data.selectedSquare = getSquare(e.getX(), e.getY());
				if (data.gameOn ? isValidMove() : false) {
					move();
					data.XplayerTurn = !data.XplayerTurn;
				} else {

				}
			}
		});

		JFrame frame = new JFrame("TIC TAC TOE");
		this.setBorder(BorderFactory.createTitledBorder("Game Board"));
		frame.setResizable(false);
		frame.add(this);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setForeground(Color.GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public boolean checkWin() {
		boolean won = false;
		int selectedSquareCol = (data.selectedSquare.getX() - Square.SIZE) / Square.SIZE,
				selectedSquareRow = (data.selectedSquare.getY() - Square.SIZE) / Square.SIZE;

		// moving horizontal(left -> <- right)
		for (int left = 0, right = data.gameBoard.length - 1; left <= right; left++, right--) {
			if (!(isSameType(data.gameBoard[selectedSquareRow][left])
					&& isSameType(data.gameBoard[selectedSquareRow][right]))) {
				won = false;
				break;

			}
			won = true;

		}

		if (won) {
			data.horizontalWin = 1;
			return true;
		}

		// moving Vertically(top -> bottom )
		for (int top = 0, bottom = data.gameBoard.length - 1; top <= bottom; top++, bottom--) {
			if (!(isSameType(data.gameBoard[top][selectedSquareCol])
					&& isSameType(data.gameBoard[bottom][selectedSquareCol]))) {
				won = false;
				break;

			}
			won = true;

		}
		if (won) {
			data.horizontalWin = -1;
			return true;
		}

		// for diagonal entries we use diagonal equations defined by y = +/-m*x + c to
		// check
		// if the selected square lies on one of the lines defined by the .
		// If yes then we can check.
		// Mathematically ,we know that gradient of a slope is denoted by ' m ' and
		// the constant with which the standard function is shifted is denoted by ' c ',
		// hence we have the following.

		int m = (-this.getY() - (-this.getHeight())) / (this.getX() - (this.getWidth())),
				x = data.selectedSquare.getX(), // x coordinate of the selected square.
				c = (-this.getY() - m * this.getX()), calculated_Y1 = m * x + c;// Equation of the diagonal line(left
																				// to// right)

		c = -this.getY() - (-m * (this.getWidth() - Square.SIZE));
		int calculated_Y2 = -m * x + c;// Equation of the diagonal line(right to left)

		if (Math.abs(calculated_Y2) == data.selectedSquare.getY()
				|| Math.abs(calculated_Y1) == data.selectedSquare.getY()) {// If the selectedSquare lies in any of the diagonal
																			// lines.
			int lastIndex = data.gameBoard.length - 1;//Square on the far most right
			boolean isTopRight, isTopLeft = isTopRight = true;

			for (int topLeft = 0, topRight = lastIndex; topLeft <= topRight; topLeft++, topRight--) {
				// Checking from topRight and bottomLeft simultaneously towards each other.
				if (!(isSameType(data.gameBoard[topRight][lastIndex - topRight])
						&& isSameType(data.gameBoard[lastIndex - topRight][topRight])))
					isTopRight = false;
				// Checking from topLeft and bottomRight simultaneously towards each other.
				if (!(isSameType(data.gameBoard[topLeft][topLeft])
						&& isSameType(data.gameBoard[lastIndex - topLeft][lastIndex - topLeft])))
					isTopLeft = false;
				// As soon as both checks fail, stop checking(exit the loop).
				if (!(isTopRight || isTopLeft))
					break;

			}

			if (isTopLeft)
				data.LeftRightdiagonalWin = 1;
			else if (isTopRight)
				data.LeftRightdiagonalWin = -1;
			won = isTopRight || isTopLeft;
		}

		return won;
	}

	public void move() {
		System.out.println("data.XplayerTurn = " + data.XplayerTurn);
		if (data.XplayerTurn) {
			data.selectedSquare.setSquareType(Type.Xsymbol);
			repaint();
			if (checkWin()) {
				data.gameOn = false;
				repaint();
				JOptionPane.showMessageDialog(this, "Congradulations to Xplayer, ", "GAME RESULTS",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} else {
			data.selectedSquare.setSquareType(Type.Osymbol);
			repaint();
			if (checkWin()) {
				data.gameOn = false;
				repaint();
				JOptionPane.showMessageDialog(this, "Congradulations to Oplayer", "GAME RESULTS",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void setBoardSize() {
		while (data.boardSize == null) {
			this.data.boardSize = JOptionPane.showInputDialog("Please enter your prefered Board size");
			try {
				Integer.parseInt(data.boardSize);
			} catch (NumberFormatException e) {
				data.boardSize = null;
				JOptionPane.showMessageDialog(this, "Please Enter an Integer ", "INVALID INPUT",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void setBoard() {
		int size = Integer.parseInt(data.boardSize);
		this.data.gameBoard = new Square[size][size];
		for (int i = 0, j = 0; i < size;) {
			this.data.gameBoard[i][j] = new Square(i + 1, j++ + 1);
			if (j == size) {
				j = 0;
				i++;
			}
		}
		this.data.gameOn = true;
	}

	private boolean isValidPoint(int x, int y) {
		return x > Square.SIZE && y > Square.SIZE && y < this.getHeight() - Square.SIZE
				&& x < this.getWidth() - Square.SIZE;
	}

	private boolean isSameType(Square square) {
		return data.selectedSquare.getSquareType().equals(square.getSquareType());
	}

	public Square getSquare(int x, int y) {
		return isValidPoint(x, y) ? data.gameBoard[(y - Square.SIZE) / Square.SIZE][(x - Square.SIZE) / Square.SIZE]
				: null;
	}

	public boolean isValidMove() {
		if (data.selectedSquare != null ? data.selectedSquare.isEmpty() : false)
			return true;
		JOptionPane.showMessageDialog(this, "Please selected an unoccupied square", "INVALID MOVE",
				JOptionPane.ERROR_MESSAGE);
		return false;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (Square[] squares : data.gameBoard)
			for (Square square : squares)
				square.drawSquare((Graphics2D) g);

		if (!data.gameOn) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(5));
			g2.setColor(new Color(234, 222, 239));

			if (data.LeftRightdiagonalWin == 1)
				g2.drawLine(Square.SIZE, Square.SIZE, this.getWidth() - Square.SIZE, this.getHeight() - Square.SIZE);
			else if (data.LeftRightdiagonalWin == -1)
				g2.drawLine(this.getWidth() - Square.SIZE, Square.SIZE, Square.SIZE, this.getHeight() - Square.SIZE);

			if (data.horizontalWin == 1)
				g2.drawLine(Square.SIZE, data.selectedSquare.getY() + Square.SIZE / 2, this.getWidth() - Square.SIZE,
						data.selectedSquare.getY() + Square.SIZE / 2);
			else if (data.horizontalWin == -1)
				g2.drawLine(data.selectedSquare.getX() + Square.SIZE / 2, Square.SIZE,
						data.selectedSquare.getX() + Square.SIZE / 2, this.getHeight() - Square.SIZE);

		}

	}

}
