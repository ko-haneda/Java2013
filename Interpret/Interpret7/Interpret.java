package Interpret;

import java.lang.reflect.Type;

public class Interpret {
	public static void main(String[] args) {
		InterpretFrame infr = new InterpretFrame();
		infr.setVisible(true);
		System.out.println(int[].class.toString());
	}

	public static void main() {
		new InterpretFrame();
	}

	// 基本データ型、参照型
	public static Object createObject(Type type, String value) {
		if (value.equals("null"))
			return null;
		Object obj = sub_createObject(type, value);
		if (obj != null)
			return obj;
		Object instance = InterpretFrame.objs.get(value);
		if (instance == null)
			return null;
		return instance;
	}

	// 直接入力可能なもの（String＋primitive型）
	private static Object sub_createObject(Type type, String value) {
		System.out.println(type);
		if (type.equals(boolean.class))
			return Boolean.valueOf(value);
		else if (type.equals(byte.class))
			return Byte.valueOf(value);
		else if (type.equals(char.class))
			return value.charAt(0);
		else if (type.equals(short.class))
			return Short.valueOf(value);
		else if (type.equals(int.class))
			return Integer.valueOf(value);
		else if (type.equals(long.class))
			return Long.valueOf(value);
		else if (type.equals(double.class))
			return Double.valueOf(value);
		else if (type.equals(float.class))
			return Float.valueOf(value);
		else if (type.equals(String.class))
			return value;
		else
			return null;
	}

	public static Object createObjectArr(Type type, String value) {
		if (value.equals("null"))	return null;
		Object instance = InterpretFrame.objs.get(value);
		if (instance != null)		return instance;
		Object obj = sub_createObjectArr(type, value);
		if (obj != null)			return obj;
		return null;
	}

	private static Object sub_createObjectArr(Type type, String value) {
		if (value.equals("null")) {
			return null;
		}
		if (type.equals(Boolean.class) || type.equals(boolean.class)
				|| type.equals(Boolean[].class) || type.equals(boolean[].class)
				|| type.equals(Boolean[][].class)
				|| type.equals(boolean[][].class)) {
			return Boolean.valueOf(value);
		} else if (type.equals(Byte.class) || type.equals(byte.class)
				|| type.equals(Byte[].class) || type.equals(byte[].class)
				|| type.equals(Byte[][].class) || type.equals(byte[][].class)) {
			return Byte.valueOf(value);
		} else if (type.equals(Short.class) || type.equals(short.class)
				|| type.equals(Short[].class) || type.equals(short[].class)
				|| type.equals(Short[][].class) || type.equals(short[][].class)) {
			return Short.valueOf(value);
		} else if (type.equals(Integer.class) || type.equals(int.class)
				|| type.equals(Integer[].class) || type.equals(int[].class)
				|| type.equals(Integer[][].class) || type.equals(int[][].class)) {
			return Integer.valueOf(value);
		} else if (type.equals(Long.class) || type.equals(long.class)
				|| type.equals(Long[].class) || type.equals(long[].class)
				|| type.equals(Long[][].class) || type.equals(long[][].class)) {
			return Long.valueOf(value);
		} else if (type.equals(Double.class) || type.equals(double.class)
				|| type.equals(Double[].class) || type.equals(double[].class)
				|| type.equals(Double[][].class) || type.equals(double[].class)) {
			return Double.valueOf(value);
		} else if (type.equals(Float.class) || type.equals(float.class)
				|| type.equals(Float[].class) || type.equals(float[].class)
				|| type.equals(Float[][].class) || type.equals(float[][].class)) {
			return Float.valueOf(value);
		} else if (type.equals(String.class) || type.equals(String[].class)
				|| type.equals(String[][].class)) {
			return value;
		}
		return null;
	}
}
