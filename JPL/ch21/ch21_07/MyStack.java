package ch21.ch21_07;

import java.util.*;

public class MyStack<E> {

	private ArrayList<E> array = new ArrayList<E>();

	// スタックが空かどうかを判定します。
	boolean empty() {
		return array.isEmpty();
	}

	// スタックの先頭にあるオブジェクトを取り出します。
	E peek() {
		return array.get(array.size() - 1);
	}

	// スタックの先頭のオブジェクトを削除し、そのオブジェクトを関数の値として返します
	E pop() {
		return array.remove(array.size() - 1);
	}

	// スタックの先頭にオブジェクトを入れます。
	E push(E item) {
		//java.util.Stackの通り、エラー処理は行わない。
		//itemがnullの場合等は考えない。
		array.add(item);
		return item;
	}

	// このスタックにあるオブジェクトの位置を 1 から始まるインデックスで返します。
	int search(Object o) {
		int index = array.indexOf(o);
		return index == -1 ? -1 : array.size() - index;
	}

}
