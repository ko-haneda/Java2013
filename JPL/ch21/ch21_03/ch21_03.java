package ch21.ch21_03;

import java.util.WeakHashMap;

public class ch21_03 {
	public static void main(String[] args) {
		System.out.println("----------WeakHashMapのテスト----------");
		TestWeakMap.comparePerformance(new WeakHashMap<String, String>());
		
		System.out.println("----------WeakValueMapのテスト----------");
		TestWeakMap.comparePerformance(new WeakValueMap<String, String>());
	}
}
