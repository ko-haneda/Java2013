package ch11.ex11_02;

public class ex11_02 {
	public static void main(String[] args) {
		Attr<String> color = new Attr<String>("RED", "赤");
		Attr<Integer> weight = new Attr<Integer>("体重", 65);
		
		System.out.println(color);
		System.out.println(weight);
	}
}
