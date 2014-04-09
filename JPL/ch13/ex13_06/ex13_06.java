package ch13.ex13_06;

import java.text.DecimalFormat;

public class ex13_06 {
	public static void main(String[] args) {
		String str = "1002049";
		System.out.println(sepa(str,'A', 3));
		System.out.println(sepa(str,'B', 2));
	}
	
	public static String sepa(String str, char ch, int count){
		int num = Integer.parseInt(str);
		String form = "#,";
		for(int i = 0; i < count; i++)	form += "#";
		System.out.println(form);
		DecimalFormat formatter = new DecimalFormat(form);
		return formatter.format(num).replaceAll(",", String.valueOf(ch));
	}
}
