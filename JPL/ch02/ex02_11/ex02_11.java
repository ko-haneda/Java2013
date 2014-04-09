package ch02.ex02_11;

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

class LinkedList3 {
	private Object value;
	private LinkedList3 next;

	public LinkedList3() {
		this.value = null;
		this.next = null;
	}

	public LinkedList3(Object value) {
		this.value = value;
		this.next = null;
	}

	public static void main(String[] args) {
		Vehicle5 car = new Vehicle5(2, 100, 0.0, "わたし車");
		Vehicle5 train = new Vehicle5(6, 200, 0.0, "あなたの電車");
		Vehicle5 bike = new Vehicle5(3, 50, 0.0, "かれのバイク");

		LinkedList3 list;
		LinkedList3 list1 = new LinkedList3(car);
		LinkedList3 list2 = new LinkedList3(train);
		LinkedList3 list3 = new LinkedList3(bike);

		list1.next = list2;
		list2.next = list3;
		list3.next = null;

		list = list1;
		while (list != null) {
			System.out.println(list);
			list = list.next;
		}
	}

	public String toString() {
		String str = "";

		str += this.value;

		return str;
	}
}

public class ex02_11 {
	public static void main(String[] args) {
		LinkedList3.main(null);
	}
}
