package ch21.ch21_06;

import java.io.*;

// TODO
public class ch21_06 {
	//ch20_05を複数のファイルで行えるようにし、
	//それを一つずつopenするように作成する。
	//また、FileReaderを使用していたところを
	//FileInputStreamに変更。
	
	public static void main(String[] args) throws IOException {
		String file_name = new File("").getAbsolutePath() + "\\src\\ch20_05\\in.txt";
		String search_word = "test";
		
		InputStreamReader fileIn = new FileReader(file_name);
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
