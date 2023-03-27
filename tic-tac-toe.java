import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;

public class CrossesZeros extends GraphicsProgram {
	private static final int BOARD_WIDTH = 700;
	private static final int BOARD_HEIGHT = 700;
	private GRect square11;
	private GRect square12;
	private GRect square13;
	private GRect square21;
	private GRect square22;
	private GRect square23;
	private GRect square31;
	private GRect square32;
	private GRect square33;
	private double squareWidth = BOARD_WIDTH / 3;
	private double squareHeight = BOARD_HEIGHT / 3;
	private int move;
	private int randomNumber;
	private String fill11 = "";
	private String fill12 = "";
	private String fill13 = "";
	private String fill21 = "";
	private String fill22 = "";
	private String fill23 = "";
	private String fill31 = "";
	private String fill32 = "";
	private String fill33 = "";
	private GPoint mouseClick;
	Color purple = new Color(203, 152, 205);

	public void run() {
		this.setSize(BOARD_WIDTH + 3, BOARD_HEIGHT + 103);
		addMouseListeners();
		removeAll();
		drawBoard();
		//addKeyListeners();
		move = 1;
	}
	/*
	 * draw a cross or a zero in the cell selected by the mouse
	 */
	public void mousePressed(MouseEvent e) {
		if (move <= 9 && chooseWinner() == "") {
			boolean moveOk;
			mouseClick = new GPoint(e.getPoint());
			GObject object = getElementAt(mouseClick);
			moveOk = drawXOrO(object);
			endTheGame();
			
				if (move <= 9 && moveOk && chooseWinner() == "") {
					computerPlay();
					endTheGame();
				}
			}
	}
	public void keyPressed(KeyEvent e){
		
	}
	/*
	 * the computer randomly selects a cell where it draws a cross or a zero
	 */
	private void computerPlay() {
		boolean findEmptysquare = false;
		while (!findEmptysquare) {
			randomNumber = randomGenerator.nextInt(1, 9);
			if (randomNumber == 1 && fill11 == "") {
				findEmptysquare = true;
				drawXOrO(square11);
			}
			if (randomNumber == 2 && fill12 == "") {
				findEmptysquare = true;
				drawXOrO(square12);
			}
			if (randomNumber == 3 && fill13 == "") {
				findEmptysquare = true;
				drawXOrO(square13);
			}
			if (randomNumber == 4 && fill21 == "") {
				findEmptysquare = true;
				drawXOrO(square21);
			}
			if (randomNumber == 5 && fill22 == "") {
				findEmptysquare = true;
				drawXOrO(square22);
			}
			if (randomNumber == 6 && fill23 == "") {
				findEmptysquare = true;
				drawXOrO(square23);
			}
			if (randomNumber == 7 && fill31 == "") {
				findEmptysquare = true;
				drawXOrO(square31);
			}
			if (randomNumber == 8 && fill32 == "") {
				findEmptysquare = true;
				drawXOrO(square32);
			}
			if (randomNumber == 9 && fill33 == "") {
				findEmptysquare = true;
				drawXOrO(square33);
			}
		}
	}

	/*
	 * method that draws a cross or a zero
	 */
	private boolean drawXOrO(GObject object) {
		if (object.equals(square11) && fill11 == "") {
			if (move % 2 != 0) {
				fill11 = "x";
				drawCross(object.getX(), object.getY());
			} else {
				drawZero(object.getX(), object.getY());
				fill11 = "o";
			}
			move++;
			return true;
		}
		if (object.equals(square12) && fill12 == "") {
			if (move % 2 != 0) {
				fill12 = "x";
				drawCross(object.getX(), object.getY());
			} else {
				drawZero(object.getX(), object.getY());
				fill12 = "o";
			}
			move++;
			return true;
		}
		if (object.equals(square13) && fill13 == "") {
			if (move % 2 != 0) {
				fill13 = "x";
				drawCross(object.getX(), object.getY());
			} else {
				drawZero(object.getX(), object.getY());
				fill13 = "o";
			}
			move++;
			return true;
		}
		if (object.equals(square21) && fill21 == "") {
			if (move % 2 != 0) {
				fill21 = "x";
				drawCross(object.getX(), object.getY());
			} else {
				drawZero(object.getX(), object.getY());
				fill21 = "o";
			}
			move++;
			return true;
		}
		if (object.equals(square22) && fill22 == "") {
			if (move % 2 != 0) {
				fill22 = "x";
				drawCross(object.getX(), object.getY());
			} else {
				drawZero(object.getX(), object.getY());
				fill22 = "o";
			}
			move++;
			return true;
		}
		if (object.equals(square23) && fill23 == "") {
			if (move % 2 != 0) {
				fill23 = "x";
				drawCross(object.getX(), object.getY());
			} else {
				drawZero(object.getX(), object.getY());
				fill23 = "o";
			}
			move++;
			return true;
		}
		if (object.equals(square31) && fill31 == "") {
			if (move % 2 != 0) {
				fill31 = "x";
				drawCross(object.getX(), object.getY());
			} else {
				drawZero(object.getX(), object.getY());
				fill31 = "o";
			}
			move++;
			return true;
		}
		if (object.equals(square32) && fill32 == "") {
			if (move % 2 != 0) {
				fill32 = "x";
				drawCross(object.getX(), object.getY());
			} else {
				drawZero(object.getX(), object.getY());
				fill32 = "o";
			}
			move++;
			return true;
		}
		if (object.equals(square33) && fill33 == "") {
			if (move % 2 != 0) {
				fill33 = "x";
				drawCross(object.getX(), object.getY());
			} else {
				drawZero(object.getX(), object.getY());
				fill33 = "o";
			}
			move++;
			return true;
		}
		return false;
	}

	/*
	 * the method checks whether the winner can be selected
	 */
	private String chooseWinner() {
		if ((fill11 == fill12) && (fill12 == fill13) && (fill11 != "")) {
			drawBlankFrame(square11.getX() + 5, square11.getY() + squareHeight / 2, BOARD_WIDTH - 10, 10,purple);
			return fill11;
		}
		if ((fill21 == fill22) && (fill22 == fill23) && (fill21 != "")) {
			drawBlankFrame(square21.getX() + 5, square21.getY() + squareHeight / 2, BOARD_WIDTH - 10, 10, purple);
			return fill21;
		}
		if ((fill31 == fill32) && (fill32 == fill33) && (fill31 != "")) {
			drawBlankFrame(square31.getX() + 5, square31.getY() + squareHeight / 2, BOARD_WIDTH - 10, 10, purple);
			return fill31;
		}
		if ((fill11 == fill21) && (fill21 == fill31) && (fill11 != "")) {
			drawBlankFrame(square11.getX() + squareWidth / 2, square11.getY() + 5, 10, BOARD_HEIGHT - 10, purple);
			return fill11;
		}
		if ((fill12 == fill22) && (fill22 == fill32) && (fill12 != "")) {
			drawBlankFrame(square12.getX() + squareWidth / 2, square12.getY() + 5, 10, BOARD_HEIGHT - 10, purple);
			return fill12;
		}
		if ((fill13 == fill23) && (fill23 == fill33) && (fill13 != "")) {
			drawBlankFrame(square13.getX() + squareWidth / 2, square13.getY() + 5, 10, BOARD_HEIGHT - 10, purple);
			return fill13;
		}
		if ((fill11 == fill22) && (fill22 == fill33) && (fill11 != "")) {
			GPolygon line = new GPolygon();
			line.setFilled(true);
			line.setColor(purple);
			line.addVertex(10, 5);
			line.addVertex(BOARD_WIDTH - 5, BOARD_HEIGHT - 10);
			line.addVertex(BOARD_WIDTH - 10, BOARD_HEIGHT - 5);
			line.addVertex(5, 10);
			add(line);
			return fill11;
		}
		if ((fill13 == fill22) && (fill22 == fill31) && (fill13 != "")) {
			GPolygon line = new GPolygon();
			line.setFilled(true);
			line.setColor(purple);
			line.addVertex(BOARD_WIDTH - 10, 5);
			line.addVertex(BOARD_WIDTH - 5, 10);
			line.addVertex(10, BOARD_HEIGHT - 5);
			line.addVertex(5, BOARD_HEIGHT - 10);
			add(line);
			return fill13;
		}
		return "";
	}

	/*
	 * displays the winner's sign
	 */
	private void endTheGame() {
		if (move == 10 || chooseWinner() == "x" || chooseWinner() == "o") {
			if (chooseWinner() == "x") {
				GLabel winX = new GLabel("Перемогли X!");
				winX.setFont("Times New Roman-28");
				winX.setColor(Color.DARK_GRAY);
				add(winX, BOARD_WIDTH / 2 - winX.getWidth() / 2, 765);
			}
			if (chooseWinner() == "o") {
				GLabel winO = new GLabel("Перемогли O!");
				winO.setFont("Times New Roman-28");
				winO.setColor(Color.DARK_GRAY);
				add(winO, BOARD_WIDTH / 2 - winO.getWidth() / 2, 765);
			}
			if (chooseWinner() == "") {
				GLabel draw = new GLabel("Нічия!");
				draw.setFont("Times New Roman-28");
				draw.setColor(Color.DARK_GRAY);
				add(draw, BOARD_WIDTH / 2 - draw.getWidth() / 2, 765);
			}
		}
	}

	/*
	 * the method draws a cross
	 */
	private void drawCross(double x, double y) {
		GPolygon cross = new GPolygon();
		cross.setFilled(true);
		cross.addVertex(x + 5 + squareWidth / 4, y + 5);
		cross.addVertex(x + squareWidth / 2, y + squareHeight / 4);
		cross.addVertex(x - 5 + 3 * squareWidth / 4, y + 5);
		cross.addVertex(x - 5 + squareWidth, y + squareHeight / 4 + 5);
		cross.addVertex(x + 3 * squareWidth / 4, y + squareHeight / 2);
		cross.addVertex(x - 5 + squareWidth, y + 3 * squareHeight / 4 - 5);
		cross.addVertex(x - 5 + 3 * squareWidth / 4, y + squareHeight - 5);
		cross.addVertex(x + squareWidth / 2, y + 3 * squareHeight / 4);
		cross.addVertex(x + 5 + squareWidth / 4, y + squareHeight - 5);
		cross.addVertex(x + 5, y + 3 * squareHeight / 4 - 5);
		cross.addVertex(x + squareWidth / 4, y + squareHeight / 2);
		cross.addVertex(x + 5, y + squareHeight / 4 + 5);
		add(cross);

	}

	/*
	 * the method draws a zero
	 */
	private void drawZero(double x, double y) {
		filledCircle(x + 5, y + 5, (squareWidth - 10) / 2, Color.BLACK);
		filledCircle(x + 50, y + 50, (squareWidth - 100) / 2, Color.WHITE);
	}

	/**
	 * method draws a checker for the game
	 */
	private void drawBoard() {
		square11 = new GRect(0, 0, squareWidth, squareHeight);
		square12 = new GRect(squareWidth + 1, 0, squareWidth, squareHeight);
		square13 = new GRect(2 * squareWidth + 2, 0, squareWidth, squareHeight);
		square21 = new GRect(0, squareHeight + 1, squareWidth, squareHeight);
		square22 = new GRect(squareWidth + 1, squareHeight + 1, squareWidth, squareHeight);
		square23 = new GRect(2 * squareWidth + 2, squareHeight + 1, squareWidth, squareHeight);
		square31 = new GRect(0, 2 * squareHeight + 2, squareWidth, squareHeight);
		square32 = new GRect(squareWidth + 1, 2 * squareHeight + 2, squareWidth, squareHeight);
		square33 = new GRect(2 * squareWidth + 2, 2 * squareHeight + 2, squareWidth, squareHeight);
		add(square11);
		add(square12);
		add(square13);
		add(square21);
		add(square22);
		add(square23);
		add(square31);
		add(square32);
		add(square33);
	}

	/*
	 * the method draws a painted zeros
	 */
	private GOval filledCircle(double centerWidth, double centerHeight, double radius2, Color color) {
		GOval circle = new GOval(centerWidth, centerHeight, 2 * radius2, 2 * radius2);
		circle.setFilled(true);
		circle.setColor(color);
		add(circle);
		return circle;
	}

	/*
	 * the method draws a painted rectangle
	 */
	private GRect drawBlankFrame(double startx, double starty, double frameWidth, double frameHeight, Color color) {
		GRect frame = new GRect(startx, starty, frameWidth, frameHeight);
		frame.setFilled(true);
		frame.setColor(color);
		add(frame);
		return frame;
	}

	/*private instance variables */
	private RandomGenerator randomGenerator = RandomGenerator.getInstance();
}
