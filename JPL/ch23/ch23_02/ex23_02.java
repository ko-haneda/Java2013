package ch23.ch23_02;

import java.io.*;

public class ex23_02 {

	public static void exec(String cmd){
		exec(cmd.split(" "));
	}
	
	public static void exec(String cmd[]) {
		try {
			Process proc = new ProcessBuilder(cmd).redirectErrorStream(true).start();
			InputStream in = proc.getInputStream();
			InputStreamReader r = new InputStreamReader(in);
			LineNumberReader l = new LineNumberReader(r);

			String line;
			while ((line = l.readLine()) != null) {
				System.out.printf("%-4d%s\n", l.getLineNumber(), line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		exec("ping localhost");
	}
}
