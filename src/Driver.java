import java.awt.Dimension;

import com.golden.gamedev.GameLoader;


public class Driver {
    public static void main(String[] args) {
        GameFrame gf = new GameFrame();
        GameLoader game = new GameLoader();
        game.setup(gf,new Dimension(640,640), false);
        game.start();
    }
    
    public static void log(Object obj){
    	System.out.println(obj);
    }
}
