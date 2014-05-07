package ch14.ex14_02;

//11章(p.216)から引用
public class SingleLinkQueue<E> {

	protected Cell<E> head;
	protected Cell<E> tail;

	public void add(E item) {
		Cell<E> cell = new Cell<E>(item);
		if (tail == null) {
			head = tail = cell;
		} else {
			tail.setNext(cell);
			tail = cell;
		}
	}

	public E remove() {
		if (head == null)	return null;
		Cell<E> cell = head;
		head = head.getNext();
		if (head == null)	tail = null;
		return cell.getElement();
	}
	
	public int size() {
		if(head == null)	return 0;
		int size = 1;
		Cell<E> buf = head.getNext();
		//tailで見ても良い。
		while(buf != null){
			size++;
			buf = buf.getNext();
		}		
		return size;
	}
}