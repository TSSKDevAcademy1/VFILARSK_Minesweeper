package tests;

import static org.junit.Assert.*;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import minesweeper.core.Clue;
import minesweeper.core.Field;
import minesweeper.core.GameState;
import minesweeper.core.Tile.State;

public class FieldTest {

    static final int ROWS = 9;
    static final int COLUMNS = 9;
    static final int MINES = 10;
    static final int row = 5;
    static final int column = 6;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test                
    public void isSolved() {
        Field field = new Field(ROWS, COLUMNS, MINES);
        
        assertEquals(GameState.PLAYING, field.getGameState());
        
        int open = 0;
        for(int row = 0; row < field.getRowCount(); row++) {
            for(int column = 0; column < field.getColumnCount(); column++) {
                if(field.getTile(row, column) instanceof Clue) {
                    field.openTile(row, column);
                    open++;
                }
                if(field.getRowCount() * field.getColumnCount() - open == field.getMineCount()) {
                    assertEquals(GameState.SOLVED, field.getGameState());
                } else {
                    assertNotSame(GameState.FAILED, field.getGameState());
                }
            }
        }
        
        assertEquals(GameState.SOLVED, field.getGameState());
    } 

	@Test
	public void generate(){
		int clueCount = 0;
		int mineCount = 0;
		Field field = new Field(ROWS,COLUMNS,MINES);
		 assertEquals(ROWS, field.getRowCount());
		 assertEquals(COLUMNS, field.getColumnCount());
		 assertEquals(MINES, field.getMineCount());
		 for(int row = 0; row < field.getRowCount(); row++) {
	            for(int column = 0; column < field.getColumnCount(); column++) {
	            	assertNotNull(field.getTile(row, column));
	            	if(field.getTile(row, column) instanceof Clue) {
	                    field.openTile(row, column);
	                    clueCount++;
	                } else {
	                	mineCount++;
	                }
	            }
		 }
		 assertEquals(ROWS * COLUMNS - MINES, clueCount);
		 assertEquals(MINES,mineCount);
	}
	
	@Test
	public void openTile(){
		Field field = new Field(ROWS,COLUMNS,MINES);
		if(field.getTile(row, column).getState() == State.OPEN){
			field.openTile(row,column);
			assertEquals(field.getTile(row, column).getState(),State.OPEN);
		} else if(field.getTile(row, column).getState() == State.CLOSED){
			field.openTile(row,column);
			assertEquals(field.getTile(row, column).getState(),State.OPEN);
		} else {
			field.openTile(row,column);
			assertEquals(field.getTile(row, column).getState(),State.OPEN);
		}
	}
	
	@Test
	public void markTile(){
		Field field = new Field(ROWS,COLUMNS,MINES);
		if(field.getTile(row, column).getState() == State.OPEN){
			field.markTile(row,column);
			assertEquals(field.getTile(row, column).getState(),State.OPEN);
		} else if(field.getTile(row, column).getState() == State.CLOSED){
			field.markTile(row,column);
			assertEquals(field.getTile(row, column).getState(),State.MARKED);
		} else {
			field.markTile(row,column);
			assertEquals(field.getTile(row, column).getState(),State.CLOSED);
		}
	}
	
	
}
