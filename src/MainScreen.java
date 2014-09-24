import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import com.golden.gamedev.Game;
import com.golden.gamedev.object.Sprite;


public class MainScreen {
	
	static Sprite startButton = new Sprite(200,350);
	
	public void readInput(){
		
	}
	
	public static void render(Game g, Graphics2D gd){
		
		gd.setColor(Color.gray);
        gd.fillRect(startButton.getX(), g.getWidth(), g.getHeight());
		g.fontManager.getFont("Arial").drawString(gd, "Start Game", 200, 350);
	}
}
