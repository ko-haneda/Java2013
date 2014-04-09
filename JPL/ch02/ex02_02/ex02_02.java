package ch02.ex02_02;

class LinkedList {
	public Object value;
	public LinkedList next;
}

public class ex02_02 {
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		LinkedList list3 = new LinkedList();
		LinkedList list;

		list1.value = 1;
		list2.value = 2;
		list3.value = "tanaka";
		list1.next = list2;
		list2.next = list3;
		list3.next = null;

		list = list1;
		while (list != null) {
			System.out.println(list.value);
			list = list.next;
		}
	}
}
