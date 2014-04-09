package ch20.ex20_03;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class ch20_03 {
	public static void main(String[] args) throws IOException {
		byte key = (byte) (Math.random() * 256 - 128);
		byte[] test_data = "My name is HANEDA".getBytes();
		DecryptInputStream dis = new DecryptInputStream(new ByteArrayInputStream(test_data), key);
		EncryptOutputStream eos = new EncryptOutputStream(new ByteArrayOutputStream(), key);
		
		System.out.println("オリジナル文章 : \t" + ByteToString(test_data));
		dis.read(test_data);
		System.out.println("暗号化文章 : \t" + ByteToString(test_data));
		eos.write(test_data);
		System.out.println("復号化文章 : \t" + ByteToString(test_data));
		
		dis.close();
		eos.close();
	}
	
	public static String ByteToString(byte[] bytes){
		String str = "";
		for(byte b: bytes){
			str += (char)b;
		}
		return str;
	}
}
