package ch03.ex03_12;

//hashcode値によって、異なるオブジェクト同士を比較した。

abstract class SortDouble2 {
	private Object[] values;
	private final SortMetrics2 curMetrics = new SortMetrics2();

	public final SortMetrics2 sort(Object[] data) {
		values = data;
		curMetrics.init();
		doSort();
		return getMetrics();
	}

	public final SortMetrics2 getMetrics() {
		return curMetrics.clone();
	}

	protected final int getDataLength() {
		return values.length;
	}

	protected final Object probe(int i) {
		curMetrics.add_probeCnt();
		return values[i];
	}

	protected final int compare(int i, int j) {
		curMetrics.add_compareCnt();
		int d1 = values[i].hashCode();
		int d2 = values[j].hashCode();
		if (d1 == d2)
			return 0;
		else
			return (d1 < d2 ? -1 : 1);
	}

	protected final void swap(int i, int j) {
		curMetrics.add_swapCnt();
		Object tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}

	protected abstract void doSort();
}

final class SortMetrics2 implements Cloneable {
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

	public SortMetrics2 clone() {
		try {
			return (SortMetrics2) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
}

class SimpleSortDouble2 extends SortDouble2 {
	protected void doSort() {
		for (int i = 0; i < getDataLength(); i++) {
			for (int j = 0; j < getDataLength(); j++) {
				if (compare(i, j) > 0)
					swap(i, j);
			}
		}
	}
}

//ソートの回数をカウントする変数がどこからでも変更できてしまうこと
class TestSort2 {
	static Object[] testData = { "test", 1.3e-2, 7, 'c', '6', 8 };

	public static void main(String[] args) {
		SortDouble2 bsort = new SimpleSortDouble2();
		SortMetrics2 metrics = bsort.sort(testData);
		System.out.println("Metrics:" + metrics);
		for (int i = 0; i < testData.length; i++) {
			System.out.println("\t" + testData[i]);
		}
	}
}

public class ex03_12 {
	public static void main(String[] args) {
		TestSort2.main(null);
	}

}
