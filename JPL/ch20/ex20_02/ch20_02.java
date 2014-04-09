package ch20.ex20_02;

import java.io.*;

public class ch20_02 {
	public static void main(String[] args) {
		int b;
		byte from = (byte) 'b';
		byte to = (byte) 'B';
		String test_data = "abracadabra!";
	    try {
			//ByteArray
	    	System.out.println("********ByteArray********");
			TranslateByte tb1 = new TranslateByte(new ByteArrayInputStream(test_data.getBytes()), from, to);
			while((b = tb1.read()) != -1){
				System.out.print(b == from ? (char)to : (char)b);
			}
			System.out.println();
			
			//File	
			System.out.println("********File********");
			TranslateByte tb2 = new TranslateByte(new FileInputStream(new File("").getAbsolutePath() + "\\src\\ch20\\ex20_01\\in.txt"), from, to);
//			while((b = tb2.read()) != -1){
//				System.out.print(b == from ? (char)to : (char)b);
//			}
//			System.out.println();
			byte[]result = test_data.getBytes();
			System.out.println(tb2.read(result));
			for(byte c : result){
				System.out.print((char)c);
			}
			System.out.println();

			//Object
			//ObjectOutputStreamがなぜかエラー newできない
			
			//Piped		省略
	    	//Fileter	省略
			
			tb1.close();
			tb2.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("ファイルが存在しません");
		} catch (IOException e) {
			System.out.println(e);
		}
	    //closeメソッドは省略
	}
}
