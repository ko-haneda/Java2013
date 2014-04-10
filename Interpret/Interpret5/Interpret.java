package Interpret;

import java.lang.reflect.Type;

public class Interpret {	
	public static void main(String[] args) {
		new InterpretFrame();
	}

	// 基本データ型、参照型、配列
	public static Object createObject(Type type, String value) {
		if (value.equals("null")) {
			System.out.println("値がNULLです");
			return null;
		}
		Object obj = sub_createObject(type, value);
		//直接入力可能なもの（String＋primitive型）
		if(obj != null)		return obj;
		//生成済みインスタンスの場合
		else{
			Object instance = InterpretFrame.objs.get(value);
			if(instance == null){
				System.out.println("そのようなインスタンスは存在しません");
				return null;
			}
			if(type == instance.getClass()){
				return instance;
			}
			System.out.println("nullです");
			return null;
		}		
	}

	private static Object sub_createObject(Type type, String value){
		//直接入力可能なもの
		if (type.equals(boolean.class)) 	return Boolean.valueOf(value);
		else if (type.equals(byte.class))	return Byte.valueOf(value);
		else if (type.equals(char.class))	return value.charAt(0);
		else if (type.equals(short.class))	return Short.valueOf(value);
		else if (type.equals(int.class)) 	return Integer.valueOf(value);
		else if (type.equals(long.class)) 	return Long.valueOf(value);
		else if (type.equals(double.class))	return Double.valueOf(value);
		else if (type.equals(float.class)) 	return Float.valueOf(value);
		else if (type.equals(String.class))	return value;
		else								return null;
	}
}