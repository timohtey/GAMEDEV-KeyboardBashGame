import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

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
		keyHole = new Keyhole(gameFrame.getImage("assets/placeholder.png"), CENTER, CENTER);
		
		initializeStreams();
	}

	private void initializeStreams() {
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
			stream.setDirection(direction);
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
		gd.setColor(Color.white);
		gd.fillRect(0, 0, gameFrame.getWidth(), gameFrame.getHeight());
		
		for(int i = 0; i<streams.size(); i++){
			for(int j = 0; j<streams.get(i).getKeys().size();j++){
				streams.get(i).getKeys().get(j).render(gd);
			}
		}
		
		keyHole.render(gd);
	}
	
	public void update(long elapsedTime){
		for(int i = 0; i<streams.size(); i++){
			for(int j = 0; j<streams.get(i).getKeys().size();j++){
				streams.get(i).getKeys().get(j).update(elapsedTime);
			}
		}
	}
	
}
