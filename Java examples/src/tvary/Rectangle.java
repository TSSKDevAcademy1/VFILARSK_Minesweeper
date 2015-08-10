package tvary;

public class Rectangle extends Shape {

	private int width;
	private int height;
	
	public Rectangle(int width,int height, int x,int y, char fill){
		super(x,y,fill);
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(int width,int height){
		
		this.width = width;
		this.height = height;
	}
	
	public void setWidth(int width){
		this.width = width;
	}
	
	public int getWidth(){
		return this.width;
	}
	
	public void setHeight(int height){
		this.height = height;
	}
	
	public int getHeight(){
		return this.height;
	}
	
	public String toString(){
		int x =getX();
    	int y =getY();
    	char fill = getFill();
		String string = "";
		for(int h=0;h<=y;h++){
    		string = string + "\n";
    	}
		Line ciara = new Line(width,false);
		for(int i=0; i<height;i++){
			for(int j=0;j<=x;j++){
				string = string + " ";
			}
			string = string + ciara.toString();
			string = string + "\n";
		}
		return string;
	}
}
