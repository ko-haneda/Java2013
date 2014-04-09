package ch01.ex01_06;

public class ex01_06 {
	static final String title = "タイトル:フィボナッチ数列の出力リスト";

	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;

		System.out.println(title);
		System.out.println(lo);
		while (hi < 50) {
			System.out.println(hi);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}