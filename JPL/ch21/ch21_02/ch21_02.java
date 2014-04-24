package ch21.ch21_02;
import java.io.*;

public class ch21_02 {
	public static void main(String[] args) {
		System.out.println("ガーベッジコレクションを呼び出さない場合");
		comparePerformance(false);
		System.out.println("********************************");
		System.out.println("ガーベッジコレクションを呼び出す場合");
		comparePerformance(true);
	}
	public static void comparePerformance(boolean flag){
		DataHandler dh = new DataHandler();
		byte[] bytes;

		bytes = dh.readFile(new File(new File("").getAbsolutePath() + "\\src\\ch21_02\\in.txt"));
		for(byte b : bytes)		System.out.print((char)b);
		System.out.println();
		if(flag)	Runtime.getRuntime().gc();
		bytes = dh.readFile(new File(new File("").getAbsolutePath() + "\\src\\ch21_02\\in.txt"));
		for(byte b : bytes)		System.out.print((char)b);
		System.out.println();
	}
}
