package ch21.ch21_06;

import java.io.*;

//p.463のConcatではすべてのファイルのストリームを結合している。
//この問題では結合せずにやるということ。
//1度に1つopenしているが、
//1度に1つcloseするようには作成していない。（無理？）
public class ch21_06 {
	public static void main(String[] args) throws IOException {
		StringBuffer files_name = new StringBuffer();
		files_name.append(new File("").getAbsolutePath() + "\\src\\ch21_06\\1.txt,");
		files_name.append(new File("").getAbsolutePath() + "\\src\\ch21_06\\2.txt,");
		files_name.append(new File("").getAbsolutePath() + "\\src\\ch21_06\\3.txt,");
		files_name.append(new File("").getAbsolutePath() + "\\src\\ch21_06\\4.txt");
		
		System.out.println("p463のConcat");
		Concat.concatenate1(files_name.toString().split(","));
		System.out.println();
		System.out.println("独自のConcat");
		Concat.concatenate2(files_name.toString().split(","));
	}
}
