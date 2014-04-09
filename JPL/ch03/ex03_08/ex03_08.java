package ch03.ex03_08;
class Vehicle2 implements Cloneable{
	private int id;
	private int speed;
	private double angle;
	private String name;
	private static int max_id = 0;

	Vehicle2() {
		this.id = 0;
		this.speed = 0;
		this.setAngle(0.0);
		this.setName("");
	}

	Vehicle2(int id, int speed, double angle, String name) {
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
	
	public Vehicle2 clone(){
		return new Vehicle2(this.getId(), this.getSpeed(), this.getAngle(), this.getName());
	}
}
class PassengerVehicle2 extends Vehicle2 implements Cloneable{
	private final int max_seat = 5;
	private int seat;
	
	PassengerVehicle2(){
		super();
		this.setSeat(0);
	}
	
	PassengerVehicle2(int seat){
		this();
		this.setSeat(seat);
	}
	PassengerVehicle2(int seat, int id, int speed, double angle, String name){
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
	public PassengerVehicle2 clone(){
		return new PassengerVehicle2(this.getSeat(), this.getId(), this.getSpeed(), this.getAngle(), this.getName());
	}
	public String toString(){
		return "seat = " + this.getSeat() + "\nid = " + this.getId() + "\nspeed = " + this.getSpeed() + "\nangle = " +  this.getAngle() + "\nname = " +  this.getName();
	}
}

public class ex03_08 {
	//Vehicleも
	//PassengerVehicleも１番目のやり方
	
	public static void main(String[] args) {
		PassengerVehicle2 car = new PassengerVehicle2(4, 4, 60, 90, "tanaka");
		PassengerVehicle2 buf_car;
		
		System.out.println(car.toString());
		buf_car = car.clone();
		car.setId(100);
		System.out.println("コピー元");
		System.out.println(car.toString());
		System.out.println("コピー先");
		System.out.println(buf_car.toString());
	}
}
