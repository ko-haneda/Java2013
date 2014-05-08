package ch14.ex14_09;

public class ex14_09 {
	public static void main(String[] args) {
		ThreadGroup parent = new ThreadGroup("第１階層");
		ThreadGroup A = new ThreadGroup(parent, "第２階層１");	//第２階層
		ThreadGroup B = new ThreadGroup(parent, "第２階層２");	//第２階層
		ThreadGroup A_1 = new ThreadGroup(A, "第３階層A１");	//第３階層
		ThreadGroup A_2 = new ThreadGroup(A, "第３階層A2");	//第３階層
		ThreadGroup B_1 = new ThreadGroup(B, "第３階層B１");	//第３階層
		
		MyThread tParent = new MyThread(parent, "AAABBB");	
		MyThread tA1 = new MyThread(A, "AAA111");
		MyThread tA2 = new MyThread(A, "AAA222");
		MyThread tB = new MyThread(B, "BBB111");
		MyThread tA_1 = new MyThread(A_1, "AAA111-111");
		MyThread tA_2 = new MyThread(A_2, "AAA111-222");
		MyThread tB1 = new MyThread(B_1, "BBB111-111");
		
		tParent.start();
		tA1.start();
		tA2.start();
		tB.start();
		tA_1.start();
		tA_2.start();
		tB1.start();
		
		printThread(parent, 0);
	}

	public static void printThread(ThreadGroup group, int depth){
		String str = "";
		for(int i = 0; i < depth; i++)	str += "　　";
		//カレントグループ名表示
		System.out.println(str + group.getName() + "グループ");
		//カレントグループのスレッドの表示
		int count = group.activeCount();
		Thread[] threadsInGroup = new Thread[count];
		group.enumerate(threadsInGroup, false);
		for(Thread t : threadsInGroup){
			if(t != null)	System.out.println(str + "　　" + t.getName() + "スレッド");
		}
		//下層のグループ
		int countGroup = group.activeGroupCount();
		if(countGroup == 0)	return;		//再帰の終了
		ThreadGroup[] groupsInGroup = new ThreadGroup[countGroup];
		group.enumerate(groupsInGroup, false);
		for(ThreadGroup g : groupsInGroup){
			if(g != null)	printThread(g, depth + 1);
		}
	}
}