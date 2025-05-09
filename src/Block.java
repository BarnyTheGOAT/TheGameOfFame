/* Arnav Jaiswal
 * blocks
 */

import java.awt.Image;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.Timer;

public class Block implements ActionListener {
	private int row, column, crack;
	private String image;
	private Timer life;
	private boolean isShop;

	public void makeShop() {
		image = "shop";
		isShop = true;
	}

	public boolean isShop() {
		return isShop;
	}

	public Block(int row, int column) {
		// intialize block default state
		this.row = row;
		this.column = column;
		crack = 16;
		image = "air";
		life = new Timer(1000, this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == life) {
			if (crack > 0) {
				crack--;
			} else {
				image = "air";
				life.stop();
			}
		}
	}

	public int getCrack() { return crack; }

	public Image getImage() {
		return (new Picture()).getImage(image);
	}

	public void setImage(String image) {
		if (!this.image.equals("grass")) {
			this.image = image;
			if (!image.equals("air")) {
				crack = 16;
				life.start();
			}
		}
	}

	public boolean isBlock() {
		return !(image.equals("air") || image.equals("shop"));
	}

	public void floor() { image = "grass"; }
	public boolean isFloor() { return Objects.equals(image, "grass"); }
	public int getRow() { return row; }
	public int getColumn() { return column; }
}