package ch01.ex01_08;

class Point {
	public double x, y;

	public void clear() {
		this.x = 0.0;
		this.y = 0.0;
	}

	public double distance(Point that) {
		double xdiff = this.x - that.x;
		double ydiff = this.y - that.y;

		return Math.sqrt(xdiff * xdiff + ydiff * ydiff);
	}

	// 追加
	public void x_set(double x) {
		this.x = x;
	}

	// 追加
	public void y_set(double y) {
		this.y = y;
	}

	// 追加
	public void copy(Point that) {
		this.x = that.x;
		this.y = that.y;
	}
}

public class ex01_08 {

	public static void main(String[] args) {
		/*
		 * Point lowerLeft = new Point(); Point upperRight = new Point(); Point
		 * middlePoint = new Point();
		 * 
		 * lowerLeft.x = 0; lowerLeft.y = 0;
		 * 
		 * upperRight.x = 1280.0; upperRight.y = 1024.0;
		 * 
		 * middlePoint.x = 640.0; middlePoint.y = 512.0;
		 */
		Point sample = new Point();
		Point buf_samp = new Point();

		sample.clear();
		System.out.println("x = " + sample.x + ", y = " + sample.y);
		sample.x_set(5.2);
		System.out.println("x = " + sample.x + ", y = " + sample.y);
		sample.y_set(7.3);
		System.out.println("x = " + sample.x + ", y = " + sample.y);
		System.out.println("****************");
		buf_samp.clear();
		System.out.println("x = " + buf_samp.x + ", y = " + buf_samp.y);
		buf_samp.copy(sample);
		System.out.println("x = " + buf_samp.x + ", y = " + buf_samp.y);
	}
}