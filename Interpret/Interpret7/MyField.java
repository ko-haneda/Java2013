package Interpret;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;

public class MyField {

	//クラス名からフィールド名取得。　このメソッドは使用価値ない。
	public static Field[] getFields(String str) throws SecurityException, ClassNotFoundException {
		return Class.forName(str).getDeclaredFields();
	}

	//Objectのフィールド名取得（privateのフィールドも取得）
	public static Field[] getFields(Object obj) throws SecurityException, ClassNotFoundException {
		return obj.getClass().getDeclaredFields();
	}

	//指定したフィールドの値を取得
	public static String getField(Field field, Object obj) throws IllegalArgumentException, IllegalAccessException{
		if(field == null)	return "";
		field.setAccessible(true);
		return ((Object)field.get(obj)).toString();
	}

	//指定したフィールドの値を設定
	public static void setField(Field field, Object obj, String input) throws IllegalArgumentException, IllegalAccessException {
		field.setAccessible(true);
		Object newObject = Interpret.createObject(field.getGenericType(), input);
		field.set(obj, newObject);
	}

	public static String getSimpleName(Field field){
		StringBuffer sb = new StringBuffer();
		int m = field.getModifiers();
		if(Modifier.isPublic(m))	sb.append("public ");
		if(Modifier.isProtected(m))	sb.append("protected ");
		if(Modifier.isPrivate(m))	sb.append("private ");

		if(Modifier.isStatic(m))	sb.append("static ");
		if(Modifier.isFinal(m))		sb.append("final ");
		sb.append(field.getType().getSimpleName() + " ");
		sb.append(field.getName());
		return sb.toString();
	}
	
	static class FieldComparator implements Comparator<Field> {
		public int compare(Field f1, Field f2) {
			return f1.getName().toLowerCase().compareTo(f2.getName().toLowerCase());
		}
	}
}