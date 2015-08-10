package tvary;

public class Triangle extends Shape{

	private int size;
	
	public Triangle(int size, int x,int y, char fill){
		super(x,y,fill);
		this.size = size;
	}
	
	public Triangle(int size){
		super();
		this.size = size;
	}
	
	public void setSize(int size){
		this.size = size;
	}
	
	public int getSize(int size){
		return this.size;
	}
	
	
	public String toString(int size){
        int i = 0;
        String triangle="";
        while(i < size) {
            triangle = triangle + printChars(size - i - 1, ' ');
            triangle =  triangle + printChars(2 * (i)+1, '*');
            triangle= triangle + "\n";
            i++;
        }
        return triangle;
	}
	
	 private String printChars(int length, char c) {
		 String triangleLine = "";
	        for(int j = 0; j < length; j++) {
	            triangleLine = triangleLine + c;
	        }
	        return triangleLine;
	    }
}
