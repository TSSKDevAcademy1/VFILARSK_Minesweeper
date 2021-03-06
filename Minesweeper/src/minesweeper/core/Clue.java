package minesweeper.core;

/**
 * Clue tile.
 */
public class Clue  extends Tile {
    /** Value of the clue. */
    private final int value;
    
    /**
     * Constructor.
     * @param value  value of the clue
     */
    public Clue(int value) {
        this.value = value;
    }

	public int getValue() {
		return value;
	}
	
	public String toString(){
		String string = "";
		if(this.getState() == State.OPEN){
			string = value+"";
		} else if(this.getState() == State.MARKED){
			string="M";
		} else {
			string="-";
		}
		
		return string;
	}
	
}
