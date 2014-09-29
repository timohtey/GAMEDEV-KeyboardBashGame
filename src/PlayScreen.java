import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PlayScreen {
	private int score;
	private int level;
	private int speed;
	private int tries;
	private int success;
	private String music;
	private ArrayList<Stream> streams;
	public PlayScreen(){
		score = 0;
		tries = 0;
		success = 0;
		speed = level*1;
		streams = new ArrayList<Stream>();
		
		initializeStreams();
		chooseMusic();
	}

	private void initializeStreams() {
		for(int i = 0; i<8; i++){
			int keyPressed = 0;
			int x = 0;
			int y = 0;
			
			switch(i){
				case 0: keyPressed = KeyEvent.VK_1;
						break;
				case 1: keyPressed = KeyEvent.VK_2;
						break;
				case 2: keyPressed = KeyEvent.VK_3;
						break;
				case 3: keyPressed = KeyEvent.VK_4;
						break;
				case 4: keyPressed = KeyEvent.VK_5;
						break;
				case 5: keyPressed = KeyEvent.VK_6;
						break;
				case 6: keyPressed = KeyEvent.VK_7;
						break;
				case 7: keyPressed = KeyEvent.VK_8;
						break;
			}
			
			streams.add(new Stream(keyPressed, i+1, x, y));
		}
		
	}

	private void chooseMusic() {
		switch(level){
			case 0: music = "";
					break;
		}	
	}

	public void render(Graphics2D gd){
		
	}
	
	public void update(long elapsedTime){
		
	}
	
}
