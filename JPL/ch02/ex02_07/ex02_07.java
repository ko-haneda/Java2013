package ch02.ex02_07;

class Vehicle3 {
	private int speed;
	private double angle;
	private String name;

	public Vehicle3() {
		this.speed = 0;
		this.angle = 0.0;
		this.name = "";
	}

	public Vehicle3(String name) {
		this();
		this.name = name;
	}

	public static void main(String[] args) {
		Vehicle3 car = new Vehicle3("私の車");
		Vehicle3 train = new Vehicle3("あなたの電車");

		car.set_Vehicle(100, 0.0, car.name);
		train.set_Vehicle(200, 0.0, train.name);

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

public class ex02_07 {
	public static void main(String[] args) {
		Vehicle3.main(null);
	}
}
