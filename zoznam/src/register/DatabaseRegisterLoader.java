package register;

import java.io.File;
import java.io.IOException;

public class DatabaseRegisterLoader implements RegisterLoader{

	private File f;
	private String kindOfRegister;
	
	public DatabaseRegisterLoader(){
		initializite();
		System.out.println("Chces 1.pole alebo 2.kolekciu?");
		String choice = "2";
		switch(choice){
		case "1": Register register = isExist("class register.ListRegister"); fillRegister(register); kindOfRegister = "List";break;
		case "2": Register register2 = isExist("class register.ArrayRegister");fillRegister(register2);kindOfRegister = "Array"; break;
		}
	}
	
	private void initializite(){
		f = new File("register.bin");
	}
	
	@Override
	public void save(Register register) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Register load() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
