package ch03.ex03_05;

abstract class Benchmark {
	abstract void benchmark();

	public final long repeat(int count) {
		long start = System.nanoTime();
		for (int i = 0; i < count; i++) {
			benchmark();
		}
		return (System.nanoTime() - start);
	}
}

class MethodBenchmark extends Benchmark {
	void benchmark() {
		//System.out.println();の時間を計測する
		//System.out.println();
		//System.out.print();の時間を計測する
		System.out.print("");
	}

	public static void main(String[] args) {

		int count = Integer.parseInt(args[0]);
		long time = new MethodBenchmark().repeat(count);
		System.out.println(count + "methods in " + time + " nanoseconds");
	}
}

public class ex03_05 {
	public static void main(String[] args) {
		String []str = new String[2];
		str[0] = "10";
		str[1] = " ";
		MethodBenchmark.main(str);
	}
	
	//System.out.println(); 出力　520252、478806、455517
	//System.out.print(""); 出力   149997、133418、132234
}
