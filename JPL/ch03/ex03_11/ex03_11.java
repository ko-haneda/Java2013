package ch03.ex03_11;

//問題点は　ソートの回数をカウントする変数がどこからでも変更できてしまうこと
abstract class SortDouble {
	private double[] values;
	private final SortMetrics curMetrics = new SortMetrics();

	public final SortMetrics sort(double[] data) {
		values = data;
		curMetrics.init();
		doSort();
		return getMetrics();
	}

	public final SortMetrics getMetrics() {
		return curMetrics.clone();
	}

	protected final int getDataLength() {
		return values.length;
	}

	protected final double probe(int i) {
		curMetrics.add_probeCnt();
		return values[i];
	}

	protected final int compare(int i, int j) {
		curMetrics.add_compareCnt();
		double d1 = values[i];
		double d2 = values[j];
		if (d1 == d2)
			return 0;
		else
			return (d1 < d2 ? -1 : 1);
	}

	protected final void swap(int i, int j) {
		curMetrics.add_swapCnt();
		double tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}

	protected abstract void doSort();
}

final class SortMetrics implements Cloneable {
	private long probeCnt, compareCnt, swapCnt;

	public void init() {
		probeCnt = compareCnt = swapCnt = 0;
	}
	protected void add_probeCnt() {
		probeCnt++;
	}
	protected void add_compareCnt() {
		compareCnt++;
	}
	protected void add_swapCnt() {
		swapCnt++;
	}

	public String toString() {
		String str = "";
		str += probeCnt + "probes";
		str += compareCnt + "compares";
		str += swapCnt + "swaps";
		return str;
	}

	public SortMetrics clone() {
		try {
			return (SortMetrics) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
}

class SimpleSortDouble extends SortDouble {
	protected void doSort() {
		for (int i = 0; i < getDataLength(); i++) {
			for (int j = 0; j < getDataLength(); j++) {
				if (compare(i, j) > 0)
					swap(i, j);
			}
		}
	}
}

class TestSort {
	static double[] testData = { 0.3, 1.3e-2, 7.9, 3.17 };

	public static void main(String[] args) {
		SortDouble bsort = new SimpleSortDouble();
		SortMetrics metrics = bsort.sort(testData);
//		metrics.compareCnt++;
		
		System.out.println("Metrics:" + metrics);
		for (int i = 0; i < testData.length; i++) {
			System.out.println("\t" + testData[i]);
		}
	}
}

public class ex03_11 {
	public static void main(String[] args) {
		TestSort.main(null);
	}

}
