import java.awt.image.BufferedImage;

import com.golden.gamedev.object.Sprite;


public class Key extends Sprite{
	private double x;
	private double y;
	private int speed;
	private long time;
	
	public Key(BufferedImage bufferedImage, double x, double y){
		super(bufferedImage,x,y);
	}
	
	public double getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
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
}
