package ch03.ex03_06;

abstract class EnergySource {
	private final int max_percent = 100;
	private int now_percent;

	EnergySource() {
		setNow_percent(max_percent);
	}

	EnergySource(int now_percent) {
		this.setNow_percent(max_percent);
	}

	abstract boolean empty();

	public int getNow_percent() {
		return now_percent;
	}

	public void setNow_percent(int now_percent) {
		this.now_percent = now_percent;
	}
}

class Battery extends EnergySource {
	private int age;

	Battery() {
		age = 0;
	}

	Battery(int age) {
		this.age = age;
	}

	boolean empty() {
		if (this.getNow_percent() < 5 || age > 15) {
			return true;
		} else {
			return false;
		}
	}
}

class GaskTank extends EnergySource {
	private double use_ratio;

	GaskTank() {
		this.use_ratio = 0.1;
	}

	GaskTank(int use_ratio) {
		this.use_ratio = use_ratio;
	}

	boolean empty() {
		if (this.getNow_percent() * this.use_ratio < 1) {
			return true;
		} else {
			return false;
		}
	}
}

class Vehicle3 {
	private int id;
	private int speed;
	private double angle;
	private String name;
	private static int max_id = 0;
	private EnergySource energy;

	Vehicle3() {
		this.id = 0;
		this.speed = 0;
		this.setAngle(0.0);
		this.setName("");
		this.energy = new GaskTank();
	}

	Vehicle3(int id, int speed, double angle, String name) {
		this();
		this.id = id;
		this.speed = speed;
		this.setAngle(angle);
		this.setName(name);
		if (max_id < this.id)
			max_id = this.id;
	}

	public void start() {
		int max = 100;
		for (int time = 0; time < max; time++) {
			System.out.println("運転を開始してから" + time + "時間経ちました");
			this.energy.setNow_percent(this.energy.getNow_percent() - 1);
			if (this.energy.empty()) {
				System.out.println("エネルギー不足です。運転を中止してください");
				break;
			}
		}

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
}

public class ex03_06 {
	public static void main(String[] args) {
		Vehicle3 car = new Vehicle3();
		
		car.start();

	}
}
