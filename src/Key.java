import java.awt.image.BufferedImage;

import com.golden.gamedev.object.Sprite;


public class Key extends Sprite{
	private int speed;
	private long time;
	private int keyPressed;
	private boolean isSpawn;
	
	public Key(BufferedImage bufferedImage, double x, double y, int keyPressed, long time){
		super(bufferedImage,x,y);
		this.keyPressed = keyPressed;
		this.time = time;
		speed = 5;
		setSpawn(false);
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public long getTime() {
		return time;
	}
	
	public void setTime(long time) {
		this.time = time;
	}

	public int getKeyPressed() {
		return keyPressed;
	}

	public void setKeyPressed(int keyPressed) {
		this.keyPressed = keyPressed;
	}

	public boolean isSpawn() {
		return isSpawn;
	}

	public void setSpawn(boolean isSpawn) {
		this.isSpawn = isSpawn;
	}
}
