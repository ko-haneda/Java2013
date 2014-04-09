package ch16.ex16_06;

import java.lang.reflect.*;

public class FieldExample {
	private int i = 3;
	private int j = 4;

	public String toString() {
		return "FieldExample: i=" + i + ", j=" + j;
	}

	public void zeroI() {
		this.i = 0;
	}

	public void zeroField(String fieldName) {
		try {
			Field f = this.getClass().getDeclaredField(fieldName);
			f.setInt(this, 0);
		} catch (NoSuchFieldException ex) {
		} catch (IllegalAccessException ex) {
		}
	}
}