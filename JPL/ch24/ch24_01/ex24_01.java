package ch24.ch24_01;

import java.util.Locale;

/*
 * ResourceBundleのサブクラスを作成し・・・と問題に書いてあるが、
 * そのサブクラス内でどのような処理を記述すべきかわからなかったため、
 *　サブクラスは作成していない。
 * 
 * この問題ではListResourceBundleと.propertiesファイルを追加し、
 * 対応できるロケールをいくつか増やした。
 */
public class ex24_01 {
	public static void main(String[] args) {
		GlobalHello.printHello(true, new Locale("en", "au"));
		GlobalHello.printHello(false, new Locale("en", "au"));
		System.out.println();
		GlobalHello.printHello(true, Locale.US);
		GlobalHello.printHello(false, Locale.US);
		System.out.println();
		GlobalHello.printHello(true, Locale.FRANCE);
		GlobalHello.printHello(false, Locale.FRANCE);
		System.out.println();
		GlobalHello.printHello(true, new Locale("ja", "jp"));
		GlobalHello.printHello(false, new Locale("ja", "jp"));
		System.out.println();
		GlobalHello.printHello(true, new Locale("ko", "KR"));
		GlobalHello.printHello(false, new Locale("ko", "KR"));
	}
	
	@SuppressWarnings("unused")
	private static void test(){
		System.out.println(Locale.FRANCE.getLanguage());
		System.out.println(Locale.FRANCE.getCountry());
		System.out.println(Locale.KOREA.getLanguage());
		System.out.println(Locale.KOREA.getCountry());
	}
}
