package ch22.ch22_12;

import java.util.Iterator;

public interface Attributed<T> {
	void add(Attr<T> newAttr);

	Attr<T> find(String attrName);

	Attr<T> remove(String attrName);

	Iterator<Attr<T>> attrs();
}