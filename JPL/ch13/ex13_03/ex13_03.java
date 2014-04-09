package ch13.ex13_03;

public class ex13_03 {

	public static void main(String[] args) {
		String str = "ABCDEFAGHIJKLMNOEAPQERSTU";
		String [] array_str  = delimitedString(str, 'A', 'E');
		System.out.println(array_str[0]);
		System.out.println(array_str[1]);
		System.out.println(array_str[2]);
		
	}
	
	private static String[] delimitedString(String from, char start, char end){
		int startPos = 0;
		int endPos = 0;
		String str = "";
		while(true){
			startPos = from.indexOf(start, startPos);
			endPos = from.indexOf(end, startPos);
			if(startPos == -1)		break;	
			else if(endPos == -1)	str += "," + from.substring(startPos);
			else					str += "," + from.substring(startPos, endPos + 1);
			startPos++;
		}
		return str.substring(1).split(",");
	}
}
