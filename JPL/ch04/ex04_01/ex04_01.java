package ch04.ex04_01;

interface EnergySource {
	final int max_percent = 100;
	abstract boolean empty();
	abstract int getNow_percent();
	abstract void setNow_percent(int now);
}

class GaskTank implements EnergySource {
	private double use_ratio;
	private int now_percent;
	
	GaskTank() {
		this.use_ratio = 0.1;
		this.now_percent = EnergySource.max_percent;
	}
	
	public void setNow_percent(int now){
		this.now_percent = now;
	}
	public int getNow_percent(){
		return this.now_percent;
	}

	GaskTank(int use_ratio) {
		this();
		this.use_ratio = use_ratio;
	}

	public boolean empty() {
		if (this.now_percent * this.use_ratio < 1) {
			return true;
		} else {
			return false;
		}
	}
}

class Vehicle1 {
	private int id;
	private int speed;
	private double angle;
	private String name;
	private static int max_id = 0;
	private EnergySource energy;

	Vehicle1() {
		this.id = 0;
		this.speed = 0;
		this.setAngle(0.0);
		this.setName("");
		this.energy = new GaskTank();
	}

	Vehicle1(int id, int speed, double angle, String name) {
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

public class ex04_01 {
	public static void main(String[] args) {
		Vehicle1 car = new Vehicle1();
		
		car.start();

	}
}
