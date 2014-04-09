package ch03.ex03_09;

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
class Garage implements Cloneable{
	int count;
	private Vehicle2[] cars;
	Garage(){
		count = 0;
		this.cars = null;
	}
	Garage(int num){
		count = 0;
		cars = new Vehicle2[num];
	}
	
	public Garage clone(){
		Garage garage = new Garage(this.count);
		for(int i = 0; i < this.count; i++){
			garage.cars[i] = this.cars[i].clone();
		}
		garage.count = this.count;
		return garage;
	}
	
	public void set_car(Vehicle2 car){
		this.cars[count] = car;
		count++;
	}
	
	public String toString(){
		String str = "";
		for(int i = 0; i < count; i++){
			str += cars[i].toString();
			str += "\n";
		}
		return str;
	}
	
	public static void main(String[] args) {
		Garage garage = new Garage(5);
		Garage buf_garage;
		
		garage.set_car(new Vehicle2(4, 60, 90, "tanaka1"));
		garage.set_car(new Vehicle2(5, 60, 90, "tanaka2"));
		garage.set_car(new Vehicle2(6, 60, 90, "tanaka3"));
		System.out.println(garage.toString());
		buf_garage = garage.clone();
		garage.cars[1].setId(100);
		System.out.println("コピー元");
		System.out.println(garage);
		System.out.println("コピー先");
		System.out.println(buf_garage);
		
	}
}
public class ex03_09 {
	public static void main(String[] args) {
		Garage.main(null);
	}
}
