package ch03.ex03_01;

class Vehicle1 {
	private int id;
	private int speed;
	private double angle;
	private String name;
	private static int max_id = 0;

	Vehicle1() {
		this.id = 0;
		this.speed = 0;
		this.setAngle(0.0);
		this.setName("");
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
class PassengerVehicle1 extends Vehicle1{
	private final int max_seat = 5;
	private int seat;
	
	PassengerVehicle1(){
		super();
		this.setSeat(0);
	}
	
	PassengerVehicle1(int seat){
		this();
		this.setSeat(seat);
	}
	PassengerVehicle1(int seat, int id, int speed, double angle, String name){
		super(id, speed, angle, name);
		this.setSeat(seat);
	}

	public int getMax_seat() {
		return max_seat;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}	
}

public class ex03_01 {

	public static void main(String[] args) {
		PassengerVehicle1 car1 = new PassengerVehicle1();
		PassengerVehicle1 car2 = new PassengerVehicle1(3);
		PassengerVehicle1 car3 = new PassengerVehicle1(4, 4, 60, 90, "tanaka");
		
		System.out.println(car1.getSeat());
		System.out.println(car2.getSeat());
		System.out.println(car3.getAngle());
		System.out.println(car3.getId());
		System.out.println(car3.getSeat());
	}
}
