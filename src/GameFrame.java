import java.awt.Graphics2D;
import java.util.ArrayList;

import com.golden.gamedev.Game;


public class GameFrame extends Game{
	
	ArrayList<Drop> drops = new ArrayList<Drop>();
	
	
	public void initResources() {
		
	}

	@Override
	public void render(Graphics2D gd) {
		fontManager.getFont("FPS Font").drawString(gd, " ", 200, 350);
		MainScreen.render(this,gd);
	}

	@Override
	public void update(long arg0) {
		
	}

}
