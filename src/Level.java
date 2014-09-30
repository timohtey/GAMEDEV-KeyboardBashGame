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
		keys.add(new Key(gameFrame.getImage("assets/1.png"), 0.0, 0.0, KeyEvent.VK_1, 1000));
		keys.add(new Key(gameFrame.getImage("assets/1.png"), 0.0, 0.0, KeyEvent.VK_1, 2000));
		keys.add(new Key(gameFrame.getImage("assets/2.png"), 0.0, 0.0, KeyEvent.VK_2, 2000));
		keys.add(new Key(gameFrame.getImage("assets/3.png"), 0.0, 0.0, KeyEvent.VK_3, 3000));
		keys.add(new Key(gameFrame.getImage("assets/4.png"), 0.0, 0.0, KeyEvent.VK_4, 4000));
		keys.add(new Key(gameFrame.getImage("assets/5.png"), 0.0, 0.0, KeyEvent.VK_5, 5000));
		keys.add(new Key(gameFrame.getImage("assets/6.png"), 0.0, 0.0, KeyEvent.VK_6, 6000));
		keys.add(new Key(gameFrame.getImage("assets/7.png"), 0.0, 0.0, KeyEvent.VK_7, 7000));
		keys.add(new Key(gameFrame.getImage("assets/8.png"), 0.0, 0.0, KeyEvent.VK_8, 8000));
		
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
