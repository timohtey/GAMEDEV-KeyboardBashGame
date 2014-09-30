import java.awt.Graphics2D;
import java.util.ArrayList;

import com.golden.gamedev.Game;


public class GameFrame extends Game{
	static int activeScreen;
	public final static int PLAYSCREEN = 0;
	public final static int MAINSCREEN = 1;
	public final static int GAMEOVERSCREEN = 2;
	public final static int LEVELTRANSITIONSCREEN = 3;
	public final static int LEVELSELECTSCREEN = 4;
	public static PlayScreen playScreen;
	MainScreen mainScreen;
	GameOverScreen gameOverScreen;
	LevelTransitionScreen levelTransitionScreen;
	LevelSelectScreen levelSelectScreen;
	public void initResources() {
		activeScreen = 1;
		playScreen = new PlayScreen(this);
		mainScreen = new MainScreen(this);
		gameOverScreen = new GameOverScreen(this);
		levelTransitionScreen = new LevelTransitionScreen(this);
		levelSelectScreen = new LevelSelectScreen(this,playScreen);
	}
	
	@Override
	public void render(Graphics2D gd) {
		switch(activeScreen){
			case PLAYSCREEN: playScreen.render(gd); 
							 break;
			case MAINSCREEN: mainScreen.render(gd);
							 break;
			case GAMEOVERSCREEN: gameOverScreen.render(gd);
							 break;
			case LEVELTRANSITIONSCREEN: levelTransitionScreen.render(gd);
			 				break;
			case LEVELSELECTSCREEN: levelSelectScreen.render(gd);
							break;
		}
	}

	@Override
	public void update(long elapsedTime) {
		switch(activeScreen){
			case PLAYSCREEN: playScreen.update(elapsedTime); 
							 break;
			case MAINSCREEN: mainScreen.update(elapsedTime);
			 				 break;
			case GAMEOVERSCREEN: gameOverScreen.update(elapsedTime);
			 				break;
			case LEVELTRANSITIONSCREEN: levelTransitionScreen.update(elapsedTime);
							break;
			case LEVELSELECTSCREEN: levelSelectScreen.update(elapsedTime);
							break;
		}
	}
	
	public void setActiveScreen(int screen){
		activeScreen = screen;
		Driver.log("Active Screen set to " + screen);
	}
	

}
