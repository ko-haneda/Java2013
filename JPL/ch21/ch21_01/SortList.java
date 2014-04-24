package ch21.ch21_01;

import java.util.*;

public class SortList {
	LinkedList<String> list;
	
	SortList(){
		list = new LinkedList<String>();
	}
	
	public void add(String str){
		ListIterator<String> it = list.listIterator();

        while(it.hasNext()) {
            String curr = it.next();
            if(str.compareTo(curr) < 0) {
                it.previous();
                it.add(str);
                return;
            }
        }
        list.addLast(str);
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		ListIterator<String> it = list.listIterator();
        while(it.hasNext()) {
            sb.append(it.next() + "\n");
        }
        return sb.toString();
	}
}
