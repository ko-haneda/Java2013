package ch24.ch24_03;

import java.util.*;
import java.text.*;

/*
 * デフォルトが寛大となっているらしいがだいぶ厳格な気がする。
 * また寛大さをtrueからfalseに変えてみたが結果は変わらなかった。
 */
public class ex24_03 {
	
	static final String[] str_mode = {"FULL", "LONG", "MEDIUM", "SHORT"};
	
	public static void main(String[] args) {
		printDate("Friday, August 29, 1986 5:00:00 PM EDT");
		printDate("August 29, 1986 5:00:00 PM EDT");
        printDate("Aug 29, 1986 5:00:00 PM");
        printDate("8/29/86 5:00 PM");
        
        printDate("Friday, August 29, 1986 5:00 PM");
	}
	
	public static void printDate(String str_date){
		int[] mode = {	DateFormat.FULL,	DateFormat.LONG,
				   		DateFormat.MEDIUM, 	DateFormat.SHORT }; 
		Locale locale = new Locale("en", "US");
		for(int d : mode){
			for(int t : mode){
//				デフォルトのロケールの設定
//				DateFormat fmt = DateFormat.getDateTimeInstance(d, t);
				DateFormat fmt = DateFormat.getDateTimeInstance(d, t, locale);
//				fmt.setLenient(false);
				Date date = parse(fmt, str_date);
				if(date != null){
					System.out.printf("%6s - %6s : \t", str_mode[d], str_mode[t]);
					System.out.println(fmt.format(date));
				}
			}
		}
		System.out.println("*************************************************************");
	}
	
//	nullを返す仕様に変更
	public static Date parse(DateFormat fmt, String str_date) {
		try {
			return fmt.parse(str_date);
		} catch (ParseException e) {
//			System.out.println("この文字列は解析できませんでした。");
			return null;
		}
	}
}
