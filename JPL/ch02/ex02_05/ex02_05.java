package ch02.ex02_05;

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

public class ex02_05 {
	public static void main(String[] args) {
		Vehicle2.main(null);
	}
}
