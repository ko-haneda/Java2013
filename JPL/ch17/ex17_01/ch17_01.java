package ch17.ex17_01;

import java.util.ArrayList;

public class ch17_01 {
	/*
	 * 多くのオブジェクトを生成しすぎると、元の空きメモリより
	 * gc()を呼び出した後の空きメモリの方が大きくなってしまう。
	 * freeMemory()は正しい値を返すとは限らないらしい。
	 * i < 100000000 にしたとき
	  	現在の空きメモリ : 243MB
		*****************オブジェクトを大量生成*****************
		現在の空きメモリ : 35MB
		***************************************************
		現在の空きメモリ : 1274MB
	 * */
	public static void main(String[] args) {
		System.out.println("現在の空きメモリ : " + Runtime.getRuntime().freeMemory() / (1024 * 1024) + "MB");
		ArrayList<Long> list = new ArrayList<Long>();
		for(int i = 0; i < 300000; i++){
			list.add(1L);
		}
		System.out.println("*****************オブジェクトを大量生成*****************");
		System.out.println("現在の空きメモリ : " + Runtime.getRuntime().freeMemory() / (1024 * 1024) + "MB");
		System.out.println("***************************************************");
		
		Runtime.getRuntime().gc();
		System.out.println("現在の空きメモリ : " + Runtime.getRuntime().freeMemory() / (1024 * 1024) + "MB");
	}
}
