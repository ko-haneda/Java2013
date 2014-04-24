package ch22.ch22_01;

import java.util.*;

public class ch22_01 {

	public static void main(String[] args){

		double[] data = new double[100];
		for(int i = 0; i < data.length; i++){
			data[i] = Math.random();
		}
		format(data, 4);
//		format(data, 33);
//		format(data, 100);
	}

	public static void format(double[] data, int column) {

		int length = 80;	//一行の最大の文字数
		int width = 15;		//一列の最大の文字数
		int max = length / width; 
		String format;
		
		if(column > max)	System.out.println("指定した列が多すぎます。　自動で折り返しを行います。");
		Formatter formatter = new Formatter(System.out);
		int ct = 0;
		for(int i = 0; i < data.length; i++){
			format = "%01$"+ width + ".3e";
			if(i % column == 0){
				ct = 0;
				System.out.println();
			}
			if(ct != 0 && ct % max == 0){
				format = "%01$"+ (width - 1) + ".3e";
				System.out.print("\n→");
			}
			ct++;
			formatter.format(format, data[i]);
		}
		formatter.close();
	}
}
