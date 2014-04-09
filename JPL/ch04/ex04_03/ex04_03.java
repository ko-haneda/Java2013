package ch04.ex04_03;

public class ex04_03 {
	//インターフェースを作る必要はない。
	//LinkedListはリストとしての最低限の機能しかもっていないので、
	//インターフェースを作るほどのものではない。
	//addやremoveなどの実装を行う場合は作ったほうがよいかもしれない。
	public static void main(String[] args) {
		LinkedList1 list;
		LinkedList1 buf_list;
		LinkedList1 list1 = new LinkedList1("1");
		LinkedList1 list2 = new LinkedList1("2");
		LinkedList1 list3 = new LinkedList1("3");
		LinkedList1 list4 = new LinkedList1("4");
		LinkedList1 list5 = new LinkedList1("5");

		list1.setNext(list2);
		list2.setNext(list3);
		list3.setNext(list4);
		list4.setNext(list5);
		list5.setNext(null);

		list = list1;
		buf_list = list.clone();
		while (list != null) {
			System.out.println(list);
			list = list.getNext();
		}
		
		list2.setValue("3");
		System.out.println();
		while (buf_list != null) {
			System.out.println(buf_list);
			buf_list = buf_list.getNext();
		}
	}
}

interface List1{
	public Object getValue();
	public void setValue(Object value); 
	public LinkedList1 getNext();
	public int getElementNum();
}

class LinkedList1 implements Cloneable, List1{
	private Object value;
	private LinkedList1 next;

	public LinkedList1() {
		this.setValue(null);
		this.setNext(null);
	}

	public LinkedList1(Object value) {
		this.setValue(value);
		this.setNext(null);
	}

	public String toString() {
		String str = "";

		str += this.getValue();

		return str;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public LinkedList1 getNext() {
		return next;
	}

	public void setNext(LinkedList1 next) {
		this.next = next;
	}

	public int getElementNum() {
		int i = 0;
		LinkedList1 list = this;

		while (list != null) {
			i++;
			list = list.getNext();
		}
		return i;
	}
	public LinkedList1 clone(){
		return this;
	}
}