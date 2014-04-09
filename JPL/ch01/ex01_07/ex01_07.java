package ch01.ex01_07;

/*
 * ImprovedFibonacciのループを逆順に書き直す。
 * iの値のみを逆に表示させ、フィボナッチ数列は通常通りとする。
 */
public class ex01_07 {
	static final int MAX_INDEX = 9;

	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		String mark;

		System.out.println("9:" + lo);
		for (int i = MAX_INDEX - 1; i >= 1; i--) {
			if (hi % 2 == 0) {
				mark = " *";
			} else {
				mark = " ";
			}
			System.out.println(i + ":" + hi + mark);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}