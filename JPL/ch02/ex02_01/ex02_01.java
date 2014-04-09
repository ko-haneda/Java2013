package ch02.ex02_01;

class Vehicle {
	public int speed;
	public double angle;
	public String name;
}

public class ex02_01 {
	public static void main(String[] args) {
		Vehicle car = new Vehicle();
		car.speed = 0;
		car.angle = 0;
		car.name = "";
		System.out.println(car.speed);
	}
}
