package ch01.ex01_12;

class fibonacci_info1 {
	int value;
	boolean even;
	static String str = "";
	static int count = 0;

	public void set_value(int value) {
		this.value = value;
		if (this.value % 2 == 0)
			this.even = true;
		else
			this.even = false;
		str += count;
		str += " : ";
		str += this.value;
		str += this.even ? " *" : "";
		str += "\n";
		count++;
	}
}

public class ex01_12 {
	static final String title = "タイトル:フィボナッチ数列の出力リスト";

	public static void main(String[] args) {
		fibonacci_info1 array[] = new fibonacci_info1[10];
		for (int i = 0; i < 10; i++)
			array[i] = new fibonacci_info1();

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
		System.out.println(fibonacci_info1.str);
	}
}