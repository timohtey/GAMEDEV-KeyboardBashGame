import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.Timer;

public class PlayScreen {
	private GameFrame gameFrame;
	
	public final static int DIMENSION = 32;
	public final static int MAPSIZE = 640;
	public final static int CENTER = (MAPSIZE/2)-(DIMENSION/2);
	public final static int SIZE = 8;
	public final static int KEY_DECAY_DISTANCE = 8;
	
	private int lives;
	public int score;
	private int level;
	private int speed;
	private double tries;
	private double success;
	private String music;
	public double accuracy = 100;
	int gameLength = 30000;
	
	private ArrayList<Stream> streams;
	private ArrayList<Sprite> levelSprite;
	public ArrayList<Integer> scores = new ArrayList<Integer>();
	private Keyhole keyHole;
	
	private Timer moveKey;
	private Timer timeRemaining;
	long time;
	
	public PlayScreen(GameFrame gameFrame){
		this.gameFrame = gameFrame;
		readHighscore();
	}

	private void initializeEntities() {
		streams = new ArrayList<Stream>();
		scores = new ArrayList<Integer>();
		keyHole = new Keyhole(gameFrame.getImage("assets/keyhole.png"), CENTER, CENTER);
		moveKey = new Timer(50);
		
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
						y = CENTER-SIZE*32;
						break;
				case 1: keyPressed = KeyEvent.VK_2;
						x = CENTER+SIZE*32;
						y = CENTER-SIZE*32;
						break;
				case 2: keyPressed = KeyEvent.VK_3;
						x = CENTER+SIZE*32;
						y = CENTER;
						break;
				case 3: keyPressed = KeyEvent.VK_4;
						x = CENTER+SIZE*32;
						y = CENTER+SIZE*32;
						break;
				case 4: keyPressed = KeyEvent.VK_5;
						x = CENTER;
						y = CENTER+SIZE*32;
						break;
				case 5: keyPressed = KeyEvent.VK_6;
						x = CENTER-SIZE*32;
						y = CENTER+SIZE*32;
						break;
				case 6: keyPressed = KeyEvent.VK_7;
						x = CENTER-SIZE*32;
						y = CENTER;
						break;
				case 7: keyPressed = KeyEvent.VK_8;
						x = CENTER-SIZE*32;
						y = CENTER-SIZE*32;
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
	
	public void playSound(){
		gameFrame.playSound(music);
	}
	private void chooseMusic() {
		switch(level){
			case 0: music = "src/assets/background.wav";
					break;
			case 1: music = "src/assets/background2.wav";
					break;
		}	
	}

	public void render(Graphics2D gd){
		gd.setColor(Color.white);
		gd.fillRect(0, 0, gameFrame.getWidth(), gameFrame.getHeight());
		
		long time = ((gameLength/1000) - (timeRemaining.getCurrentTick()/1000));
		
		gameFrame.fontManager.getFont("FPS Font").drawString(gd, "TIME:"+time, 5, 10);
		gameFrame.fontManager.getFont("FPS Font").drawString(gd, "LEVEL:"+(level+1), 400, 50);
		gameFrame.fontManager.getFont("FPS Font").drawString(gd, "LIVE:"+lives, 400, 10);
		gameFrame.fontManager.getFont("FPS Font").drawString(gd, "SCORE:"+score, 5, 30);
		
		if(tries>0){
			accuracy = success/tries*100;
		}
		gameFrame.fontManager.getFont("FPS Font").drawString(gd, "ACCURACY:"+ accuracy, 400, 30);
		
		keyHole.render(gd);
		
		
		for(int i = 0; i<streams.size(); i++){
			for(int k = 0; k < streams.get(i).getKeys().size(); k++){
				streams.get(i).render(gd);
			}
		}
		
	}
	
	
	public void update(long elapsedTime){	
		
		checkGameOver(elapsedTime);
		if(moveKey.action(elapsedTime)){
			for(int i = 0; i<streams.size(); i++){
				streams.get(i).moveKeys();		
			}
		}
		
		for(Stream stream:streams){
			if(stream.getUnreleased().size()>0 && stream.getUnreleased().get(0).getTime() <= timeRemaining.getCurrentTick()){
				stream.getKeys().add(stream.getUnreleased().get(0));
				stream.getUnreleased().remove(0);
			}
		}
		
		checkKeyHoleAndKeyCollision();
		checkKeyDecay();
		
		
	}
	public void checkGameOver(long elapsedTime){
		if(lives<=0){
			stopGame();
			gameFrame.setActiveScreen(GameFrame.GAMEOVERSCREEN);
		}else if( timeRemaining.action(elapsedTime)){
			stopGame();
			gameFrame.setActiveScreen(GameFrame.LEVELTRANSITIONSCREEN);
		}
	}
	public void setupGame(int level,int speed){
		this.level = level;
		lives = 20;
		score = 0;
		tries = 0;
		success = 0;
		accuracy = 100;
		this.speed = speed;
		chooseMusic();
		initializeEntities();
		timeRemaining = new Timer(gameLength); //TODO: match timer with music length
	}
	
	public void startGame(int level,int speed){
		setupGame(level,speed);
		playSound();
		readHighscore();
	}
	
	public void stopGame(){
		//TODO: Save Score
		if(scores.get(level)<score){
			scores.set(level, score);
		}
		saveScores();
		gameFrame.bsSound.stop(music);
	}
	public void readHighscore() {
		String fileName="src/score.txt";
		try{
			FileReader inputFile = new FileReader(fileName);
		    BufferedReader bufferReader = new BufferedReader(inputFile);
		
		    String line;
		    while ((line = bufferReader.readLine()) != null){
		    	scores.add(Integer.parseInt(line));
		    }
		    for(int i = 0; i<scores.size(); i++){
		      	System.out.println(scores.get(i));
		    }
		    bufferReader.close();
		}catch(Exception e){
			e.printStackTrace();                   
	    }	
	}
	 
	public void saveScores(){
	    try {
	    	File file = new File("src/score.txt");
	    	FileWriter fileWriter = new FileWriter(file, false); // true to append
	    	                                                     // false to overwrite.
	        for(int i = 0; i<scores.size(); i++){
	        	fileWriter.write(scores.get(i) + "\n");	
	        }
	        fileWriter.close();
	    } catch (Exception e) {
	      System.out.println("There was a problem:" + e);
	    }
	}
	private void checkKeyHoleAndKeyCollision(){
		for(Stream stream: streams){
			ArrayList<Key> keys = stream.getKeys();
			if(gameFrame.keyPressed(stream.getKeyPressed())){
				if(keys.size()!=0 && Math.abs(keys.get(0).getX()-keyHole.getX())<PlayScreen.DIMENSION && 
				   Math.abs(keys.get(0).getY()-keyHole.getY())<PlayScreen.DIMENSION){
					score+=1;
					success++;
					keys.remove(0);
				}else{
					lives--;
				}
				tries++;
			}
		}
	}
	
	
	
	public void checkKeyDecay(){
		for(Stream stream: streams){
			switch(stream.getDirection()){
				case 1: if(stream.getKeys().size()>0 && stream.getKeys().get(0).getY()>(keyHole.getY()+KEY_DECAY_DISTANCE)){
							stream.getKeys().remove(0);
							lives--;
							tries++;
						}
				break;
				case 2: if(stream.getKeys().size()>0 && stream.getKeys().get(0).getY()>(keyHole.getY()+KEY_DECAY_DISTANCE) 
						&& stream.getKeys().get(0).getX()<(keyHole.getX()-KEY_DECAY_DISTANCE)){
					stream.getKeys().remove(0);
					lives--;
					tries++;
				}
				break;
				case 3: if(stream.getKeys().size()>0 && stream.getKeys().get(0).getX()<(keyHole.getX()-KEY_DECAY_DISTANCE)){
					stream.getKeys().remove(0);
					lives--;
					tries++;
				}
				break;
				case 4: if(stream.getKeys().size()>0 && stream.getKeys().get(0).getX()<(keyHole.getX()-KEY_DECAY_DISTANCE) 
						&& 	stream.getKeys().get(0).getY()<(keyHole.getY()-KEY_DECAY_DISTANCE)){
					stream.getKeys().remove(0);
					lives--;
					tries++;
				}
				break;
				case 5: if(stream.getKeys().size()>0 && stream.getKeys().get(0).getY()<(keyHole.getY()-KEY_DECAY_DISTANCE)){
					stream.getKeys().remove(0);
					lives--;
					tries++;
				}
				break;
				case 6: if(stream.getKeys().size()>0 && stream.getKeys().get(0).getY()<(keyHole.getY()-KEY_DECAY_DISTANCE)
						&& stream.getKeys().get(0).getX()>(keyHole.getX()+KEY_DECAY_DISTANCE)){
					stream.getKeys().remove(0);
					lives--;
					tries++;
				}
				break;
				case 7: if(stream.getKeys().size()>0 && stream.getKeys().get(0).getX()>(keyHole.getX()+KEY_DECAY_DISTANCE)){
					stream.getKeys().remove(0);
					lives--;
					tries++;
				}
				break;
				case 8: if(stream.getKeys().size()>0 && stream.getKeys().get(0).getX()>(keyHole.getX()+KEY_DECAY_DISTANCE)
						&& stream.getKeys().get(0).getY()>(keyHole.getY()+KEY_DECAY_DISTANCE)){
					stream.getKeys().remove(0);
					lives--;
					tries++;
				}
				break;
			}
		}
	}
}
