package main.java;

import java.net.URL;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;

import main.java.TWLSlick.TWLStateBasedGame;

public class TWLStateBasedGameTestbed  extends TWLStateBasedGame {
	
	public static final int MAINMENUSTATE = 0;
	
	public static int height=400;
	public static int width=600;
	public static final boolean defaultFullScreenMode=false;
	private static ScalableGame scalableGameTest;
	private static AppGameContainer container;
	
	private static String WINDOW_TITLE = "Test";
	
	protected TWLStateBasedGameTestbed(){super(WINDOW_TITLE);}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("worked");
		System.out.println("URL:"+TWLStateBasedGameTestbed.class.getResource("resources/ui/simple/simple.xml"));
		
		try {
			scalableGameTest = new ScalableGame(new TWLStateBasedGameTestbed(),width,height);
			container = new AppGameContainer(scalableGameTest,width,height,defaultFullScreenMode);
			//container.setMinimumLogicUpdateInterval(20);
			//container.setMaximumLogicUpdateInterval(20);
			//container.setVSync(false);
			//container.setClearEachFrame(false);
			container.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("done");
		
	}

	@Override
	protected URL getThemeURL() {
		// TODO Auto-generated method stub
		return TWLStateBasedGameTestbed.class.getResource("resources/ui/simple/simple.xml");
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		this.addState(new MainMenuState());
		
	}

}
