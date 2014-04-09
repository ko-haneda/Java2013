package ch01.ex01_09;

public class ex01_09 {
	static final String title = "タイトル:フィボナッチ数列の出力リスト";

	public static void main(String[] args) {
		int array[] = new int[10];

		int lo = 1;
		int hi = 1;

		System.out.println(title);
		array[0] = lo;
		for (int i = 1; i < 10; i++) {
			array[i] = hi;
			hi = lo + hi;
			lo = hi - lo;
		}
		// 出力
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " : " + array[i]);
		}
	}
}