package ch06.ex06_02;

public class ex06_02 {
	public static void main(String[] args) {
		Vehicle1.main(null);

		//enumを使うことで、定数値を入れる際に間違った入力をすることがなくなる。
	}
}

class Vehicle1 {
	private int id;
	private int speed;
	private double angle;
	private String name;
	private static int max_id = 0;

/*	public static final int TURN_LEFT = -1;
	public static final int TURN_RIGHT = 1;*/
	
	public enum eAngle{
		TURN_LEFT, TURN_RIGHT
	}
	
	public Vehicle1() {
		this.id = 0;
		this.speed = 0;
		this.setAngle(0.0);
		this.setName("");
	}
	
	public static void main(String[] args) {
		Vehicle1 car = new Vehicle1(3, 100, 0.0, "私の車");

		System.out.println(car);
		car.turn(200.0);
		System.out.println(car);
		car.turn(eAngle.TURN_LEFT);
		System.out.println(car);
	}

	public Vehicle1(int id, int speed, double angle, String name) {
		this();
		this.id = id;
		this.speed = speed;
		this.setAngle(angle);
		this.setName(name);
		if (max_id < this.id)
			max_id = this.id;
	}

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

	public void turn(double angle) {
		setAngle(angle);
	}

	public void turn(eAngle angle) {
		if (angle == eAngle.TURN_LEFT)
			setAngle(-90);
		if (angle == eAngle.TURN_RIGHT)
			setAngle(90);
	}
}
