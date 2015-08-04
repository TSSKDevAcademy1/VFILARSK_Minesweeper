package minesweeper.core;

import minesweeper.core.Tile.State;

/**
 * Mine tile.
 */
public class Mine extends Tile {
	
	
	public String toString(){
		String string = "";
		if(this.getState() == State.OPEN){
			string = "*";
		} else if(this.getState() == State.MARKED){
			string="M";
		} else {
			string="P";
		}
		
		return string;
	}
}
