package register;

import java.io.DataInputStream;
import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by jaro on 3.2.2014.
 */
public class Main {

    public static void main(String[] args) throws Exception {
         ListRegister register = new ListRegister();
      /*   register.addPerson(new Person("Fi3lfsdcxyip Filarsky", "09001213456"));
         register.addPerson(new Person("Fil4sdc&xaip Filarsky", "0900122123452"));
         register.addPerson(new Person("Vlads6aimXCir Filarsky", "09004123451"));
         register.addPerson(new Person("Filisa1p FiVXCVlarsky", "09001123456"));
         register.addPerson(new Person("Filip&V1 Filarsky", "09001234456"));
         register.addPerson(new Person("Draho Xt21ina Filarska", "0900123452"));
         register.addPerson(new Person("Vladimir110 Filarsky", "0900123451"));
         register.addPerson(new Person("Filip Fi02larsky", "09001234256"));
         File file = new File("register2.bin");
         FileOutputStream fOutputStream = new FileOutputStream(file);
         ObjectOutputStream oOutputStream = new ObjectOutputStream(fOutputStream);
        
         oOutputStream.writeObject(register);
         oOutputStream.close();  */
         FileInputStream fInputStream = new FileInputStream("register.bin");
         ObjectInputStream oInputStream = new ObjectInputStream(fInputStream);
         register = (ListRegister)oInputStream.readObject();
         
       
        
        

        ConsoleUI ui = new ConsoleUI(register);
        ui.run();
    }
}
