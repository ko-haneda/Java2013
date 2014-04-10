package Interpret6;

import java.lang.reflect.*;

public class MyConstructor {

	//クラス名(引数str)からコンストラクタの一覧を取得
	public static Constructor<?>[] getConstructors(String str) throws SecurityException, ClassNotFoundException {
		return Class.forName(str).getDeclaredConstructors();
	}

	//指定されたコンストラクタ(引数con)を呼び出し、インスタンスを生成する。
	//コンストラクタに必要な引数（input）
	public static Object newConstructor(Constructor<?> con, String input) throws InstantiationException, IllegalAccessException, InvocationTargetException{
		String[] inputs = input.split(",");
		con.setAccessible(true);
		Type[] types = con.getGenericParameterTypes();
		if(types.length == 0){
			return con.newInstance();
		}
		if(types.length != types.length){
			System.out.println("引数の数が異なります。");
		}
		Object[] params = new Object[inputs.length];
		int i = 0;
		for (Type type : types) {
			params[i] = Interpret.createObject(type, inputs[i++]);
		}
		return con.newInstance(params);
	}

	public static String getSimpleName(Constructor<?> c){
		StringBuffer sb = new StringBuffer();
		int m = c.getModifiers();
		if(Modifier.isPublic(m))	sb.append("public ");
		if(Modifier.isProtected(m))	sb.append("protected ");
		if(Modifier.isPrivate(m))	sb.append("private ");

		if(Modifier.isStatic(m))	sb.append("static ");
		if(Modifier.isFinal(m))		sb.append("final ");
		sb.append(c.getDeclaringClass().getSimpleName());
		Class<?> []cl = c.getParameterTypes();
		sb.append("(");
		int i = 0;
		for(Class<?> cla: cl){
			if(i++ != 0)	sb.append(" ,");
			sb.append(cla.getSimpleName());
		}
		sb.append(")");
		return sb.toString();
	}
}