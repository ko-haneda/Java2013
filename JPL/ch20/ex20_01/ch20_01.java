package ch20.ex20_01;
import java.io.*;

public class ch20_01 {
	public static void translate(InputStream in, OutputStream out, byte from, byte to) throws IOException {
		int  b;
		while((b = in.read()) != -1){
			out.write(b == from ? to : b);
			System.out.print(b == from ? (char)to : (char)b);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		byte from = (byte) 'b';
		byte to = (byte) 'B';
		String test_data = "abracadabra!";
	    try {
			//ByteArray
	    	System.out.println("********ByteArray********");
			InputStream in1 = new ByteArrayInputStream(test_data.getBytes());
			OutputStream out1 = new ByteArrayOutputStream();
			translate(in1, out1, from, to);
			
			//File	
			System.out.println("********File********");
	    	InputStream in2 = new FileInputStream(new File("").getAbsolutePath() + "\\src\\ch20\\ex20_01\\in.txt");
			OutputStream out2 = new FileOutputStream(new File("").getAbsolutePath() + "\\src\\ch20\\ex20_01\\out.txt");
			translate(in2, out2, from, to);

			//Object
			//ObjectOutputStreamがなぜかエラー newできない
			
			//Piped		省略
	    	//Fileter	省略
			
		} catch (FileNotFoundException e) {
			System.out.println("ファイルが存在しません");
		} catch (IOException e) {
			System.out.println(e);
		}
	    //closeメソッドは省略
	}
}
