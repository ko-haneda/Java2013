package ch01.ex01_15;

interface Lookup {
	Object find(String name);

	void add(String name, Object value);

	void remove();
}

class SimpleLookup implements Lookup {
	private String[] names;
	private Object[] values;
	int count;

	public void init() {
		count = 0;
		names = new String[10];
		values = new Object[10];
	}

	public Object find(String name) {
		for (int i = 0; i < count; i++) {
			if (names[i].equals(name)) {
				return values[i];
			}
		}
		return null;
	}

	public void add(String name, Object value) {
		names[count] = name;
		values[count] = value;
		count++;
	}

	public void remove() {
		count--;
	}

	public void print() {
		for (int i = 0; i < count; i++) {
			System.out.print("name = " + this.names[i] + ", ");
			System.out.println("value = " + this.values[i]);
		}
		System.out.println();
	}
}

public class ex01_15 {

	public static void main(String[] args) {
		SimpleLookup samp = new SimpleLookup();
		samp.init();
		samp.add("test1", 1);
		samp.add("test2", 2);
		samp.add("test3", 3);
		System.out.println(samp.find("test2"));
		System.out.println();
		samp.print();
		samp.remove();
		samp.print();

	}
}