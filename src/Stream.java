import java.awt.Graphics2D;
import java.util.ArrayList;

public class Stream {
	private ArrayList<Key> keys;
	private int keyPressed;
	private int direction; // 1 - 8
	private int x;
	private int y;
	
	public Stream(int keyPressed, int direction, int x, int y){
		this.keys = new ArrayList<Key>();
		this.setKeyPressed(keyPressed);
		this.setDirection(direction);
		this.setX(x);
		this.setY(y);
	}
	
	public void render(Graphics2D gd){
		for(Key k : keys){
			k.render(gd);
		}
	}
	
	public ArrayList<Key> getKeys() {
		return keys;
	}

	public void setKeys(ArrayList<Key> keys) {
		this.keys = keys;
	}

	public int getKeyPressed() {
		return keyPressed;
	}

	public void setKeyPressed(int keyPressed) {
		this.keyPressed = keyPressed;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
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

}
