package ch24.ch24_02;

import java.util.*;

public class ex24_02 {
	static final String[] str_locale = {"日本", "韓国", "中国","英国", "台湾", "米国"};
	static Locale[] locale = {	Locale.JAPAN,	Locale.KOREA,	Locale.CHINA,
								Locale.UK,		Locale.TAIWAN,	Locale.US};
	static String[] currency = { "JPY", "KRW", "CNY", "EUR", "TWD", "USD" };

	public static void main(String[] args) {
		for(String s: str_locale)	System.out.print("\t " + s);
		System.out.println("　←通貨");
		int i = 0;
		for (Locale l : locale) {
			System.out.print(str_locale[i++]);
			for (String c : currency) {
				System.out.printf("\t %s", Currency.getInstance(c).getSymbol(l));
			}
			System.out.printf("%n");
		}
		System.out.println(" ↑国名");
	}
	
	@SuppressWarnings("unused")
	private static final void test(){
		for(Locale l : locale){
			System.out.println(Currency.getInstance(l).getCurrencyCode());
		}
	}
	
	
}
