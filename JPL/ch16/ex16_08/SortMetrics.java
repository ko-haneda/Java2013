package ex16_08;

final class SortMetrics implements Cloneable{
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
