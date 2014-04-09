package ch13.ex13_01;

public class ex13_01 {
	public static void main(String[] args) {
		String str = "ABBCCCDDDDEEEEE";
		
		System.out.println("Aの出現回数は" + count(str, 'A') + "回です。");
		System.out.println("Bの出現回数は" + count(str, 'B') + "回です。");
		System.out.println("Cの出現回数は" + count(str, 'C') + "回です。");
		System.out.println("Dの出現回数は" + count(str, 'D') + "回です。");

	}
	
	static int count(String str, char ch){
		int count = 0;
		
		for(int i = 0; i < str.length(); i++){
			if(ch == str.charAt(i))	count++;
		}
		return count;
	}
}
