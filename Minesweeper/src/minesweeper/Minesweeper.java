package minesweeper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    private Minesweeper() throws ClassNotFoundException, IOException {
    	instance = this;
    	 BestTimes casy = new BestTimes();
    	 System.out.println(casy.toString());
    	System.out.println("Ahoj " + System.getProperty("user.name"));
    	startMillis = System.currentTimeMillis();
       // Field field = new Field(9, 9, 10);
        
        userInterface = new ConsoleUI(bestTimes);
        
      // userInterface.newGameStarted(field);
       setting = Settings.load();
       Field field = new Field(setting.getColumnCount(), setting.getRowCount(), setting.getMineCount());
       this.setSetting(setting);
       userInterface.newGameStarted(field);
     
       //System.out.println(field.toString());
       System.out.println("Hra skoncila v maine");
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
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        new Minesweeper();
    }

	public Settings getSetting() {
		return setting;
	}

	public void setSetting(Settings setting) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		this.setting = setting;
		this.setting.save();
	}
    
   
    
}
