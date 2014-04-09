package ch02.ex02_15;

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

public class ex02_15 {
	public static void main(String[] args) {
		Vehicle7 car = new Vehicle7(3, 100, 0.0, "私の車");

		System.out.println(car);
		car.changeSpeed(200);
		System.out.println(car);
		car.stop();
		System.out.println(car);
	}
}
