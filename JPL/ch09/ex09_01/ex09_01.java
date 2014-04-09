package ch09.ex09_01;

public class ex09_01 {
	public static void main(String[] args) {
		double p_num = Double.POSITIVE_INFINITY;
		double n_num = Double.NEGATIVE_INFINITY;
		System.out.println("∞ + ∞ = " + (p_num + p_num));
		System.out.println("∞ - ∞ = " + (p_num - p_num));
		System.out.println("∞ * ∞ = " + (p_num * p_num));
		System.out.println("∞ / ∞ = " + (p_num / p_num));
		System.out.println();
		System.out.println("∞ + (-∞) = " + (p_num + n_num));
		System.out.println("∞ - (-∞) = " + (p_num - n_num));
		System.out.println("∞ * (-∞) = " + (p_num * n_num));
		System.out.println("∞ / (-∞) = " + (p_num / n_num));
	}
}