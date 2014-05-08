package ch14.ex14_07;

public class ex14_07 {

	/* trueだろうとfalseだろうと結果が毎回変わる。
	 * trueにした方がばらつきが多くなるような気がする。*/
	public static void main(String[] args) {
		String []str = new String[4];
		str[0] = "true";
		str[1] = "2";
		str[2] = "test1";
		str[3] = "test2";
//		str[4] = "test3";
		Babble.main(str);
	}
}