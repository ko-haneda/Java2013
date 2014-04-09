package ch19.ex19_01;

/**
 * 可変長配列を実現するクラスです
 * setNextメソッドで次のリストを追加することができ、
 * getNextメソッドで次のリストを取得することができます
 * @author Kotaro Haneda
 */
public class LinkedList {
	private Object value;
	private LinkedList next;

	/**
	 * 指定されたオブジェクトを設定し、リストを作成します
	 * @param value　オブジェクト
	 */
	public LinkedList(Object value) {
		this.setValue(value);
		this.setNext(null);
	}

	/**
	 * オブジェクトを表示します
	 */
	public String toString() {
		return (String) this.getValue();
	}

	/**
	 * オブジェクトを取得します
	 * @return　オブジェクト
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * このリストのオブジェクトを設定します
	 * @param value　オブジェクト
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * このリストの次のリストを取得します
	 * @return　次のリスト
	 */
	public LinkedList getNext() {
		return next;
	}

	/**
	 * このリストの次のリストを設定します
	 * @param next　次のリスト
	 */
	public void setNext(LinkedList next) {
		this.next = next;
	}

	/**
	 * このリストより後ろに続くリストの数を取得します
	 * @return　後ろに続くリストの数
	 */
	public int getElementNum() {
		int i = 0;
		LinkedList list = this;

		while (list != null) {
			i++;
			list = list.getNext();
		}
		return i;
	}
}
