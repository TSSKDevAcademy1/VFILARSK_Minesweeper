package tvary;


public class Line extends Shape{
    private int length;
    private boolean vertical;
    
    public Line(int length, boolean vertical, int x, int y, char fill){
    	super(x,y,fill);
        this.length = length;
        this.vertical =  vertical;
    }
    
    public Line(int length, boolean vertical){
    	super();
        this.length = length;
        this.vertical =  vertical;
    }
    
    public void setLength(int length){
        this.length = length;
    }
    
    public void setVertical(boolean vertical){
        this.vertical = vertical;
    }
    
    public boolean getVertical(){
        return this.vertical;
    }
    
    public int getLength(){
        return this.length;
    }
    
    public String toString(){
    	String string = "";
    	int x1 =getX();
    	int y1 =getY();
    	char fill1 = getFill();
    	for(int h=0;h<=y1;h++){
    		string = string + "\n";
    	}
        for(int f = 0;f<length;f++){
            if(vertical){
            	for(int n=0;n<=x1;n++){
            	string = string + " ";}
                string = string + fill1 +"\n";
            } else string = string + fill1;
        } return string;
    }
}

