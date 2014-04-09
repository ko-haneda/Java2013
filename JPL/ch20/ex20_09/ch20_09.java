package ch20.ex20_09;

import java.io.File;

public class ch20_09 {
	public static void main(String[] args) {
		showFileInfo();
		showFileInfo(new File("").getAbsolutePath() + "\\src\\ch20\\ex20_09\\in.txt", new File("").getAbsolutePath() + "\\src\\ch20\\ex20_09\\out.txt");
	}

	public static void showFileInfo(String... path) {
		if (path.length == 0) {
			System.out.println("パス名は１つ以上入力してください");
			return;
		}
		for(String p : path){
			File f = new File(p);
			System.out.println("**************************************");
			System.out.println(f.getAbsolutePath());

			if(f.exists()){
				System.out.println("ファイル名" + f.getName());
				System.out.printf ("更新日時%1$tD %1$tT%n", f.lastModified());
				System.out.printf ("サイズ%dバイト%n", f.length());
			}
			else{
				System.out.println(p + "というファイルは存在しません。");
			}
			System.out.println("**************************************");
			System.out.println();
		}
	}
}