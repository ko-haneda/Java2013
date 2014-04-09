package ch04.ex04_02;
//hashcode値によって、異なるオブジェクト同士を比較した。

interface Sort{
	int getDataLength();
	Object probe(int i);
	int compare(int i, int j);
	void swap(int i, int j);
	void doSort();	
}
abstract class SortDouble1 implements Sort{
	private Object[] values;
	private final SortMetrics1 curMetrics = new SortMetrics1();

	public final SortMetrics1 sort(Object[] data) {
		values = data;
		curMetrics.init();
		doSort();
		return getMetrics();
	}

	public final SortMetrics1 getMetrics() {
		return curMetrics.clone();
	}

	public final int getDataLength() {
		return values.length;
	}

	
	public final Object probe(int i) {
		curMetrics.add_probeCnt();
		return values[i];
	}

	public final int compare(int i, int j) {
		curMetrics.add_compareCnt();
		int d1 = values[i].hashCode();
		int d2 = values[j].hashCode();
		if (d1 == d2)
			return 0;
		else
			return (d1 < d2 ? -1 : 1);
	}

	public final void swap(int i, int j) {
		curMetrics.add_swapCnt();
		Object tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}

	public abstract void doSort();
}

final class SortMetrics1 implements Cloneable {
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

	public SortMetrics1 clone() {
		try {
			return (SortMetrics1) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
}

class SimpleSortDouble1 extends SortDouble1 {
	public void doSort() {
		for (int i = 0; i < getDataLength(); i++) {
			for (int j = 0; j < getDataLength(); j++) {
				if (compare(i, j) > 0)
					swap(i, j);
			}
		}
	}
}

//ソートの回数をカウントする変数がどこからでも変更できてしまうこと
class TestSort1 {
	static Object[] testData = { "test", 1.3e-2, 7, 'c', '6', 8 };

	public static void main(String[] args) {
		SortDouble1 bsort = new SimpleSortDouble1();
		SortMetrics1 metrics = bsort.sort(testData);
		System.out.println("Metrics:" + metrics);
		for (int i = 0; i < testData.length; i++) {
			System.out.println("\t" + testData[i]);
		}
	}
}

public class ex04_02 {
	public static void main(String[] args) {
		TestSort1.main(null);
	}

}
