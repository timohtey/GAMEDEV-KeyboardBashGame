import java.awt.Graphics2D;
import java.util.ArrayList;

import com.golden.gamedev.Game;


public class GameFrame extends Game{
	int activeScreen;
	final int PLAYSCREEN = 0;
	PlayScreen playScreen;
	public void initResources() {
		activeScreen = 0;
		playScreen = new PlayScreen(this);
	}

	@Override
	public void render(Graphics2D gd) {
		switch(activeScreen){
			case PLAYSCREEN: playScreen.render(gd); 
							 break;
		}
	}

	@Override
	public void update(long elapsedTime) {
		switch(activeScreen){
			case PLAYSCREEN: playScreen.update(elapsedTime); 
							 break;
		}
	}

}
