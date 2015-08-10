package minesweeper;

import minesweeper.consoleui.ConsoleUI;
import minesweeper.core.Field;
import minesweeper.core.Settings;

/**
 * Main application class.
 */
public class Minesweeper {
    /** User interface. */
    private UserInterface userInterface;
    private long startMillis;
    private BestTimes bestTimes = new BestTimes();
    private static Minesweeper instance;
    private Settings setting;
 
    /**
     * Constructor.
     */
    private Minesweeper() {
    	instance = this;
    	 BestTimes casy = new BestTimes();
         System.out.println(casy.toString());
    	System.out.println("Ahoj " + System.getProperty("user.name"));
    	startMillis = System.currentTimeMillis();
        Field field = new Field(9, 9, 10);
        
        userInterface = new ConsoleUI();
        
       userInterface.newGameStarted(field);
        
       //System.out.println(field.toString());
       // System.out.println("vytvoril som minesweepera");
    }
    
    public int getPlayingSeconds(){
    	return (int)((System.currentTimeMillis() - startMillis)/1000);
    }
    
    public BestTimes getBestTimes(){
    	return bestTimes;
    }

    public static Minesweeper getInstance(){
    	return instance;
    }
    /**
     * Main method.
     * @param args arguments
     */
    public static void main(String[] args) {
        new Minesweeper();
    }

	public Settings getSetting() {
		return setting;
	}

	public void setSetting(Settings setting) {
		this.setting = setting;
	}
    
   
    
}
