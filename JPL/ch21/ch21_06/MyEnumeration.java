package ch21.ch21_06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class MyEnumeration<E> implements Enumeration<E> {

	private Object[] objs;
	private int offset = 0;

	public MyEnumeration(Collection<?> col) {
		objs = col.toArray();
	}

	public boolean hasMoreElements() {
		return offset < objs.length;
	}

	//書き方に問題がありまくり。　EはInputStream等に限定されている。あとで
	public E nextElement() {
		if (!hasMoreElements()) {
			throw new NoSuchElementException();
		}
		try {
			return (E)new FileInputStream(objs[offset++].toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}