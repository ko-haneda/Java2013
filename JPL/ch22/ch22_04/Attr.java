package ch22.ch22_04;

//ch11_03から引用

public class Attr<V> {
	private final String name;
	private V value;

	public Attr() {
		this.name = null;
		this.value = null;
	}

	public Attr(String name) {
		this.name = name;
		this.value = null;
	}

	public Attr(String name, V value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return this.name;
	}

	public V getValue() {
		return this.value;
	}

	public V setValue(V newValue) {
		V oldVal = this.value;
		this.value = newValue;
		return oldVal;
	}

	public String toString() {
		return name + "='" + this.value.toString() + "'";
	}

}