package minesweeper;

import minesweeper.consoleui.ConsoleUI;
import minesweeper.core.Field;

/**
 * Main application class.
 */
public class Minesweeper {
    /** User interface. */
    private UserInterface userInterface;
 
    /**
     * Constructor.
     */
    private Minesweeper() {
    	System.out.println("Ahoj " + System.getProperty("user.name"));
        Field field = new Field(9, 9, 10);
        
        userInterface = new ConsoleUI();
        
       userInterface.newGameStarted(field);
        
       //System.out.println(field.toString());
       // System.out.println("vytvoril som minesweepera");
    }

    /**
     * Main method.
     * @param args arguments
     */
    public static void main(String[] args) {
        new Minesweeper();
    }
}
