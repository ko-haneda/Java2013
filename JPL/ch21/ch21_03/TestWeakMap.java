package ch21.ch21_03;

import java.util.*;

public class TestWeakMap {
	public static void comparePerformance(Map<String, String> map) {
		String[] key = new String[5];
		String[] val = new String[5];

		//Mapにエントリーをセット
		for (int i = 0; i < key.length; i++) {
			key[i] = String.valueOf(4 - i);
			val[i] = String.valueOf((char) ('A' + 4 - i));
			map.put(key[i], val[i]);
		}
		System.out.println(map);
		
		//強い参照状態から弱い参照状態に...
		key[1] = null;	//３の削除
		val[1] = null;	//Dの削除
		Runtime.getRuntime().gc();
		System.out.println(map);
		
		//WeakHashMapはキーだけが弱い参照になっていることを証明。
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < key.length; i++) {
			if(map.containsKey(String.valueOf(4 - i)))					count1++;
			if(map.containsValue(String.valueOf((char)('A' + 4 - i))))	count2++;
		}
		System.out.println("残っているkeyは" + count1 + "個です。");
		System.out.println("残っているvalは" + count2 + "個です。");
		System.out.println();
	}
}
