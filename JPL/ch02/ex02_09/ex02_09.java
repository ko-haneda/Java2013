package ch02.ex02_09;

class Vehicle4 {
	private int id;
	private int speed;
	private double angle;
	private String name;
	private static int max_id = 0;

	public Vehicle4() {
		this.id = 0;
		this.speed = 0;
		this.angle = 0.0;
		this.name = "";
	}

	public Vehicle4(int id, int speed, double angle, String name) {
		this();
		this.id = id;
		this.speed = speed;
		this.angle = angle;
		this.name = name;
		if (max_id < this.id)
			max_id = this.id;
	}

	public static int max_id() {
		return Vehicle4.max_id;
	}

	public static void main(String[] args) {
		Vehicle4 car = new Vehicle4(3, 100, 0.0, "私の車");
		Vehicle4 train = new Vehicle4(2, 200, 0.0, "あなたの電車");

		car.print_Vehicle();
		train.print_Vehicle();

		System.out.println(Vehicle4.max_id());
	}

	public void print_Vehicle() {
		System.out.print(this.id + ", ");
		System.out.print(this.speed + ", ");
		System.out.print(this.angle + ", ");
		System.out.println(this.name);
	}
}

public class ex02_09 {
	public static void main(String[] args) {
		Vehicle4.main(null);
	}
}
