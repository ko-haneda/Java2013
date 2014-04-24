package ch22.ch22_05;

import java.util.*;

//どの乱数発生メソッドを用いても結果は大して変わらない（※nextGaussian()は例外）
public class ch22_05 {

	public static void main(String[] args) {
		final int SIZED = 6;
		final int TRIAL = 1000;
		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();

		//計測
		for (int i = 0; i < TRIAL; i++) {
			for (int j = 1; j <= SIZED; j++) {
				for (int k = 1; k <= SIZED; k++) {
					int sum1 = getSumPractice();
					int sum2 = getSumTheory(j, k);
					Integer buf1 = map1.get(sum1);
					Integer buf2 = map2.get(sum2);
					if(buf1 == null)	map1.put(sum1, 1);
					else				map1.put(sum1, buf1 + 1);
					if(buf2 == null)	map2.put(sum2, 1);
					else				map2.put(sum2, buf2 + 1);
				}
			}
		}
		//結果を出力
		for (int i = 2; i <= SIZED * 2; i++) {
			System.out.print ("合計 = " + i + " :\t");
			System.out.printf("実績%.2f \t", (map1.get(i) / (double)(TRIAL * SIZED * SIZED)));
			System.out.printf("理論%.2f \n", (map2.get(i) / (double)(TRIAL * SIZED * SIZED)));
		}
	}

	public static int getSumPractice() {
		Random r = new Random();
		int val1 = r.nextInt(6) + 1; // 1~6面
		r.setSeed(r.nextLong());	 //シードのリセット
		int val2 = r.nextInt(6) + 1; // 1~6面
		return val1 + val2;
	}

	public static int getSumTheory(int val1, int val2) {
		return val1 + val2;
	}
}
