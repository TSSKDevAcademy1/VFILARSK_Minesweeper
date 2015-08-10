package minesweeper.core;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class Settings implements Serializable{

	private final int rowCount;
	private final int columnCount;
	private final int mineCount;
	public static final Settings BEGINNER= new Settings(9,9,10);
	public static final Settings INTERMEDIATE= new Settings(16,16,40);
	public static final Settings EXPERT= new Settings(16,30,99);
	private static final String SETTING_FILE = (System.getProperty("user.home") + System.getProperty("file.separator") + "minesweeper.settings");
	
	
	public Settings(int rowCount, int columnCount, int mineCount){
		this.rowCount = rowCount;
		this.columnCount = columnCount;
		this.mineCount =  mineCount;
	}

	public int getRowCount() {
		return rowCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public int getMineCount() {
		return mineCount;
	}
	
	public boolean equals(Object o){
		if(this.equals(o) ){
			return true;
		} else return false;
	}
	
	public int hashCode(){
		return rowCount*columnCount*mineCount;
	}
	
	public void Save() throws UnsupportedEncodingException, FileNotFoundException, IOException{
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream(System.getProperty("user.home") + System.getProperty("file.separator") + "minesweeper.settings"), "utf-8"))) {
	}
		FileOutputStream fOutStream = new FileOutputStream(SETTING_FILE);
		ObjectOutputStream oOutStream = new ObjectOutputStream(fOutStream);
		oOutStream.writeObject(this);
		oOutStream.close();
	}
	
	public static Settings load() throws IOException, ClassNotFoundException{
		FileInputStream fInStream = new FileInputStream(SETTING_FILE);
		ObjectInputStream oInStream = new ObjectInputStream(fInStream);
		Settings setr = (Settings)oInStream.readObject();
		oInStream.close();
		return setr;
	}
	
}
