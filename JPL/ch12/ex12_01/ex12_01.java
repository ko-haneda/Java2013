package ch12.ex12_01;

public class ex12_01 {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>("test0");
		list.add(new LinkedList<String>("test1"));
		list.add(new LinkedList<String>("test2"));
		list.add(new LinkedList<String>("test3"));
		try {
			System.out.println(list.find("test1"));
			System.out.println(list.find("test3"));
			System.out.println(list.find("test5"));
		} catch (ObjectNotFoundException e) {
			System.out.println(e);
		}
	}
}
