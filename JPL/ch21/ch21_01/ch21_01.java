package ch21.ch21_01;

import java.io.*;

public class ch21_01 {
	public static void main(String[] args) throws IOException {
		String test_data = "AA\nCC\nRR\nGG\nKK\nBB";
		SubFilterReader sfr = new SubFilterReader(new StringReader(test_data));
		String str;
		SortList sort_list = new SortList();
		
		System.out.println("オリジナル文章");
		while((str = sfr.readLine()) != null){
			System.out.println(str);
			sort_list.add(str);
		}
		System.out.println("ソート済み文章");
		System.out.println(sort_list);
		sfr.close();
	}
}
