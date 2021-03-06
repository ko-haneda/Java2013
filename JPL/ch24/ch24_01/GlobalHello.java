package ch24.ch24_01;

import java.util.Locale;
import java.util.ResourceBundle;

public class GlobalHello {
	private static final String baseName = "ch24.ch24_01.GlobalRes";
	
	public static void printHello(boolean flag, Locale locale) {
		ResourceBundle res = ResourceBundle.getBundle(baseName, locale);
		System.out.println(res.getString(flag ? GlobalRes.HELLO : GlobalRes.GOODBYE));
	}	
}
