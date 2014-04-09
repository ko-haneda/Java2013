package ch20.ex20_05;

import java.io.*;


public class ch20_05 {
	public static void main(String[] args) throws IOException {
		String file_name = new File("").getAbsolutePath() + "\\src\\ch20\\ex20_05\\in.txt";
		String search_word = "test";
				
		FileReader fileIn = new FileReader(file_name);
		LineNumberReader in = new LineNumberReader(fileIn);
		String str;
		while((str = in.readLine()) != null){
			if(str.indexOf(search_word) != -1){
				System.out.println(in.getLineNumber() + "行目\t:" + str);
			} 
		}
		in.close();
	}
}
