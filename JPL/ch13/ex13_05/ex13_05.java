package ch13.ex13_05;
import java.text.DecimalFormat;
public class ex13_05 {

	public static void main(String[] args) {
		String str = "1002049";
		System.out.println(sepa(str));
	}
	public static String sepa(String str){
		int num = Integer.parseInt(str);
		DecimalFormat formatter = new DecimalFormat("#,###");
		return formatter.format(num);
	}
	

}
