package minesweeper.consoleui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import minesweeper.UserInterface;
import minesweeper.core.Field;
import minesweeper.core.GameState;

/**
 * Console user interface.
 */
public class ConsoleUI implements UserInterface {
    /** Playing field. */
    private Field field;
    
    /** Input reader. */
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
    /**
     * Reads line of text from the reader.
     * @return line as a string
     */
    private String readLine() {
        try {
            return input.readLine();
        } catch (IOException e) {
            return null;
        }
    }
    
    /* (non-Javadoc)
	 * @see minesweeper.consoleui.UserInterface#newGameStarted(minesweeper.core.Field)
	 */
    @Override
	public void newGameStarted(Field field) {
        this.field = field;
        if(field.getGameState() == GameState.SOLVED || field.getGameState() == GameState.FAILED) {
        	System.out.println("Hra �spe�ne/ne�spe�ne ukon�en�");
        	System.exit(0);
        }
        do {
           update();
           processInput();
            
        } while(true);
    }
    
    /* (non-Javadoc)
	 * @see minesweeper.consoleui.UserInterface#update()
	 */
    @Override
	public void update() {
    	System.out.println("Pocet nenajdenych min: "+ field.getRemainigMineCount());
    	String pole = field.toString();
    	System.out.printf("%4s"," ");
    	for(int i = 1;i<=field.getColumnCount();i++){
    		System.out.printf("%4s",i);
    	}
    	System.out.printf("%n");
    	System.out.printf("%n");
    	for(int r =0;r<field.getRowCount();r++){
    		System.out.printf("%4s", Character.toString((char)(65+r)));
    		for(int c=0;c<field.getColumnCount();c++){
    				System.out.printf("%4s",field.getTile(r, c));
    		}
    		System.out.printf("%n");
    	}

		
    	
    }
    
    /**
     * Processes user input.
     * Reads line from console and does the action on a playing field according to input string.
     */
    private void processInput() {
    	try {
	    	System.out.println();
			System.out.println("Please enter your selection (X) EXIT, (MA1) MARK, (OB4) OPEN :");
			String input = readLine();
			handleInput(input);
    	} catch (WrongFormatException ex) {
    		System.out.println(ex.getMessage());
    	}
		
		
    }
    
    public void handleInput(String input) throws WrongFormatException{
		Pattern p = Pattern.compile("X|(O|M)[A-I][1-9]");
		Matcher m = p.matcher(input);
		boolean b = m.matches();
		System.out.println("presiel");
		if(b){
			System.out.println("presiel vzor");
			char firstLetter = input.charAt(0);
			switch(firstLetter){
			case 'X': field.setGameState(GameState.FAILED);break;
			case 'M': field.markTile(((int)input.charAt(1))-65,((int)input.charAt(2))-49);break;
			case 'O': field.openTile(((int)input.charAt(1))-65,((int)input.charAt(2))-49);break;
			}
		} else {
			throw new WrongFormatException("Nespravny format");
		}
    }

}

//format("%" + n + "s","x")
//new Formatter.format("%4s",c).toString
