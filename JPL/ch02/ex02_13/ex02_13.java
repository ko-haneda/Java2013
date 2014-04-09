package ch02.ex02_13;

class Vehicle6 {
	private int id;
	private int speed;
	private double angle;
	private String name;
	private static int max_id = 0;

	public Vehicle6() {
		this.id = 0;
		this.speed = 0;
		this.setAngle(0.0);
		this.setName("");
	}

	public Vehicle6(int id, int speed, double angle, String name) {
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

	/*
	 * public static void setMax_id(int max_id) { Vehicle6.max_id = max_id; }
	 */
}

public class ex02_13 {
	public static void main(String[] args) {
		Vehicle6 car = new Vehicle6(3, 100, 0.0, "私の車");
		Vehicle6 train = new Vehicle6(2, 200, 0.0, "あなたの電車");

		System.out.println(car);
		System.out.println(train);
		System.out.println(Vehicle6.getMax_id());
		// クラスフィールドのセッターは用意すべきではない。
	}
}
