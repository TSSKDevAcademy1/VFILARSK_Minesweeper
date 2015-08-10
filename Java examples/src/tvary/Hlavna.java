package tvary;

public class Hlavna {

	public static void main(String[] args){
		Line ciara = new Line(5,true,1,2,'p');
		//System.out.println(ciara.toString());
		Square square = new Square(5,5,1,'p');
		//System.out.println(square.toString());
		Rectangle obdlznik = new Rectangle(15,5,5,5,'k');
		//System.out.println(obdlznik.toString());
		Shape[] shapes = new Shape[3];
		shapes[0] = ciara;
		shapes[1] = square;
		shapes[2] =  obdlznik;
		for(Shape s : shapes){
			System.out.println("Pred zmenou:"+s.getX()+" "+s.getY());
			s.move(3,4);
			System.out.println(""+s.getX()+" "+s.getY());
		}
	}
}
