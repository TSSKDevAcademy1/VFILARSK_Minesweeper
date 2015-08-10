package ruka;

public class Person {
	

	private String name;
	private int age;
	private Hand lava = null;
	private Hand prava = null;
	
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	

	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getAge(){
		return this.age;
	}
	
	
	public boolean setAge(int age){
		if(isValidAge(age)){
		this.age = age;
		return true;
		} else {
			return false;
		}
	}
	
	private boolean isValidAge(int age){
		return(age >0 && age < 150);
	}
	
	public String toString() {
		System.out.println(name +  "(" + age + ")");
		return(this.name +  "(" + age + ")");
	}
	
	public void addHand(String orientaciaRuky, String typRuky){
		if(typRuky.equalsIgnoreCase("proteticka") || typRuky.equalsIgnoreCase("nuturalna")){
			if(orientaciaRuky.equalsIgnoreCase("lava") && (lava == null)){
				if(typRuky.equalsIgnoreCase("proteticka")){
					this.lava = new ProteticHand();
				} else {
					this.lava = new Hand();
				}
			} else if(orientaciaRuky.equalsIgnoreCase("prava") && (prava ==null)){
				if(typRuky.equalsIgnoreCase("proteticka")){
					this.lava = new ProteticHand();
				} else {
					this.lava = new Hand();
				}
			} else {
				System.out.println("Nieco robis zle, ruka sa enda vytvorit");
			}
		}
	}
}
