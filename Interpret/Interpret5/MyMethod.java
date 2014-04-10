package Interpret;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class MyMethod {

	public static Method[] getMethods(String str) throws SecurityException, ClassNotFoundException {
		return Class.forName(str).getMethods();
	}

	public static Method[] getMethods(Object obj) throws SecurityException, ClassNotFoundException {
		return obj.getClass().getMethods();
	}

	public static Object executeMethod(Method method, Object obj, String input) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		method.setAccessible(true);
		Type[] types = method.getGenericParameterTypes();
		if(types.length == 0){
			return method.invoke(obj, null);
		}
		String[] inputs = input.split(",");
		if(types.length == inputs.length){
			System.out.println("引数の数が異なります。");
		}
		Object[] params = new Object[inputs.length];
		int i = 0;
		for (Type type : types) {
			params[i] = Interpret.createObject(type, inputs[i++]);
		}
		return method.invoke(obj, params);
	}

	public static String getSimpleName(Method me){
		StringBuffer sb = new StringBuffer();
		int m = me.getModifiers();
		if(Modifier.isPublic(m))	sb.append("public ");
		if(Modifier.isProtected(m))	sb.append("protected ");
		if(Modifier.isPrivate(m))	sb.append("private ");

		if(Modifier.isStatic(m))	sb.append("static ");
		if(Modifier.isFinal(m))		sb.append("final ");
		sb.append(me.getName());
		Class<?> []cl = me.getParameterTypes();
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