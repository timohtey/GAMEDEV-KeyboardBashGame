import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.golden.gamedev.object.Timer;

public class PlayScreen {
	private GameFrame gameFrame;
	
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
		this.gameFrame = gameFrame;
		initializeEntities();
		chooseMusic();
	}

	private void initializeEntities() {
		streams = new ArrayList<Stream>();
		keyHole = new Keyhole(gameFrame.getImage("assets/keyhole.png"), CENTER, CENTER);
		moveKey = new Timer(300);
		initializeKeys();
	}
	
	private void initializeKeys() {
		ArrayList<Key> keys = new ArrayList<Key>();
		Level playLevel = new Level(level, gameFrame);
		keys = playLevel.getKeys();
		initializeStreams(keys);
	}
	
	private void initializeStreams(ArrayList<Key> keys) {
		for(int i = 0; i<8; i++){
			int keyPressed = 0;
			int x = 0;
			int y = 0;
			switch(i){
				case 0: keyPressed = KeyEvent.VK_1;
						x = CENTER;
						y = CENTER-5*32;
						break;
				case 1: keyPressed = KeyEvent.VK_2;
						x = CENTER+5*32;
						y = CENTER-5*32;
						break;
				case 2: keyPressed = KeyEvent.VK_3;
						x = CENTER+5*32;
						y = CENTER;
						break;
				case 3: keyPressed = KeyEvent.VK_4;
						x = CENTER+5*32;
						y = CENTER+5*32;
						break;
				case 4: keyPressed = KeyEvent.VK_5;
						x = CENTER;
						y = CENTER+5*32;
						break;
				case 5: keyPressed = KeyEvent.VK_6;
						x = CENTER-5*32;
						y = CENTER+5*32;
						break;
				case 6: keyPressed = KeyEvent.VK_7;
						x = CENTER-5*32;
						y = CENTER;
						break;
				case 7: keyPressed = KeyEvent.VK_8;
						x = CENTER-5*32;
						y = CENTER-5*32;
						break;
			}
			
			Stream stream = new Stream(keyPressed, i+1, x, y);
			streams.add(stream);
		}
		
		for(int i = 0; i<streams.size();i++){
			for(int j = 0; j<keys.size();j++){
				System.out.println(streams.get(i).getKeyPressed() + " : " + keys.get(j).getKeyPressed());
				if(streams.get(i).getKeyPressed() == keys.get(j).getKeyPressed()){
					Key key = keys.get(j);
					key.setX(streams.get(i).getX());
					key.setY(streams.get(i).getY());
					streams.get(i).addKey(key);
				}
			}
		}
	}
	
	private void chooseMusic() {
		switch(level){
			case 0: music = "";
					break;
		}	
	}

	public void render(Graphics2D gd){
		gd.setColor(Color.white);
		gd.fillRect(0, 0, gameFrame.getWidth(), gameFrame.getHeight());
		
		for(int i = 0; i<streams.size(); i++){
			for(int j = 0; j<streams.get(i).getKeys().size();j++){
				streams.get(i).render(gd);
			}
		}
		
		keyHole.render(gd);
	}
	
	public void update(long elapsedTime){
//		for(int i = 0; i<streams.size(); i++){
////			for(Key key: streams.get(i).getKeys()){
////				key.setY(key.getY()+32*0.5);
////			}
//			streams.get(i).moveKeys();
////			if(moveKey.action(elapsedTime)){
////				streams.get(i).moveKeys();
////			}
////			for(int j = 0; j<streams.get(i).getKeys().size();j++){
////				streams.get(i).update(elapsedTime);
////			}
//		}
		
		if(moveKey.action(elapsedTime)){
			for(int i = 0; i<streams.size(); i++){
				streams.get(i).moveKeys();		
			}
		}
		
		checkKeyHoleCollision();
		
	}
	
	public void checkKeyHoleCollision(){
		
	}
}
