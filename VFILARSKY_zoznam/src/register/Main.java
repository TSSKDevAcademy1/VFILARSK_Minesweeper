package register;

/**
 * Created by jaro on 3.2.2014.
 */
public class Main {

    public static void main(String[] args) throws Exception {
         Register register = new ListRegister();

         
         
        register.addPerson(new Person("Fi3lfsdcxyip Filarsky", "09001213456"));
        register.addPerson(new Person("Fil4sdc&xaip Filarsky", "0900122123452"));
        register.addPerson(new Person("Vlads6aimXCir Filarsky", "09004123451"));
        register.addPerson(new Person("Filisa1p FiVXCVlarsky", "09001123456"));
        register.addPerson(new Person("Filip&V1 Filarsky", "09001234456"));
        register.addPerson(new Person("Draho Xt21ina Filarska", "0900123452"));
        register.addPerson(new Person("Vladimir110 Filarsky", "0900123451"));
        register.addPerson(new Person("Filip Fi02larsky", "09001234256"));
        register.addPerson(new Person("Filip Fila32rsky", "09001234456"));
        register.addPerson(new Person("Dra1hotina251 Filarska", "09100123452"));
        register.addPerson(new Person("Vlad47imir F4ilarsky", "0900123451"));
        register.addPerson(new Person("Fil2ip Filars7ky", "0900123456"));
        register.addPerson(new Person("Fi3lip Filarsk8y", "0900123456"));
        register.addPerson(new Person("Dr4ahotina Fila9rska", "0900123452"));
        register.addPerson(new Person("Vladi7DASmir Fil6arsky", "0900123451"));
        register.addPerson(new Person("Dr4ahotina Filars2ka", "0900123452"));
        register.addPerson(new Person("Vladi7DeeASmir Filarsky", "090012345"));
        register.addPerson(new Person("Vladi7DArrSmir Filarsky", "090541201231"));
        register.addPerson(new Person("Vladi7DAffSmir Filarsky", "090120451"));
        register.addPerson(new Person("Vladi7DAddSmir Filarsky", "12223451"));
        
        register.addPerson(new Person("Vladi7DASmiaar Filarsky", "00127783451"));
        register.addPerson(new Person("Vladi7DASmirxas Filarsky", "00988123451"));
        register.addPerson(new Person("Vladi7DASmirxas Filarsky33", "3300988123451"));
       
        register.addPerson(new Person("Vladi7DASmirxasdsdsa Filarsky", "009881415123451"));
        register.addPerson(new Person("Vladi7DASmirxasaaa Filarsky33", "3300974188123451"));
        
        

        ConsoleUI ui = new ConsoleUI(register);
        ui.run();
    }
}
