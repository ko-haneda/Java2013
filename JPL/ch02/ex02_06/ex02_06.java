package ch02.ex02_06;

class Vehicle2 {
	private int speed;
	private double angle;
	private String name;

	public static void main(String[] args) {
		Vehicle2 car = new Vehicle2();
		Vehicle2 train = new Vehicle2();

		car.set_Vehicle(100, 0.0, "わたしの車");
		train.set_Vehicle(200, 0.0, "あなたの電車");
		car.print_Vehicle();
		train.print_Vehicle();
	}

	public void set_Vehicle(int speed, double angle, String name) {
		this.speed = speed;
		this.angle = angle;
		this.name = name;
	}

	public void print_Vehicle() {
		System.out.print(this.speed + ", ");
		System.out.print(this.angle + ", ");
		System.out.println(this.name);
	}
}

class LinkedList1 {
	private Object value;
	private LinkedList1 next;

	public static void main(String[] args) {
		LinkedList1 list1 = new LinkedList1();
		LinkedList1 list2 = new LinkedList1();
		LinkedList1 list3 = new LinkedList1();
		Vehicle2 car = new Vehicle2();
		Vehicle2 train = new Vehicle2();
		Vehicle2 bike = new Vehicle2();
		LinkedList1 list;
		Vehicle2 vehicle;

		car.set_Vehicle(100, 0.0, "わたし車");
		train.set_Vehicle(200, 0.0, "あなたの電車");
		bike.set_Vehicle(50, 0.0, "かれのバイク");

		list1.value = car;
		list2.value = train;
		list3.value = bike;

		list1.next = list2;
		list2.next = list3;
		list3.next = null;

		list = list1;
		while (list != null) {
			vehicle = (Vehicle2) list.value;
			vehicle.print_Vehicle();
			list = list.next;
		}
	}
}

public class ex02_06 {
	public static void main(String[] args) {
		LinkedList1.main(null);
	}
}
