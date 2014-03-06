package Interpret;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class MyMethod {

	public static Method[] getMethods(String str) throws SecurityException,
			ClassNotFoundException {
		return Class.forName(str).getMethods();
	}

	public static Method[] getMethods(Object obj) throws SecurityException,
			ClassNotFoundException {
		return obj.getClass().getMethods();
	}

	public static Object executeMethod(Method method, Object obj, String input)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		method.setAccessible(true);
		Type[] types = method.getGenericParameterTypes();
		String[] inputs = input.split(",");
		Object[] params = new Object[inputs.length];
		int i = 0;
		for (Type type : types) {
			params[i] = Interpret.createObject(type, inputs[i++]);
		}
		return method.invoke(obj, params);
	}
}
