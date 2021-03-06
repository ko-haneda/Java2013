package ch23.ch23_01;

import java.io.*;

/*
 * Run ConfigurationsのCommonを変更
 * デフォルト：utf-16
 * Other:MS932
 * MS932を指定
 * */
/*
 * コマンド ping localhostを実行した場合
 * getOutputStream()がどこを意味しているのかわからない。
 * plugTogether(System.in, proc.getOutputStream()); // ①
 * 
 * また、getErrorStream()でのエラー表示の方法がわからない。
 *　コマンドエラーの場合はexec()でエラー出力してしまう。
 * plugTogether(System.err, proc.getErrorStream()); // ②
 * 
 * */
public class ex23_01 extends Thread {

	InputStream in;
	OutputStream out;

	ex23_01(InputStream in, OutputStream out) {
		this.in = in;
		this.out = out;
	}

	public static void main(String[] args) {
		try {
			userProg("cat in.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Process userProg(String cmd) throws IOException {
		Process proc = Runtime.getRuntime().exec(cmd, null, new File(new File("").getAbsolutePath() + "\\src\\ch23\\ch23_01"));
		plugTogether(System.in, proc.getOutputStream()); // ①
		plugTogether(System.out, proc.getInputStream()); // ②
		plugTogether(System.err, proc.getErrorStream()); // ②
		return proc;
	}

	// ①
	public static void plugTogether(InputStream in, OutputStream out) {
		new ex23_01(in, out).start();
	}

	// ②
	public static void plugTogether(OutputStream out, InputStream in) {
		new ex23_01(in, out).start();
	}

	public void run() {
		int b;
		try {
			char[] exit = {' ', ' ', ' ', ' '}; 
			while ((b = in.read()) != -1) {
				for(int i = 0; i < exit.length - 1; i++){
					exit[i] = exit[i + 1];
				}
				exit[3] = (char)b;
				//System.inにおいて、"exit"を入力したら終了としたいが、"exi"までwriteしてしまうから良くない　とりあえずのテスト用
				if(new String(exit).equals("exit"))	break;	
				out.write((char)b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
