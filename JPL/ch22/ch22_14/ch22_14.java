package ch22.ch22_14;

import java.util.StringTokenizer;


public class ch22_14 {

	public static void main(String[] args) {
		String str = "1.3 3.4 5.2 -8.1 5.0 4.7 0.8 2.9 9.1 -12.0";
		System.out.printf("%.1f", getSum(str));	//第二小数点以下切り捨て（誤差）
	}
	
	//\t\n\r\fも区切り文字とした。
	//誤差をなくすようにするならば、BigDecimalを使用すること。
	public static double getSum(String str){
		double sum = 0;
		StringTokenizer st = new StringTokenizer(str);
		while(st.hasMoreTokens()){
			sum += Double.parseDouble(st.nextToken());
		}
		return sum;
	}
}
