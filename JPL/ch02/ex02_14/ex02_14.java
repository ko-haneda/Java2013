package ch02.ex02_14;

class Vehicle5 {
	private int id;
	private int speed;
	private double angle;
	private String name;
	private static int max_id = 0;

	public Vehicle5() {
		this.id = 0;
		this.speed = 0;
		this.angle = 0.0;
		this.name = "";
	}

	public Vehicle5(int id, int speed, double angle, String name) {
		this();
		this.id = id;
		this.speed = speed;
		this.angle = angle;
		this.name = name;
		if (max_id < this.id)
			max_id = this.id;
	}

	public static int max_id() {
		return Vehicle5.max_id;
	}

	public static void main(String[] args) {
		Vehicle5 car = new Vehicle5(3, 100, 0.0, "私の車");
		Vehicle5 train = new Vehicle5(2, 200, 0.0, "あなたの電車");

		System.out.println(car);
		System.out.println(train);
		System.out.println(Vehicle5.max_id());
	}

	public String toString() {
		String str = "";

		str += (this.id + ", ");
		str += (this.speed + ", ");
		str += (this.angle + ", ");
		str += (this.name);

		return str;
	}
	/*
	 * public void print_Vehicle(){ System.out.print(this.id + ", ");
	 * System.out.print(this.speed + ", "); System.out.print(this.angle + ", ");
	 * System.out.println(this.name); }
	 */
}

class LinkedList4 {
	private Object value;
	private LinkedList4 next;

	public LinkedList4() {
		this.setValue(null);
		this.setNext(null);
	}

	public LinkedList4(Object value) {
		this.setValue(value);
		this.setNext(null);
	}

	/*
	  public static void main(String[] args) {
	  
	  }
	 */
	public String toString() {
		String str = "";

		str += this.getValue();

		return str;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public LinkedList4 getNext() {
		return next;
	}

	public void setNext(LinkedList4 next) {
		this.next = next;
	}
}

public class ex02_14 {
	public static void main(String[] args) {
		// LickedListのフィールドに対するアクセッサーはすべて変更を許して良い。
		// そのかわり、nextを操作するときは正しく、つなぎなおすことが大切。
		// エラーの要因になりかねない。

		Vehicle5 car = new Vehicle5(2, 100, 0.0, "わたし車");
		Vehicle5 train = new Vehicle5(6, 200, 0.0, "あなたの電車");
		Vehicle5 bike = new Vehicle5(3, 50, 0.0, "かれのバイク");

		LinkedList4 list;
		LinkedList4 list1 = new LinkedList4(car);
		LinkedList4 list2 = new LinkedList4(train);
		LinkedList4 list3 = new LinkedList4(bike);

		list1.setNext(list2);
		list2.setNext(list3);
		list3.setNext(null);

		list = list1;
		while (list != null) {
			System.out.println(list);
			list = list.getNext();
		}
	}
}
