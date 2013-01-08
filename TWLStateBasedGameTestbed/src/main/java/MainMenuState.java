package main.java;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import de.matthiasmann.twl.Button;
import main.java.TWLSlick.BasicTWLGameState;
//import main.java.TWLSlick.RootPane;

public class MainMenuState extends BasicTWLGameState {

	@Override
	   public int getID() {
	      return 1;
	   }
	   
	  @Override
	   public void enter(GameContainer container, StateBasedGame game)
	         throws SlickException {
	      // TODO Auto-generated method stub
	super.enter(container, game);
	     
	      Button btn = new Button("Hello world");
	      btn.setSize(100,50);
	      btn.setPosition(300, 300);
	      btn.addCallback(new Runnable() {
	         @Override
	         public void run() {
	            System.out.println("Hello Slick world! This button works!");
	         }
	      });
	      getRootPane().add(btn);
	   }
	   
	   @Override
	   public void init(GameContainer container, StateBasedGame game)
	         throws SlickException {}   
	   @Override
	   public void render(GameContainer container, StateBasedGame game, Graphics g)
	         throws SlickException {}
	   @Override
	   public void update(GameContainer container, StateBasedGame game, int delta)
	         throws SlickException {}
	
	
	
/*
 *     private Button btn;
    public int stateID=-1;
    
    MainMenuState( int stateID ) 
    {
       this.stateID = stateID;
    }

      
    
    @Override
    protected RootPane createRootPane() {
        RootPane rp = super.createRootPane();
        rp.setTheme("mainMenu");

        btn = new Button("Hello World");
        btn.addCallback(new Runnable() {
            public void run() {
                System.out.println("It works!");
            }
        });

        rp.add(btn);
        return rp;
    }

    @Override
    protected void layoutRootPane() {
        btn.adjustSize();
        btn.setPosition(100, 100);
    }

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}
*/
}
