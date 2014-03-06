package Interpret;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

public class MyConstructor {

	public static Constructor<?>[] getConstructors(String str)
			throws SecurityException, ClassNotFoundException {
		return Class.forName(str).getDeclaredConstructors();
	}

	public static Object newConstructor(Constructor<?> con, String input)
			throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		String[] inputs = input.split(",");
		con.setAccessible(true);
		Type[] types = con.getGenericParameterTypes();
		Object[] params = new Object[inputs.length];
		int i = 0;
		for (Type type : types) {
			params[i] = Interpret.createObject(type, inputs[i++]);
		}
		return con.newInstance(params);
	}
}
