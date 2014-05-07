package ch16.ex16_05;

import java.util.ArrayList;

public class Cell<E> extends ArrayList<E>{
	private static final long serialVersionUID = 1L;
	
	public Cell<E> next;
	public E element;

	public Cell(E element) {
		this.element = element;
	}

	public Cell(E element, Cell<E> next) {
		this.element = element;
		this.next = next;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public Cell<E> getNext() {
		return next;
	}

	public void setNext(Cell<E> next) {
		this.next = next;
	}

}