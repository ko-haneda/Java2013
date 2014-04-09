package ch20.ex20_11;

import java.io.File;

/**
 * 個人メモ
 * 接尾語とは拡張子のこと？
 * ここでは拡張子前のファイル名の接尾語を取得
 */
public class ch20_11 {
	public static void main(String[] args) {
		File file = new File(new File("").getAbsolutePath() + "\\src\\ch20\\ex20_11\\dir");
		String[] files = file.list(new SuffixFilter("able"));
		for (String fileName : files) {
			System.out.println(fileName);
		}
	}
}