package Interpret;

import java.lang.reflect.Field;

public class MyField {

	public Field[] getFields(String str) throws SecurityException,
			ClassNotFoundException {
		return Class.forName(str).getDeclaredFields();
	}

	public void setField(Field field, Object obj, String fieldName, String input)
			throws IllegalArgumentException, IllegalAccessException {
		Object newObject = Interpret
				.createObject(field.getGenericType(), input);
		field.setAccessible(true);
		field.set(obj.getClass(), newObject);
	}
}
