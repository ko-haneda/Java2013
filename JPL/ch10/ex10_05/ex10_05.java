package ch10.ex10_05;

public class ex10_05 {
	public static void main(String[] args) {
		char ch1 = 'z';
		char ch2 = 'A';
		
		System.out.printf("%cと%cの間を列挙\n", ch1, ch2);
		for(ch1 += (ch1 < ch2) ? 1: -1 ;ch1 != ch2; ch1 += (ch1 < ch2) ? 1: -1){
			System.out.printf("%c", ch1);
		}
	}
}