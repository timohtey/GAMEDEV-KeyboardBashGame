import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Level {
	private GameFrame gameFrame;
	
	private int level;
	private ArrayList<Key> keys = new ArrayList<Key>();
	private BufferedImage[] bufferedImage1 = new BufferedImage[2];
	private BufferedImage[] bufferedImage2 = new BufferedImage[2];
	private BufferedImage[] bufferedImage3 = new BufferedImage[2];
	private BufferedImage[] bufferedImage4 = new BufferedImage[2];
	private BufferedImage[] bufferedImage5 = new BufferedImage[2];
	private BufferedImage[] bufferedImage6 = new BufferedImage[2];
	private BufferedImage[] bufferedImage7 = new BufferedImage[2];
	private BufferedImage[] bufferedImage8 = new BufferedImage[2];
	
	public Level(int level, GameFrame gameFrame){
		this.level = level;
		this.gameFrame = gameFrame;

		bufferedImage1 = gameFrame.getImages("assets/spritesheet1.png", 2, 1);
		bufferedImage2 = gameFrame.getImages("assets/spritesheet2.png", 2, 1);
		bufferedImage3 = gameFrame.getImages("assets/spritesheet3.png", 2, 1);
		bufferedImage4 = gameFrame.getImages("assets/spritesheet4.png", 2, 1);
		bufferedImage5 = gameFrame.getImages("assets/spritesheet5.png", 2, 1);
		bufferedImage6 = gameFrame.getImages("assets/spritesheet6.png", 2, 1);
		bufferedImage7 = gameFrame.getImages("assets/spritesheet7.png", 2, 1);
		bufferedImage8 = gameFrame.getImages("assets/spritesheet8.png", 2, 1);
		
		switch(level){
			case 0: setupLevel1();
					break;
			case 1: setupLevel2();
					break;
		}
		
		initializeKeyAnimations();
	}

	private void initializeKeyAnimations() {
		for(int i = 0; i<keys.size();i++){
			keys.get(i).getAnimationTimer().setDelay(300);
			keys.get(i).setAnimate(true);
			keys.get(i).setLoopAnim(true);
		}
		
	}

	private void setupLevel1() {
		// add keys here
		keys.add(new Key(bufferedImage1, 0.0, 0.0, KeyEvent.VK_1, 1000));
		keys.add(new Key(bufferedImage1, 0.0, 0.0, KeyEvent.VK_1, 2000));
		keys.add(new Key(bufferedImage2, 0.0, 0.0, KeyEvent.VK_2, 2000));
		keys.add(new Key(bufferedImage3, 0.0, 0.0, KeyEvent.VK_3, 3000));
		keys.add(new Key(bufferedImage4, 0.0, 0.0, KeyEvent.VK_4, 4000));
		keys.add(new Key(bufferedImage5, 0.0, 0.0, KeyEvent.VK_5, 5000));
		keys.add(new Key(bufferedImage6, 0.0, 0.0, KeyEvent.VK_6, 6000));
		keys.add(new Key(bufferedImage7, 0.0, 0.0, KeyEvent.VK_7, 7000));
		keys.add(new Key(bufferedImage8, 0.0, 0.0, KeyEvent.VK_8, 8000));
		
		
		int time = 10000;
		keys.add(new Key(bufferedImage1, 0.0, 0.0, KeyEvent.VK_1, time));
		keys.add(new Key(bufferedImage2, 0.0, 0.0, KeyEvent.VK_2, time+100));
		keys.add(new Key(bufferedImage3, 0.0, 0.0, KeyEvent.VK_3, time+200));
		keys.add(new Key(bufferedImage4, 0.0, 0.0, KeyEvent.VK_4, time+300));
		keys.add(new Key(bufferedImage5, 0.0, 0.0, KeyEvent.VK_5, time+400));
		keys.add(new Key(bufferedImage6, 0.0, 0.0, KeyEvent.VK_6, time+500));
		keys.add(new Key(bufferedImage7, 0.0, 0.0, KeyEvent.VK_7, time+600));
		keys.add(new Key(bufferedImage8, 0.0, 0.0, KeyEvent.VK_8, time+700));
		
	}

	private void setupLevel2() {
		// add keys here
		
		int time = 4500;
		
		// plucking
		keys.add(new Key(bufferedImage1, 0.0, 0.0, KeyEvent.VK_1, time));
		keys.add(new Key(bufferedImage2, 0.0, 0.0, KeyEvent.VK_2, time+35));
		keys.add(new Key(bufferedImage3, 0.0, 0.0, KeyEvent.VK_3, time+70));
		
		keys.add(new Key(bufferedImage1, 0.0, 0.0, KeyEvent.VK_1, time+2100));
		keys.add(new Key(bufferedImage2, 0.0, 0.0, KeyEvent.VK_2, time+2400));
		keys.add(new Key(bufferedImage3, 0.0, 0.0, KeyEvent.VK_3, time+3500));
		keys.add(new Key(bufferedImage4, 0.0, 0.0, KeyEvent.VK_4, time+4000));
		keys.add(new Key(bufferedImage1, 0.0, 0.0, KeyEvent.VK_1, time+4800));
		keys.add(new Key(bufferedImage2, 0.0, 0.0, KeyEvent.VK_2, time+5400));
		
		keys.add(new Key(bufferedImage1, 0.0, 0.0, KeyEvent.VK_1, time+7600));
		keys.add(new Key(bufferedImage2, 0.0, 0.0, KeyEvent.VK_2, time+8200));
		keys.add(new Key(bufferedImage3, 0.0, 0.0, KeyEvent.VK_3, time+9000));
		keys.add(new Key(bufferedImage1, 0.0, 0.0, KeyEvent.VK_1, time+9700));
		keys.add(new Key(bufferedImage2, 0.0, 0.0, KeyEvent.VK_2, time+10800));
		
		keys.add(new Key(bufferedImage1, 0.0, 0.0, KeyEvent.VK_1, time+13000));
		keys.add(new Key(bufferedImage2, 0.0, 0.0, KeyEvent.VK_2, time+13400));
		keys.add(new Key(bufferedImage3, 0.0, 0.0, KeyEvent.VK_3, time+14500));
		keys.add(new Key(bufferedImage4, 0.0, 0.0, KeyEvent.VK_4, time+15000));
		keys.add(new Key(bufferedImage1, 0.0, 0.0, KeyEvent.VK_1, time+15800));
		keys.add(new Key(bufferedImage2, 0.0, 0.0, KeyEvent.VK_2, time+16400));
	
		keys.add(new Key(bufferedImage1, 0.0, 0.0, KeyEvent.VK_1, time+18600));
		keys.add(new Key(bufferedImage2, 0.0, 0.0, KeyEvent.VK_2, time+19200));
		keys.add(new Key(bufferedImage3, 0.0, 0.0, KeyEvent.VK_3, time+20000));
		keys.add(new Key(bufferedImage4, 0.0, 0.0, KeyEvent.VK_4, time+20700));
		keys.add(new Key(bufferedImage1, 0.0, 0.0, KeyEvent.VK_1, time+21800));
		
		// bass
		keys.add(new Key(bufferedImage7, 0.0, 0.0, KeyEvent.VK_7, time+100));
		keys.add(new Key(bufferedImage7, 0.0, 0.0, KeyEvent.VK_7, time+400));
		keys.add(new Key(bufferedImage7, 0.0, 0.0, KeyEvent.VK_7, time+700));
		keys.add(new Key(bufferedImage7, 0.0, 0.0, KeyEvent.VK_7, time+1000));
		keys.add(new Key(bufferedImage8, 0.0, 0.0, KeyEvent.VK_8, time+2600));
		keys.add(new Key(bufferedImage8, 0.0, 0.0, KeyEvent.VK_8, time+2900));
		keys.add(new Key(bufferedImage8, 0.0, 0.0, KeyEvent.VK_8, time+3200));
		keys.add(new Key(bufferedImage8, 0.0, 0.0, KeyEvent.VK_8, time+3500));
		keys.add(new Key(bufferedImage8, 0.0, 0.0, KeyEvent.VK_8, time+3800));
		keys.add(new Key(bufferedImage7, 0.0, 0.0, KeyEvent.VK_7, time+5500));
		keys.add(new Key(bufferedImage7, 0.0, 0.0, KeyEvent.VK_7, time+5800));
		keys.add(new Key(bufferedImage7, 0.0, 0.0, KeyEvent.VK_7, time+6100));
		keys.add(new Key(bufferedImage7, 0.0, 0.0, KeyEvent.VK_7, time+6400));
		keys.add(new Key(bufferedImage7, 0.0, 0.0, KeyEvent.VK_7, time+6700));
		keys.add(new Key(bufferedImage8, 0.0, 0.0, KeyEvent.VK_8, time+8100));
		keys.add(new Key(bufferedImage8, 0.0, 0.0, KeyEvent.VK_8, time+8400));
		keys.add(new Key(bufferedImage8, 0.0, 0.0, KeyEvent.VK_8, time+8700));
		keys.add(new Key(bufferedImage8, 0.0, 0.0, KeyEvent.VK_8, time+9000));
		keys.add(new Key(bufferedImage8, 0.0, 0.0, KeyEvent.VK_8, time+9300));
		keys.add(new Key(bufferedImage7, 0.0, 0.0, KeyEvent.VK_7, time+10900));
		keys.add(new Key(bufferedImage7, 0.0, 0.0, KeyEvent.VK_7, time+11200));
		keys.add(new Key(bufferedImage7, 0.0, 0.0, KeyEvent.VK_7, time+11500));
		keys.add(new Key(bufferedImage7, 0.0, 0.0, KeyEvent.VK_7, time+11800));
		keys.add(new Key(bufferedImage7, 0.0, 0.0, KeyEvent.VK_7, time+12100));
		keys.add(new Key(bufferedImage8, 0.0, 0.0, KeyEvent.VK_8, time+13800));
		keys.add(new Key(bufferedImage8, 0.0, 0.0, KeyEvent.VK_8, time+14100));
		keys.add(new Key(bufferedImage8, 0.0, 0.0, KeyEvent.VK_8, time+14400));
		keys.add(new Key(bufferedImage8, 0.0, 0.0, KeyEvent.VK_8, time+14700));
		keys.add(new Key(bufferedImage8, 0.0, 0.0, KeyEvent.VK_8, time+15000));
		keys.add(new Key(bufferedImage7, 0.0, 0.0, KeyEvent.VK_7, time+16600));
		keys.add(new Key(bufferedImage7, 0.0, 0.0, KeyEvent.VK_7, time+16900));
		keys.add(new Key(bufferedImage7, 0.0, 0.0, KeyEvent.VK_7, time+17200));
		keys.add(new Key(bufferedImage7, 0.0, 0.0, KeyEvent.VK_7, time+17500));
		keys.add(new Key(bufferedImage7, 0.0, 0.0, KeyEvent.VK_7, time+17800));
		keys.add(new Key(bufferedImage8, 0.0, 0.0, KeyEvent.VK_8, time+19300));
		keys.add(new Key(bufferedImage8, 0.0, 0.0, KeyEvent.VK_8, time+19600));
		keys.add(new Key(bufferedImage8, 0.0, 0.0, KeyEvent.VK_8, time+19900));
		keys.add(new Key(bufferedImage8, 0.0, 0.0, KeyEvent.VK_8, time+20200));
		keys.add(new Key(bufferedImage8, 0.0, 0.0, KeyEvent.VK_8, time+20500));
	}

	public ArrayList<Key> getKeys() {
		return keys;
	}

	public void setKeys(ArrayList<Key> keys) {
		this.keys = keys;
	}
}
