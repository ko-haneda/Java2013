package ch16.ex16_05;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class ClassContents {
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			System.out.println(c);
			System.out.println("フィールド一覧");
			printMembers(c.getFields());
			System.out.println("コンストラクタ一覧");
			printMembers(c.getConstructors());
			System.out.println("メソッド一覧");
			printMembers(c.getMethods());
			System.out.println("アノテーション一覧");
			printAnnotations(c.getAnnotations());
		} catch (ClassNotFoundException e) {
			System.out.println("unknown class: " + args[0]);
		}
	}

	public static void printMembers(Member[] mems) {
		for (Member m : mems) {
			if (m.getDeclaringClass() == Object.class)
				continue;
			String decl = m.toString();
			System.out.print("  ");
			decl = strip(decl, "ch16_03.");
			decl = strip(decl, "java.lang.");
			decl = strip(decl, "java.util.");
			System.out.println(decl);
			
		}
	}
	
	public static void printAnnotations(Annotation[] annos) {
		for (Annotation a : annos) {
			System.out.println(a);
		}
	}

	private static String strip(String str1, String str2) {
		return str1.replace(str2, "");
	}
}
