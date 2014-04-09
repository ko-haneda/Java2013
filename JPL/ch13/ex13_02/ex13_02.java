package ch13.ex13_02;

public class ex13_02 {

	public static void main(String[] args) {
		String str = "AABABCABCDABCDEABCDEF"; //A AB ABC ABCD ABCDE ABCDEF
		
		System.out.println("ABの出現回数は"   + count(str, "AB") + "回です。");
		System.out.println("ABCの出現回数は"  + count(str, "ABC") + "回です。");
		System.out.println("ABCDの出現回数は" + count(str, "ABCD") + "回です。");

	}
	
	static int count(String str, String search){
		int count = 0;
		int pos = 0;
		while(true){
			pos = str.indexOf(search, pos);
			if(pos == -1)	break;
			pos += search.length();
			count++;
		}
		return count;
	}
}
