package ch17.ex17_02;

import java.io.*;

public class ch17_02 {
	public static void main(String[] args) {
		DataHandler dh = new DataHandler();
		byte[] bytes;
		//readFile1はlastfileをソフトに保存
		System.out.println("***********************修正前***********************");
		bytes = dh.readFile1(new File(new File("").getAbsolutePath() + "\\src\\ch17_02\\in1.txt"));
		for(byte b : bytes)			System.out.print((char)b);
		Runtime.getRuntime().gc();
		System.out.println();
		bytes = dh.readFile1(new File(new File("").getAbsolutePath() + "\\src\\ch17_02\\in1.txt"));
		for(byte b : bytes)		System.out.print((char)b);
		System.out.println();
		System.out.println("****************************************************");
		System.out.println();
	
		//readFile2はlastfileを弱く保存
		System.out.println("***********************修正後***********************");
		bytes = dh.readFile2(new File(new File("").getAbsolutePath() + "\\src\\ch17_02\\in2.txt"));
		for(byte b : bytes)		System.out.print((char)b);
		Runtime.getRuntime().gc();
		System.out.println();
		bytes = dh.readFile2(new File(new File("").getAbsolutePath() + "\\src\\ch17_02\\in2.txt"));
		for(byte b : bytes)		System.out.print((char)b);
		System.out.println();
		System.out.println("****************************************************");

	}
}
