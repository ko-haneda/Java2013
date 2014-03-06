package Interpret;

import java.lang.reflect.Type;

public class Interpret {
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
	}

	// 基本データ型のみ
	public static Object createObject(Type type, String value) {
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
