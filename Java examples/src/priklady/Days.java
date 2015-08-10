package priklady;

public class Days {

	public static void main(String[] args){
		int i = 0;
		int l = args.length;
		while(i < l){
		try{
			int c = Integer.parseInt(args[i]);
			System.out.println(days1(c));
		} catch (NumberFormatException ex) {
			System.out.println(days(args[i]));
		} i++;
	}
	}
	
	
	
	public static String days1(int i){
		String day;
		switch(i){
			case 1: day = "pondelisko";break;
			case 2: day = "utorisko";break;
			case 3: day = "streda";break;
			case 4: day = "stvrtok";break;
			case 5: day = "piatocek";break;
			case 6: day = "soboticka";break;
			case 7: day = "nedelicka";break;
			default: day ="nekorektne cislo";
		}
		return day;
	}
	
	public static String days(String i){
		String day;
		switch(i){
			case "pondelok": day = "pondelisko";break;
			case "utorok": day = "utorisko";break;
			case "streda":day = "streda";break;
			case "stvrtok":day = "stvrtok";break;
			case "piatok":day = "piatocek";break;
			case "sobota":day = "soboticka";break;
			case "nedela":day = "nedelicka";break;
			default: day ="nekorektne cislo";
		}
		return day;
	}
	
}
