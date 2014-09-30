import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import com.golden.gamedev.Game;
import com.golden.gamedev.object.GameFont;
import com.golden.gamedev.object.Sprite;


public class MainScreen {
	GameFrame g;
	Sprite startButton;
	public MainScreen(GameFrame g){
		this.g=g;
		startButton = new Sprite(g.getImage("assets/startButton.png"),170,400);
	}
	
	public void readInput(){
		if(g.click()){
			if(g.checkPosMouse(startButton, false)){
				g.setActiveScreen(g.LEVELSELECTSCREEN);
			}
		}
	}
	
	public void render(Graphics2D gd){
		gd.setColor(Color.white);
		gd.fillRect(0, 0, g.getWidth(), g.getHeight());
		gd.drawImage(g.getImage("assets/splashName.png"), null, 120, 150);
		startButton.render(gd);
	}
	
	public void update(long elapsedTime){
		readInput();
	}
	
}
