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

	public void moveKeys(){
		for(Key key : keys){
			switch(direction){
			case 1: key.setY(key.getY()+32*0.5);
					break;
			case 2: key.setX(key.getX()-32*0.5);
					key.setY(key.getY()+32*0.5);
					break;
			case 3: key.setX(key.getX()-32*0.5);
					break;
			case 4: key.setX(key.getX()-32*0.5);
					key.setY(key.getY()-32*0.5);
					break;
			case 5: key.setY(key.getY()-32*0.5);
					break;
			case 6: key.setX(key.getX()+32*0.5);
					key.setY(key.getY()-32*0.5);
					break;
			case 7: key.setX(key.getX()+32*0.5);
					break;
			case 8: key.setX(key.getX()+32*0.5);
					key.setY(key.getY()+32*0.5);
					break;
		}
		}
		
	}
	
	public void update(long elapsedTime){
		for(Key key:keys){
			key.update(elapsedTime);
		}
	}
	
	public void readInput(GameFrame g,Keyhole kh, int dimension){
		if(g.keyPressed(keyPressed) && keys.size()!=0){
			if(Math.abs(keys.get(0).getX()-kh.getX())<PlayScreen.DIMENSION && 
			   Math.abs(keys.get(0).getY()-kh.getY())<PlayScreen.DIMENSION){
				
			}
			
		}
	}
}
