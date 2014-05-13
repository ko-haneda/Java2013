package ch23.ch23_03;

import java.io.*;

public class ex23_03 {

	public static void exec(String cmd, String stop_command) {
		exec(cmd.split(" "), stop_command);
	}

	public static void exec(String cmd[], String stop_command) {
		try {
			Process proc = Runtime.getRuntime().exec(cmd, null, new File(new File("").getAbsolutePath() + "\\src\\ch23\\ch23_03"));
			InputStream in = proc.getInputStream();
			InputStreamReader r = new InputStreamReader(in);
			LineNumberReader l = new LineNumberReader(r);
			String line;

//プロセスは別起動している。　スリープさせるとその間に処理が完了する。
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e1) {
//				e1.printStackTrace();
//			}
			
			while ((line = l.readLine()) != null) {
				if (line.contains(stop_command)) {
					String[] str = line.split(stop_command);
					if(!str[0].equals("")){
						System.out.printf("%-4d%s\n", l.getLineNumber(), str[0]);
					}
					System.out.println("***** ストップ *****");
					proc.destroy();
					break;
				}
				System.out.printf("%-4d%s\n", l.getLineNumber(), line);
			}
			try {
				if(proc.waitFor() == 0){
					System.out.println("正しく終了できました。");
				}
				else{
					System.err.println("正しく終了できませんでした。");
					System.err.println("終了コード : " + proc.exitValue());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			//readLineのエラーはここでチェック
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
//		String stop_command = "stop";
//		exec(args, stop_command);
		exec("ping localhost", "1ms");
		exec("ping localhost", "0ms");
//		exec("cat in.txt", "test");
	}
}
