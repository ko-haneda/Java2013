package ch22.ch22_04;

import java.util.*;

public class AttributedImpl<V> extends Observable implements Attributed<V> {
	LinkedList<Attr<V>> list = new LinkedList<Attr<V>>();

	public void add(Attr<V> newAttr) {
		list.add(newAttr);
		setChanged();
		notifyObservers("Add : " + newAttr.getValue());
	}

	public Attr<V> find(String attrName) {
		for (Attr<V> attr : list) {
			if (attr.getName().equals(attrName)) {
				return attr;
			}
		}
		return null;
	}

	public Attr<V> remove(String attrName) {
		Attr<V> attr = find(attrName);

		if (attr == null)
			return null;
		list.remove(attr);
		setChanged();
		notifyObservers("Remove : " + attr.getValue());
		return attr;
	}

	public Iterator<Attr<V>> attrs() {
		return list.iterator();
	}

}
