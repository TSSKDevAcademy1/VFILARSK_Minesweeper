package myCore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class FieldLoader {

	public void save(Field field) throws IOException{
		 File file = new File("field.bin");
	     FileOutputStream fOutputStream = new FileOutputStream(file);
	     ObjectOutputStream oOutputStream = new ObjectOutputStream(fOutputStream);
	     oOutputStream.writeObject(field);
	     oOutputStream.close();  
	}

	public Field load() throws ClassNotFoundException, IOException{ 
		Field field;
		try (FileInputStream fInputStream = new FileInputStream("field.bin");
				ObjectInputStream oInputStream = new ObjectInputStream(fInputStream);) {
			
				field = (Field) oInputStream.readObject();
				
			
		}
		
		return field;
	}
}
