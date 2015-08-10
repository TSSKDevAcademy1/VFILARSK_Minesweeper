package ruka;

public class Hand {
    
    private int pocetPrstov = 0;
    private String orientaciaRuky = "";
    private String color = "";
    
    public Hand(int pocetPrstov,String orientaciaRuky, String color){
        setPocetPrstov(pocetPrstov);
        setOrientaciaRuky(orientaciaRuky);
        setColor(color);
    }
    
    public Hand(){
        
    }
    
    public void setPocetPrstov(int pocetPrstov){
        if((pocetPrstov >= 0) && (pocetPrstov <= 5 )){
        this.pocetPrstov = pocetPrstov;
        } else {
            System.out.println("Zle zadany pocet prstov");
        }
    }
    
    public void setOrientaciaRuky(String orientaciaRuky){
        if((orientaciaRuky.equalsIgnoreCase("lava")) || (orientaciaRuky.equalsIgnoreCase("prava"))){
        this.orientaciaRuky = orientaciaRuky;
        } else {
            System.out.println("Zle zadana orientacia ruky");
        }
    }
    public String getOrientaciaRuky(){
        return this.orientaciaRuky;
    }
    public int getPocetPrstov(){
        return this.pocetPrstov;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public String getColor(){
        return this.color;
    }
    
    public void pohni(String smer,int dlzkaPohybu){
    	
    }
    
}