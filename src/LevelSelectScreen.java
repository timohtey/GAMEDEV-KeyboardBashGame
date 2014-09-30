import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import com.golden.gamedev.Game;
import com.golden.gamedev.object.GameFont;
import com.golden.gamedev.object.Sprite;


public class LevelSelectScreen {
	GameFrame g;
	PlayScreen ps;
	Sprite playLevelButton;
	Sprite nextButton;
	Sprite backButton;
	String songName="NONE";
	static int level=0;
	static int speed=1;
	public final static int MAXLEVEL=2;
	
	public LevelSelectScreen(GameFrame g,PlayScreen ps){
		this.ps = ps;
		this.g=g;
		playLevelButton = new Sprite(g.getImage("src/assets/playLevelButton.png"),149,522);
		nextButton = new Sprite(g.getImage("src/assets/nextButton.png"),504,293);
		backButton = new Sprite(g.getImage("src/assets/backButton.png"),19,294);
	}
	
	public void readInput(){
		if(g.click()){
			if(g.checkPosMouse(playLevelButton, false)){
				ps.startGame(level, speed);
				g.setActiveScreen(g.PLAYSCREEN);
			}
			else if(g.checkPosMouse(nextButton, false)){
				level++;
				level%=MAXLEVEL;
			}
			else if(g.checkPosMouse(backButton, false)){
				if(level>0)
					level--;
				level%=MAXLEVEL;
			}
		}
	}
	
	public void render(Graphics2D gd){
		gd.setColor(Color.white);
		gd.fillRect(0, 0, g.getWidth(), g.getHeight());
		gd.setColor(Color.BLACK);
		g.fontManager.getFont("FPS Font").drawString(gd, "LEVEL SELECT", 10, 10);
		g.fontManager.getFont("FPS Font").drawString(gd, "LEVEL "+(level+1), 200, 50);
		
		
		
		
		g.fontManager.getFont("FPS Font").drawString(gd, "SONG NAME", 100, 70);
		g.fontManager.getFont("FPS Font").drawString(gd, songName, 200, 90);
		//TODO print highscore
		
		g.fontManager.getFont("FPS Font").drawString(gd, "HIGHSCORE "+GameFrame.playScreen.scores.get(level), 200, 110);
		playLevelButton.render(gd);
		nextButton.render(gd);
		backButton.render(gd);
	}
	
	public void update(long elapsedTime){
		readInput();
		
		switch(level){
			case 0: songName = "YOUNG BLOOD BY THE NAKED AND FAMOUS";break;
			case 1: songName = "CONSTANT CONVERSATIONS BY PASSION PIT";break;
		}
	}
	
}
