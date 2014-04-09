package ch02.ex02_08;

/*
 ・引数なしのコンストラクタでフィールドはすべてNULLに初期化する。
 ・Object valueを引数に持つコンストラクタ

 →個人的にはLinkedListインスタンスの生成時に前に
 作成したインスタンスのnextを今のインスタンスにしておきたい。　　　　
 コーディングしてみた。
 →が正しく動作させることができなかった。
 */

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

class LinkedList2 {
	private Object value;
	private LinkedList2 next;

	// private static LinkedList2 previous = null;

	public LinkedList2() {
		// LinkedList2.previous.next = this;
		this.value = null;
		this.next = null;
		// LinkedList2.previous = this;
	}

	public LinkedList2(Object value) {
		// LinkedList2.previous.next = this;
		this.value = value;
		this.next = null;
		// LinkedList2.previous = this;

	}

	public static void main(String[] args) {
		Vehicle2 car = new Vehicle2();
		Vehicle2 train = new Vehicle2();
		Vehicle2 bike = new Vehicle2();
		LinkedList2 list;
		Vehicle2 vehicle;

		car.set_Vehicle(100, 0.0, "わたし車");
		train.set_Vehicle(200, 0.0, "あなたの電車");
		bike.set_Vehicle(50, 0.0, "かれのバイク");

		LinkedList2 list1 = new LinkedList2(car);
		LinkedList2 list2 = new LinkedList2(train);
		LinkedList2 list3 = new LinkedList2(bike);

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

public class ex02_08 {
	public static void main(String[] args) {
		LinkedList2.main(null);
	}
}
