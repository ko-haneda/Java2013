package ch22.ch22_04;

public class ch22_04 {
	public static void main(String[] args) {
		AttributedImpl<Integer> attributed = new AttributedImpl<Integer>();

		attributed.add(new Attr<Integer>("A", 1));
		attributed.add(new Attr<Integer>("B", 2));
		
		new AttributedObserver<Integer>(attributed);	//ここから監視開始
		
		attributed.add(new Attr<Integer>("C", 3));
		attributed.add(new Attr<Integer>("D", 4));

		attributed.remove("A");
		attributed.remove("C");
	}
}
