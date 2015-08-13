package lambda;

@FunctionalInterface
interface Justifier {
	String justify(String text, int width);
}

public class LambdaScope {
	public static void main(String[] args) {
		String title = "Hamlet";

		//uncommented code does not compile - sb already initialized
		//comment line 16 - not initialized
		//StringBuilder sb;
		Justifier justifier = (text, width) -> {
			StringBuilder sb = new StringBuilder();
			int count = 0;
			//externally defined local variable can not be changed in the body - should be final
			//title = "";
			for (int i = 0; i < text.length(); i++) {
				char ch = text.charAt(i);
				if (++count == width) {
					sb.append("\r\n");
					count = 0;
				}
				sb.append(ch);
			}
			return sb.toString();
		};

		String text = "This above all: to thine own self be true,"
				+ "And it must follow, as the night the day,"
				+ "Thou canst not then be false to any man.";
		System.out.println(justify(justifier, text, 10));
	}

	static String justify(Justifier justifier, String text, int width) {
		return justifier.justify(text, width);
	}
}