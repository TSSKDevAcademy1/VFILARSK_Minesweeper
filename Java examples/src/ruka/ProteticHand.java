package ruka;

public class ProteticHand extends Hand{
    private int generacia;
    private int stupenOvladatelnosti;
    private int pocetMotorov;
    
    public ProteticHand(int generacia,int stupenOvladatelnosti,int pocetMotorov){
    	this.setGeneracia(generacia);
    	this.setStupenOvladatelnosti(stupenOvladatelnosti);
    	this.setPocetMotorov(pocetMotorov);
    }
    
    public ProteticHand(){
    	this.setGeneracia(1);
    	this.setStupenOvladatelnosti(1);
    	this.setPocetMotorov(1);
    }

	public int getGeneracia() {
		return generacia;
	}

	public void setGeneracia(int generacia) {
		this.generacia = generacia;
	}

	public int getStupenOvladatelnosti() {
		return stupenOvladatelnosti;
	}

	public void setStupenOvladatelnosti(int stupenOvladatelnosti) {
		this.stupenOvladatelnosti = stupenOvladatelnosti;
	}

	public int getPocetMotorov() {
		return pocetMotorov;
	}

	public void setPocetMotorov(int pocetMotorov) {
		this.pocetMotorov = pocetMotorov;
	}
    
    
    
    
    
}
