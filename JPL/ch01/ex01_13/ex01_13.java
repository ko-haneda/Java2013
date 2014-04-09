package ch01.ex01_13;

class fibonacci_info2 {
	int value;
	boolean even;

	public void set_value(int value) {
		this.value = value;
		if (this.value % 2 == 0)
			this.even = true;
		else
			this.even = false;
	}
}

public class ex01_13 {
	static final String title = "タイトル:フィボナッチ数列の出力リスト";

	public static void main(String[] args) {
		fibonacci_info2 array[] = new fibonacci_info2[10];
		for (int i = 0; i < 10; i++)
			array[i] = new fibonacci_info2();

		int lo = 1;
		int hi = 1;

		System.out.println(title);
		array[0].set_value(lo);
		for (int i = 1; i < 10; i++) {
			array[i].set_value(hi);
			hi = lo + hi;
			lo = hi - lo;
		}

		// 出力
		for (int i = 0; i < 10; i++) {
			System.out.printf("%d : %d%s\n", i, array[i].value,
					array[i].even ? " *" : "");
		}
	}
}