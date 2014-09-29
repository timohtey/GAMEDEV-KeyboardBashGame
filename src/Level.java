import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class Level {
	private GameFrame gameFrame;
	
	private int level;
	private ArrayList<Key> keys = new ArrayList<Key>();
	
	public Level(int level, GameFrame gameFrame){
		this.level = level;
		this.gameFrame = gameFrame;
		
		switch(level){
			case 0: setupLevel1();
					break;
			case 1: setupLevel2();
					break;
		}
	}

	private void setupLevel1() {
		// add keys here
		keys.add(new Key(gameFrame.getImage("assets/placeholder.png"), 0.0, 0.0, KeyEvent.VK_1));
		keys.add(new Key(gameFrame.getImage("assets/placeholder.png"), 0.0, 0.0, KeyEvent.VK_2));
		
	}

	private void setupLevel2() {
		// add keys here
		
	}

	public ArrayList<Key> getKeys() {
		return keys;
	}

	public void setKeys(ArrayList<Key> keys) {
		this.keys = keys;
	}
}
