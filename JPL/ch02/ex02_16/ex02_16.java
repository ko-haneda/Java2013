package ch02.ex02_16;

class Vehicle7 {
	private int id;
	private int speed;
	private double angle;
	private String name;
	private static int max_id = 0;

	public Vehicle7() {
		this.id = 0;
		this.speed = 0;
		this.setAngle(0.0);
		this.setName("");
	}

	public Vehicle7(int id, int speed, double angle, String name) {
		this();
		this.id = id;
		this.speed = speed;
		this.setAngle(angle);
		this.setName(name);
		if (max_id < this.id)
			max_id = this.id;
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * }
	 */

	public String toString() {
		String str = "";

		str += (this.id + ", ");
		str += (this.speed + ", ");
		str += (this.getAngle() + ", ");
		str += (this.getName());

		return str;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getMax_id() {
		return max_id;
	}

	public void changeSpeed(int speed) {
		setSpeed(speed);
	}

	public void stop() {
		setSpeed(0);
	}
}

class LinkedList5 {
	private Object value;
	private LinkedList5 next;

	public LinkedList5() {
		this.setValue(null);
		this.setNext(null);
	}

	public LinkedList5(Object value) {
		this.setValue(value);
		this.setNext(null);
	}

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

	public LinkedList5 getNext() {
		return next;
	}

	public void setNext(LinkedList5 next) {
		this.next = next;
	}

	public int getElementNum() {
		int i = 0;
		LinkedList5 list = this;

		while (list != null) {
			i++;
			list = list.getNext();
		}
		return i;
	}
}

public class ex02_16 {
	public static void main(String[] args) {

		Vehicle7 car = new Vehicle7(2, 100, 0.0, "わたし車");
		Vehicle7 train = new Vehicle7(6, 200, 0.0, "あなたの電車");
		Vehicle7 bike = new Vehicle7(3, 50, 0.0, "かれのバイク");

		LinkedList5 list;
		LinkedList5 list1 = new LinkedList5(car);
		LinkedList5 list2 = new LinkedList5(train);
		LinkedList5 list3 = new LinkedList5(bike);

		list1.setNext(list2);
		list2.setNext(list3);
		list3.setNext(null);

		list = list1;
		while (list != null) {
			System.out.println(list);
			list = list.getNext();
		}
		list = list1;

		System.out.println("List1の要素の数は" + list1.getElementNum());
	}
}
