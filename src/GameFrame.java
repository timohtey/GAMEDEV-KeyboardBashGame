import java.awt.Graphics2D;
import java.util.ArrayList;

import com.golden.gamedev.Game;


public class GameFrame extends Game{
	static int activeScreen;
	public final static int PLAYSCREEN = 0;
	public final static int MAINSCREEN = 1;
	PlayScreen playScreen;
	MainScreen mainScreen;
	public void initResources() {
		activeScreen = 1;
		playScreen = new PlayScreen(this);
		mainScreen = new MainScreen(this);
	}
	
	@Override
	public void render(Graphics2D gd) {
		switch(activeScreen){
			case PLAYSCREEN: playScreen.render(gd); 
							 break;
			case MAINSCREEN: mainScreen.render(gd);
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
		}
	}
	
	public void setActiveScreen(int screen){
		activeScreen = screen;
		if(screen == PLAYSCREEN){
			playScreen.playSound();
		}
		Driver.log("Active Screen set to " + screen);
	}
	

}
