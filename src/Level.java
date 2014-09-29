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
<<<<<<< HEAD
		keys.add(new Key(gameFrame.getImage("assets/placeholder.png"), 0.0, 0.0, KeyEvent.VK_1, 58));
=======
		keys.add(new Key(gameFrame.getImage("assets/placeholder.png"), 0.0, 0.0, KeyEvent.VK_1, 1));
		keys.add(new Key(gameFrame.getImage("assets/placeholder.png"), 0.0, 0.0, KeyEvent.VK_2, 1));
		keys.add(new Key(gameFrame.getImage("assets/placeholder.png"), 0.0, 0.0, KeyEvent.VK_3, 1));
		keys.add(new Key(gameFrame.getImage("assets/placeholder.png"), 0.0, 0.0, KeyEvent.VK_4, 1));
		keys.add(new Key(gameFrame.getImage("assets/placeholder.png"), 0.0, 0.0, KeyEvent.VK_5, 1));
		keys.add(new Key(gameFrame.getImage("assets/placeholder.png"), 0.0, 0.0, KeyEvent.VK_6, 1));
		keys.add(new Key(gameFrame.getImage("assets/placeholder.png"), 0.0, 0.0, KeyEvent.VK_7, 1));
		keys.add(new Key(gameFrame.getImage("assets/placeholder.png"), 0.0, 0.0, KeyEvent.VK_8, 1));
>>>>>>> f8f64c1f9c36893a59db179118c45adc59c35dd9
		
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
