package ch09.ex09_02;

public class ex09_02 {
	// int型は4バイト
	public static void main(String[] args) {
		long start, stop;
		start = System.nanoTime();
		origin_bitcount(-1);
		stop = System.nanoTime();
		System.out.println("計測時間 = " + (stop - start));
		
		start = System.nanoTime();
		bitCount(-1);
		stop = System.nanoTime();
		System.out.println("計測時間 = " + (stop - start));
		
		System.out.println(origin_bitcount(-1));
		System.out.println(bitCount(-1));
	}

	//オリジナルのbicount
	public static int origin_bitcount(int num) {
		int count = 0;
		int mask = 1;

		for (int i = 0; i < 32; i++) {
			if ((mask & num) == mask)	count++;
			mask = mask << 1;
		}
		return count;
	}

	//Integer.bitCountのソース
	public static int bitCount(int i) {
		i = i - ((i >>> 1) & 0x55555555);
		i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
		i = (i + (i >>> 4)) & 0x0f0f0f0f;
		i = i + (i >>> 8);
		i = i + (i >>> 16);
		return i & 0x3f;
	}
}