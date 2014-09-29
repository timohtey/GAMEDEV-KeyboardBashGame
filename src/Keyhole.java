import java.awt.image.BufferedImage;

import com.golden.gamedev.object.Sprite;


public class Keyhole extends Sprite{
	private double x;
	private double y;
	private int length; // x
	private int width; // y
	
	public Keyhole(BufferedImage bufferedImage, int x, int y){
		super(bufferedImage, x , y);
		length = 32;
		width = 32;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
}
