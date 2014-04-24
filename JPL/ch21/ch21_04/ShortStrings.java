package ch21.ch21_04;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ShortStrings implements ListIterator<String> {
	private ListIterator<String> strings;
	private String nextShort;
	private String prevShort;
	private final int maxLen;
//	private final int size;	

	public ShortStrings(ListIterator<String> strings, int maxLen) {
		this.strings = strings;
		this.maxLen = maxLen;
		this.nextShort = null;
		this.prevShort = null;
//		this.size = setSize();
	}

	// リストを順方向にトラバースしたときに、
	// リスト反復子がさらに要素を持っている場合に true を返します。
	public boolean hasNext() {
		if (nextShort != null)
			return true;
		while (strings.hasNext()) {
			nextShort = strings.next();
			if (nextShort.length() <= maxLen)
				return true;
		}
		nextShort = null;
		return false;
	}

	// リストを逆方向にトラバースしたときに、
	// リスト反復子がさらに要素を持っている場合に true を返します。
	public boolean hasPrevious() {
		if (prevShort != null)
			return true;
		while (strings.hasPrevious()) {
			prevShort = strings.previous();
			if (prevShort.length() <= maxLen)
				return true;
		}
		prevShort = null;
		return false;
	}

	// リスト内の次の要素を返します。
	public String next() {
		if (nextShort == null && !hasNext())
			throw new NoSuchElementException();
		String n = nextShort;
		nextShort = null;
		return n;
	}

	// リストの前の要素を返します。
	public String previous() {
		if (prevShort == null && !hasPrevious())
			throw new NoSuchElementException();
		String n = prevShort;
		prevShort = null;
		return n;
	}

	// 次に next を呼び出したときに返されることになる要素のインデックスを返します。
	public int nextIndex() {
		//return (hasNext() ? strings.nextIndex() : size);
		return strings.nextIndex();
	}

	// 次に previous を呼び出したときに返されることになる要素のインデックスを返します。
	public int previousIndex() {
		//return (hasPrevious() ? strings.previousIndex() : -1);
		return strings.previousIndex();
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

	// 省略
	public void add(String arg0) {
		throw new UnsupportedOperationException();
	}

	// 省略
	public void set(String arg0) {
		throw new UnsupportedOperationException();
	}
	
//	private int setSize(){
//		int size = 0;
//		while (strings.hasNext()) {
//			strings.next();
//			size++;
//		}
//		while(hasPrevious())	previous();
//		return size;
//	}

}