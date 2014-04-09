package ch20.ex20_10;

import java.io.*;
import java.util.*;

public class ch20_10 {

	public static void main(String[] args) {
		FileReader fr = null;
		StreamTokenizer in = null;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		try {
			fr = new FileReader(new File("").getAbsolutePath() + "\\src\\ch20\\ex20_10\\in.txt");
			in = new StreamTokenizer(fr);
			in.whitespaceChars('.', '.');	//区切り文字とする。単語の一部となってしまうため。※','はデフォルトで区切り文字になっている。
			int type;
			while ((type = in.nextToken()) != StreamTokenizer.TT_EOF) {
				if (type == StreamTokenizer.TT_WORD) {
					if (map.containsKey(in.sval)) {
						map.put(in.sval, map.get(in.sval) + 1);
					} else {
						map.put(in.sval, 1);
					}
				}
			}
			//表示（出力）
			for (String word : map.keySet()) {
				for(;word.length() < 15;)	word += " ";
				System.out.println(word + " : " + map.get(word.trim()));
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
