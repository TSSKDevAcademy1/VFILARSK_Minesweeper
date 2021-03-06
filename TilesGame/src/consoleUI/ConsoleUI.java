package consoleUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

import myCore.BestTimes;
import myCore.Field;
import myCore.FieldLoader;
import myCore.GameState;



public class ConsoleUI implements Serializable {

	GameState gameState;
	Field field;
	BestTimes bestTimes;
	FieldLoader fLoader;
	int emptyRow = 0;
	int emptyColumn = 0;
	private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	public ConsoleUI(Field field,BestTimes bestTimes,FieldLoader fLoader) throws IOException, ClassNotFoundException{
		gameState = GameState.PLAYING;
		this.field = field;
		this.bestTimes = bestTimes;
		this.fLoader = fLoader;
		update();
	}
	
	public ConsoleUI(BestTimes bestTimes,FieldLoader fLoader) throws IOException, ClassNotFoundException{
		gameState = GameState.PLAYING;
		this.field = fLoader.load();
		this.bestTimes = bestTimes;
		this.fLoader = fLoader;
		update();
	}
	 /**
     * Communication with player.
     */
	public void processInput() throws IOException{
		System.out.println("Vyber volbu: new pre novu hru,save pre ulozenie,exit pre ukoncenie,best pre najlepsie casy, w s a d pre ovladanie");
		String line = input.readLine();
		switch(line){
		case "new": newGame();break;
		case "exit": exit();break;
		case "w": moveUp(field);break;
		case "a": moveLeft();break;
		case "s": moveDown(field);break;
		case "d": moveRight();break;
		case "best": bestTimes();break;
		case "save": save();break;
		}
	}
	
	public void bestTimes(){
		System.out.println(bestTimes.toString());
	}
	
	public void newGame(){
		
	}
	
	public void exit(){
		System.exit(0);
	}
	
	public void save() throws IOException{
		fLoader.save(field);
	}
	
	 /**
     * Make move in field.
     * @param field field
     */
	public void moveUp(Field field) {
		isEmpty();
		if (emptyRow + 1 <= field.getRowCount() -1) {
			System.out.println("Teraz idem");
			field.setTile(emptyRow, emptyColumn, field.getTile(emptyRow + 1, emptyColumn).getValue());
			System.out.println("Teraz idem");
			field.setTile(emptyRow + 1, emptyColumn, 99);

		}
	}
	
	public void moveDown(Field field) {
		isEmpty();
		if (emptyRow - 1 >= 0) {
			System.out.println("Teraz idem");
			field.setTile(emptyRow, emptyColumn, field.getTile(emptyRow - 1, emptyColumn).getValue());
			System.out.println("Teraz idem");
			field.setTile(emptyRow - 1, emptyColumn, 99);

		}
	}
	
	public void moveRight(){
		isEmpty();
		if (emptyColumn - 1 >= 0) {
			System.out.println("Teraz idem");
			field.setTile(emptyRow, emptyColumn, field.getTile(emptyRow, emptyColumn-1).getValue());
			System.out.println("Teraz idem");
			field.setTile(emptyRow, emptyColumn-1, 99);

		}
	}
	
	public void moveLeft(){
		isEmpty();
		if (emptyColumn + 1 <= field.getRowCount()-1) {
			System.out.println("Teraz idem");
			field.setTile(emptyRow, emptyColumn, field.getTile(emptyRow, emptyColumn + 1).getValue());
			System.out.println("Teraz idem");
			field.setTile(emptyRow, emptyColumn + 1, 99);

		}
	}
	
	public void update() throws IOException {
		long time = System.currentTimeMillis();
		while (true) {
			if(isSucessfull()){
				gameState = GameState.SOLVED;
			}
			if (gameState.equals(GameState.PLAYING)) {
				System.out.println("Uspech: " + isSucessfull());
				field.vypis();
				processInput();
			} else if (gameState.equals(GameState.SOLVED)) {
				time = (System.currentTimeMillis() - time)/1000;
				int intTime = (int) time;
				bestTimes.addPlayerTime("Vlado", intTime);
				System.exit(0);
			} else {
			}

		}
	}
	
	public boolean isSucessfull() {
		boolean bool = true;
		int actValue = 0;
		for (int r = 0; r < field.getRowCount(); r++) {
			for (int c = 0; c < field.getColumnCount(); c++) {
				if(actValue > field.getTile(r, c).getValue()){
					bool = false;
				}
				actValue = field.getTile(r, c).getValue();
			}
		}
		return bool;
	}
	
	public void isEmpty(){
		for (int r = 0; r < field.getRowCount(); r++) {
			for (int c = 0; c < field.getColumnCount(); c++) {
				if (field.getTile(r, c).getValue() == 99) {
					emptyRow = field.getTile(r, c).getPositionX();
					emptyColumn = field.getTile(r, c).getPositionY();
					System.out.printf("Pozicia: " + emptyRow + emptyColumn + "\n");
				}
			}
		}
	}
	
}

