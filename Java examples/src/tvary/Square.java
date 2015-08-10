package tvary;

public class Square extends Shape{

	private int size;
	
	public Square(int size, int x,int y, char fill){
		super(x,y,fill);
		this.size =  size;
	}
	
	public Square(int size){
		super();
		this.size =  size;
	}
	
	public int getSize(){
		return this.size;
	}
	
	public String toString(){
		int x = getX();
		int y = getY();
		char fill = getFill();
		String square = "";
		for(int h=0;h<=y;h++){
    		square = square + "\n";
    	}
        for(int i = 0; i < size; i++) {
        	for(int n=0;n<=x;n++){
            	square = square + " ";}
            for(int j = 0; j < size; j++) {
            	   square = square + fill;
            }
            square = square + "\n";
        }
        return square;
	}
	
	
}
