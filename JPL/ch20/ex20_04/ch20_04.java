package ch20.ex20_04;

import java.io.*;


public class ch20_04 {
	public static void main(String[] args) throws IOException {
		String test_data = "My\nname\ris\nHANEDA";
		SubFilterReader sfr = new SubFilterReader(new StringReader(test_data));
		
		String str;
		while((str = sfr.readLine()) != null){
			System.out.println(str);
		}
		sfr.close();
	}
}
