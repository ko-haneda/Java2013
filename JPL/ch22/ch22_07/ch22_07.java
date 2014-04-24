package ch22.ch22_07;

import java.io.*;
import java.util.List;

public class ch22_07 {
	//CSVファイルが５つ以上の値をもっている状況で
	//CSV.readCSVTable(file, 4);で取得できてしまうのは仕様。

	//CSVファイルが４つ値をもっている状況で
	//CSV.readCSVTable(file, 1);と
	//CSV.readCSVTable(file, 4);では同じ出力結果であることを仕様。
	
	//上記の問題の解決はch22_08の課題
	
	public static void main(String[] args) {
		File file = new File(new File("").getAbsolutePath() + "\\src\\ch22_07\\in.csv");
		List<String[]> list;
		try {
			list = CSV.readCSVTable(new FileReader(file), 4);
			for (String[] strings : list) {
				for(String str : strings){
					System.out.print(str + "\t");
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
