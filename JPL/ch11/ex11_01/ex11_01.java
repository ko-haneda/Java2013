package ch11.ex11_01;

public class ex11_01 {
	public static void main(String[] args) {
		LinkedList<String> list1 = new LinkedList<String>("test0");
		list1.add(new LinkedList<String>("test1"));
		list1.add(new LinkedList<String>("test2"));
		list1.add(new LinkedList<String>("test3"));
		System.out.println(list1);
		
		LinkedList<Integer> list2 = new LinkedList<Integer>(0);
		list2.add(new LinkedList<Integer>(1));
		list2.add(new LinkedList<Integer>(2));
		list2.add(new LinkedList<Integer>(3));
		System.out.println(list2);
	}
}
