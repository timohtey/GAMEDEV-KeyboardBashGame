
public class Keyhole {
	private int x;
	private int y;
	private int length; // x
	private int width; // y
	
	public Keyhole(int x, int y, int length, int width){
		this.setX(x);
		this.setY(y);
		this.setLength(length);
		this.setWidth(width);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
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
