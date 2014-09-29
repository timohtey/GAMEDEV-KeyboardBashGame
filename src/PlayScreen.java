import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.golden.gamedev.object.Timer;

public class PlayScreen {
	private final int DIMENSION = 32;
	private final int MAPSIZE = 640;
	private final int CENTER = (MAPSIZE/2)-(DIMENSION/2);
	
	private int score;
	private int level;
	private int speed;
	private int tries;
	private int success;
	private String music;
	
	private ArrayList<Stream> streams;
	private Keyhole keyHole;
	
	private Timer moveKey;
	
	public PlayScreen(GameFrame gameFrame){
		score = 0;
		tries = 0;
		success = 0;
		speed = level*1;
		initializeEntities(gameFrame);
		chooseMusic();
	}

	private void initializeEntities(GameFrame gameFrame) {
		streams = new ArrayList<Stream>();
		keyHole = new Keyhole(gameFrame.getImage("assets/placeholder.png"), CENTER, CENTER);
		
		initializeStreams(gameFrame);
		
		moveKey = new Timer(50);
	}

	private void initializeStreams(GameFrame gameFrame) {
		for(int i = 0; i<8; i++){
			int keyPressed = 0;
			int x = 0;
			int y = 0;
			int direction = 0;
			switch(i){
				case 0: keyPressed = KeyEvent.VK_1;
						x = CENTER;
						y = CENTER-5*32;
						direction = 1;
						break;
				case 1: keyPressed = KeyEvent.VK_2;
						x = CENTER+5*32;
						y = CENTER-5*32;
						direction = 2;
						break;
				case 2: keyPressed = KeyEvent.VK_3;
						x = CENTER+5*32;
						y = CENTER;
						direction = 3;
						break;
				case 3: keyPressed = KeyEvent.VK_4;
						x = CENTER+5*32;
						y = CENTER+5*32;
						direction = 4;
						break;
				case 4: keyPressed = KeyEvent.VK_5;
						x = CENTER;
						y = CENTER+5*32;
						direction = 5;
						break;
				case 5: keyPressed = KeyEvent.VK_6;
						x = CENTER-5*32;
						y = CENTER+5*32;
						direction = 6;
						break;
				case 6: keyPressed = KeyEvent.VK_7;
						x = CENTER-5*32;
						y = CENTER;
						direction = 7;
						break;
				case 7: keyPressed = KeyEvent.VK_8;
						x = CENTER-5*32;
						y = CENTER-5*32;
						direction = 8;
						break;
			}
			
			Stream stream = new Stream(keyPressed, i+1, x, y);
			streams.add(stream);
			
			Key key = new Key(gameFrame.getImage("assets/placeholder.png"), x, y);
			ArrayList<Key> keys = new ArrayList<Key>();
			keys.add(key);
			streams.get(i).setKeys(keys);
		}
		
	}

	private void chooseMusic() {
		switch(level){
			case 0: music = "";
					break;
		}	
	}

	public void render(Graphics2D gd){
		for(int i = 0; i<streams.size(); i++){
			for(int j = 0; j<streams.get(i).getKeys().size();j++){
				streams.get(i).render(gd);
			}
		}
		
		keyHole.render(gd);
	}
	
	public void update(long elapsedTime){
		for(int i = 0; i<streams.size(); i++){
			for(int j = 0; j<streams.get(i).getKeys().size();j++){
				streams.get(i).getKeys().get(j).update(elapsedTime);
			}
			if(moveKey.action(elapsedTime)){
				streams.get(i).moveKeys();
			}
		}
		
		
	}
	
}
