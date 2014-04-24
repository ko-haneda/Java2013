package Interpret;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Comparator;

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
		String[] inputs = input.split(",");
		System.out.println("メソッドのパラメタ数:" + types.length + "\t 入力した数:" + inputs.length);
		if(types.length == 0){
			return method.invoke(obj);
		}
		if(types.length != inputs.length){
			System.out.println("引数の数が異なります。");
			return null;
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
		sb.append(me.getReturnType().getSimpleName() + " ");
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
	
	static class MethodComparator implements Comparator<Method> {
		public int compare(Method m1, Method m2) {
			int comp1 = m1.getName().toLowerCase().compareTo(m2.getName().toLowerCase());
			if (comp1 != 0) 	return comp1;
			int comp2 = m1.getParameterTypes().length - m2.getParameterTypes().length;
			if(comp2 != 0)	return comp2;
			StringBuffer sb1 = new StringBuffer();
			StringBuffer sb2 = new StringBuffer();
			for(Class<?> c: m1.getParameterTypes())	sb1.append(c.getSimpleName().toLowerCase());
			for(Class<?> c: m2.getParameterTypes())	sb2.append(c.getSimpleName().toLowerCase());
			return sb1.toString().compareTo(sb2.toString());
		}
	}
}