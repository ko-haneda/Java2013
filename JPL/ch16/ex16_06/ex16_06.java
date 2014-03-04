package ex16_06;

import java.lang.reflect.Field;

class ex16_06 {

	public static void main(String[] args) {
		String str = "java.lang.String";
		try {
			Field []fields = Class.forName(str).getDeclaredFields();
			for(Field field : fields){
				System.out.println(field);
				System.out.println("sss" + field.getGenericType());
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
//		String str = "j";
//		FieldExample fe = new FieldExample();
//		System.out.println(fe.toString());
//		fe.zeroField(str);
//		System.out.println(fe.toString());
	}
}