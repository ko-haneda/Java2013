package ch09.ex09_04;

public class ex09_04 {
	public static void main(String[] args) {
/**					問題					**/
//		①　3 << 2L -1;
//		②　(3L << 2) - 1;
//		③　10 < 12 == 6 > 17;
//		④　10 << 12 == 6 >> 17;
//		⑤　13.5e-1 % Float.POSITIVE_INFINITY;
//		⑥　Float.POSITIVE_INFINITY + Double.NEGATIVE_INFINITY;
//		⑦　Double.POSITIVE_INFINITY - Float.NEGATIVE_INFINITY;
//		⑧　0.0 / -0.0 == -0.0 / 0.0;
//		⑨　Integer.MAX_VALUE + Integer.MIN_VALUE;
//		⑩　Long.MAX_VALUE + 5;
//		⑪　(short) 5 * (byte)10;

/**					予想					**/
//		①　int:6
//		②　long:11
//		③　boolean:false
//		④　boolean:flase
//		⑤　double:1.35
//		⑥　double:NaN
//		⑦　double:Infinity
//		⑧　boolean:false
//		⑨　int:-1
//		⑩　long:-9223372036854775804
//		⑪　short:50

		
/**					答え					**/
//		①　int:6
//		②　long:11
//		③　boolean:false
//		④　boolean:flase
//		⑤　double:1.35
//		⑥　double:NaN
//		⑦　double:Infinity
//		⑧　boolean:false
//		⑨　int:-1
//		⑩　long:-9223372036854775804
//		⑪　int:50

//⑪問目の型だけ誤り？？

		System.out.println(3 << 2L -1); 
		System.out.println((3L << 2) - 1);
		System.out.println(10 < 12 == 6 > 17);
		System.out.println(10 << 12 == 6 >> 17);
		System.out.println(13.5e-1 % Float.POSITIVE_INFINITY);
		System.out.println(Float.POSITIVE_INFINITY + Double.NEGATIVE_INFINITY);
		System.out.println(Double.POSITIVE_INFINITY - Float.NEGATIVE_INFINITY);
		System.out.println(0.0 / -0.0 == -0.0 / 0.0);
		System.out.println(Integer.MAX_VALUE + Integer.MIN_VALUE);
		System.out.println(Long.MAX_VALUE + 5);
		System.out.println((short) 5 * (byte)10);
	}
}