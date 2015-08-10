
public class PrintRectangle {
	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		
		for(int i=0; i<y;i++){
			for(int n = 0; n < x;n++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
	}
}
