package ch02.ex02_12;

public class ex02_12 {
	public static void main(String[] args) {
		// 必要性は感じられない。
		// LinkedListクラスにおいて、毎回nextを設定する手間があり、
		// Vehicleクラスを可変長の引数で渡し、 ex)function（vehicle1, vehicle2, vehicle3）
		// 引数の順番でnextを設定すると楽になる 　　vehicle1.next = vehicle2; vehicle2.next = (省略)
		// かもしれないが、
		// 可変長の引数で渡すよりかは、
		// LinkedListのインスタンスを生成する際に
		// 一つ前のインスタンスのnextを自分自身に設定するよう、
		// コンストラクタに記述する方がよいように感じる
		// （ただし、インスタンスの生成順にnextをつなげたくない場合はこのやり方ではできないが・・・）

		// まとめ
		// 可変長引数を使うこともできるが、
		// 使わないとプログラムのコードが汚くなるようなことはないと思うので、
		// 可変長引数を使う必要はないと思う。
	}
}
