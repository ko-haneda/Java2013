package ch02.ex02_03;

class Vehicle1 {
	public static int style = 0;
	public int id;
}

public class ex02_03 {
	public static void main(String[] args) {
		Vehicle1 car = new Vehicle1();
		/* 警告はでるけど、値が変更されてしまう */
		// car.style = 1;
		// System.out.println(car.style);
		/*                         */

		Vehicle1.style = 2;
		System.out.println(Vehicle1.style);
		car.id = 3;
		System.out.println(car.id);
	}
}
