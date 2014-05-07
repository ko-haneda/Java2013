package ch13.ex13_04;

public class ex13_04 {

	public static void main(String[] args) {
		String input = "Byte -127\nShort 14444\nInteger 10333330\nLong 13333333333333\n"
						+ "Float 0.352\nDouble 3.14\nCharacter A\nBoolean true";
		ObjectTransform ot = new ObjectTransform(input);
		System.out.println(ot);
	}
}
