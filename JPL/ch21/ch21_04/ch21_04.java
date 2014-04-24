package ch21.ch21_04;

import java.util.*;

public class ch21_04 {
	/*
	 * 問題文の問いを以下のように理解しました。
	 * Q:ListIteratorを実装したShortStringsはIteratorを実装したShortStringsを拡張すべきですか？
	 * 
	 * A:拡張すべきではない。
	 * ListIterator<?> ss = new ShortStrings(list.listIterator(), 3)のように書くことができなくなる
	 * 多用な動作（ポリモーフィズム）ができなくなるので、拡張すべきではない。→多様な動作できそうな気がする
	 * あとでclass ShortStrings2 extends ShortStrings1 implements ListIterator<String>ができるかテスト
	 * →できそうな気がする。Iteratorを継承したListIteratorの実装はできるはず。
	 * 
	 * FA:拡張すべきである。　※フィールドのprivateをやめる必要がある。
	 */
	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();
		for (int i = 0; i < 10; i++)	list.add(String.valueOf((char) ('A' + i)));
		list.add("KLM");	//10
		list.add("NOPQ");	//11
		list.add("RSTUV");	//12
		list.add("WXYZ");	//13
		ShortStrings ss = new ShortStrings(list.listIterator(), 3);	//"４文字以上を表示させないようにする。

		while(ss.hasNext()){
			//"KLM"のss.nextIndex()は14で表示されるべき？？
			System.out.println("値 = " + ss.next() + "\t 次のindex = " + ss.nextIndex());
		}
		System.out.println();
		
		while(ss.hasPrevious()){
			System.out.println("値 = " + ss.previous() + "\t 前のindex = " + ss.previousIndex());
		}
	}
	
}
