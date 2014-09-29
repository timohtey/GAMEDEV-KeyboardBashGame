import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import com.golden.gamedev.Game;
import com.golden.gamedev.object.Sprite;


public class MainScreen {
	
	public void readInput(){
		
	}
	
	public static void render(Game g, Graphics2D gd){
		
		gd.setColor(Color.gray);
		g.fontManager.getFont("Arial").drawString(gd, "Start Game", 200, 350);
	}
}
