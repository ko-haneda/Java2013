package ch02.ex02_10;

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

public class ex02_10 {
	public static void main(String[] args) {
		Vehicle5.main(null);
	}
}
