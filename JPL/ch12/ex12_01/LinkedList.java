package ch12.ex12_01;


public class LinkedList<E> {
	private E value;
	private LinkedList<E> next;

	public LinkedList() {
		this.value = null;
		this.next = null;
	}

	public LinkedList(E value) {
		this.value = value;
		this.next = null;
	}
	
	public void add(LinkedList<E> newList){
		LinkedList<E> list = this;

		while (list.next != null) {
			list = list.next;
		}
		list.next = newList;
	}
	
	public LinkedList<E> find(E value) throws ObjectNotFoundException{
		LinkedList<E> list = this;

		while (list != null) {
			if(list.value.equals(value))
				return list;
			list = list.next;
		}
		throw new ObjectNotFoundException(value.toString());
	}

	public String toString() {
		String str = "";
		LinkedList<E> list = this;

		while (list != null) {
			str += (list.value.toString() + "\n");
			list = list.next;
		}

		return str;
	}
	
	public int getElementNum() {
		int i = 0;
		LinkedList<E> list = this;

		while (list != null) {
			i++;
			list = list.getNext();
		}
		return i;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public LinkedList<E> getNext() {
		return next;
	}

	public void setNext(LinkedList<E> next) {
		this.next = next;
	}
}
