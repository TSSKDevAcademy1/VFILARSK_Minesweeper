package minesweeper.consoleui;

/**
 * Wrong format exception.
 */
public class WrongFormatException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Constructor.
     * @param message message
     */
    public WrongFormatException(String message) {
        super(message);
    }
}