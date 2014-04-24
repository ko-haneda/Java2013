package ch22.ch22_06;

import java.util.*;

public class ch22_06 {
	public static void main(String[] args) {
		final int TRIAL = 1000000;
		final float BIN = 0.1f; //ビンの幅
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int min =  100;
		int max = -100;
		
		for (Integer key : map.keySet()) {
	        System.out.println(map.get(key));
	    }
		
		// 計測
		for (int i = 0; i < TRIAL; i++) {
			Random r = new Random();
			int val = Math.round((float)(r.nextGaussian() / BIN));
			if(min > val)	min = val;
			if(max < val)	max = val;
			Integer buf = map.get(val);
			if (buf == null)	map.put(val, 1);
			else				map.put(val, buf + 1);
		}
		transLinear(map);
		// 結果を出力
		for (int i = min; i <= max; i++) {
			Integer res = map.get(i);
			if(res == null || res == 0)	continue;
			System.out.printf("%5.2f : ", (i * BIN));
			for(int j = 0; j < res; j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// 線形変換する
	public static void transLinear(Map<Integer, Integer> map) {
		final int WIDTH = 100;	//＊の最大の数
		int max = 0;
		for (Integer key : map.keySet()) {
	        if(max < map.get(key)) 	max = map.get(key);
	    }
		double coef = max / WIDTH;
		for (Integer key : map.keySet()) {
			map.put(key, (int)(map.get(key) / coef));
	    }
	}
}
