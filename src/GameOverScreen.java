import java.awt.Color;
import java.awt.Graphics2D;

import com.golden.gamedev.object.Sprite;


public class GameOverScreen {
	GameFrame g;
	Sprite restartButton;
	Sprite mainMenuButton;
	public GameOverScreen(GameFrame g){
		this.g=g;
		restartButton = new Sprite(g.getImage("src/assets/restartButton.png"),148,378);
		mainMenuButton = new Sprite(g.getImage("src/assets/mainMenuButton.png"),150,460);
	}
	
	public void readInput(){
		if(g.click()){
			if(g.checkPosMouse(restartButton, false)){
				GameFrame.playScreen.startGame(LevelSelectScreen.level, LevelSelectScreen.speed);
				g.setActiveScreen(g.PLAYSCREEN);
			}else if(g.checkPosMouse(mainMenuButton, false)){
				g.setActiveScreen(g.MAINSCREEN);
			}
		}
	}
	
	public void render(Graphics2D gd){
		gd.setColor(Color.white);
		gd.fillRect(0, 0, g.getWidth(), g.getHeight());
		gd.drawImage(g.getImage("src/assets/gameOver.png"), null, 97, 170);
		// TODO show stats, your score, current highscore, accuracy
		
		g.fontManager.getFont("FPS Font").drawString(gd, "SCORE:"+GameFrame.playScreen.score, 200, 100);
		g.fontManager.getFont("FPS Font").drawString(gd, "ACCURACY:"+ GameFrame.playScreen.accuracy, 200, 140);
		restartButton.render(gd);
		mainMenuButton.render(gd);
	}
	
	public void update(long elapsedTime){
		readInput();
	}
}
