package ex16_04;

import java.lang.annotation.Annotation;

public class ex16_4 {

	//できませんでした。　表示されない。
	public static void main(String[] args) {
		print("ex16_04.UseSample");
	}

	public static void print(String str) {
		try {
			System.out.println(str);
			Class<?> c = Class.forName(str);
			Annotation[] annotations = c.getAnnotations();
			for (Annotation annotation : annotations){
				System.out.println(annotation);
				System.out.println("test");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}