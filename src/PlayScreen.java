import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.golden.gamedev.object.Timer;

public class PlayScreen {
	private GameFrame gameFrame;
	
	public final static int DIMENSION = 32;
	public final static int MAPSIZE = 640;
	public final static int CENTER = (MAPSIZE/2)-(DIMENSION/2);
	
	private int score;
	private int level;
	private int speed;
	private int tries;
	private int success;
	private String music;
	
	private ArrayList<Stream> streams;
	private Keyhole keyHole;
	
	private Timer moveKey;
	private Timer timeRemaining;
	long time;
	
	public PlayScreen(GameFrame gameFrame){
		score = 0;
		tries = 0;
		success = 0;
		speed = level*1;
		this.gameFrame = gameFrame;
		initializeEntities();
		timeRemaining = new Timer(60000);
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
				if(streams.get(i).getKeyPressed() == keys.get(j).getKeyPressed()){
					Key key = keys.get(j);
					key.setX(streams.get(i).getX());
					key.setY(streams.get(i).getY());
					streams.get(i).addUnreleasedKey(key);
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

		long time = (60 - (timeRemaining.getCurrentTick()/1000));
		gameFrame.fontManager.getFont("FPS Font").drawString(gd, "TIME:"+time, 5, 10);
		
		keyHole.render(gd);
		
		for(int i = 0; i<streams.size(); i++){
			for(int k = 0; k < streams.get(i).getKeys().size(); k++){
				streams.get(i).render(gd);
			}
		}
		
	}
	
	
	public void update(long elapsedTime){		
		if(moveKey.action(elapsedTime)){
			for(int i = 0; i<streams.size(); i++){
				streams.get(i).moveKeys();		
			}
		}
		
		if(timeRemaining.action(elapsedTime)){
			
		}
		
		checkKeyHoleAndKeyCollision();
		checkKeyDecay();
		
	}
	
	public void checkKeyHoleAndKeyCollision(){
		for(Stream stream: streams){
			ArrayList<Key> keys = stream.getKeys();
			if(gameFrame.keyPressed(stream.getKeyPressed())){
				if(keys.size()!=0 && Math.abs(keys.get(0).getX()-keyHole.getX())<PlayScreen.DIMENSION && 
				   Math.abs(keys.get(0).getY()-keyHole.getY())<PlayScreen.DIMENSION){
					score+=1;
					success++;
					keys.remove(0);
				}
				tries++;
			}
		}
	}
	
	public void checkKeyDecay(){
		for(Stream stream: streams){
			switch(stream.getDirection()){
				case 1: if(stream.getKeys().size()>0 && stream.getKeys().get(0).getY()>(keyHole.getY()+16)){
							stream.getKeys().remove(0);
						}
				break;
				case 2: if(stream.getKeys().size()>0 && stream.getKeys().get(0).getY()>(keyHole.getY()+16) 
						&& stream.getKeys().get(0).getX()<(keyHole.getX()-16)){
					stream.getKeys().remove(0);
				}
				break;
				case 3: if(stream.getKeys().size()>0 && stream.getKeys().get(0).getX()<(keyHole.getX()-16)){
					stream.getKeys().remove(0);
				}
				break;
				case 4: if(stream.getKeys().size()>0 && stream.getKeys().get(0).getX()<(keyHole.getX()-16) 
						&& 	stream.getKeys().get(0).getY()<(keyHole.getY()-16)){
					stream.getKeys().remove(0);
				}
				break;
				case 5: if(stream.getKeys().size()>0 && stream.getKeys().get(0).getY()<(keyHole.getY()-16)){
					stream.getKeys().remove(0);
				}
				break;
				case 6: if(stream.getKeys().size()>0 && stream.getKeys().get(0).getY()<(keyHole.getY()-16)
						&& stream.getKeys().get(0).getX()>(keyHole.getX()+16)){
					stream.getKeys().remove(0);
				}
				break;
				case 7: if(stream.getKeys().size()>0 && stream.getKeys().get(0).getX()>(keyHole.getX()+16)){
					stream.getKeys().remove(0);
				}
				break;
				case 8: if(stream.getKeys().size()>0 && stream.getKeys().get(0).getX()>(keyHole.getX()+16)
						&& stream.getKeys().get(0).getY()>(keyHole.getY()+16)){
					stream.getKeys().remove(0);
				}
				break;
			}
		}
	}
}
