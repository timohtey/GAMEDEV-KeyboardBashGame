
public class Key {
	private int x;
	private int y;
	private int speed;
	private long time;
	
	public Key(int x, int y, int speed, long time){
		this.setX(x);
		this.setY(y);
		this.setSpeed(speed);
		this.setTime(time);
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
