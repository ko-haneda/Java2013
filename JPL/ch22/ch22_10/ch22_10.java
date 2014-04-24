package ch22.ch22_10;

import java.io.*;
import java.util.Scanner;

public class ch22_10 {
	public static void main(String[] args) {
		File file = new File(new File("").getAbsolutePath() + "\\src\\ch22_10\\in.csv");
		try {
			readCSVTable(new FileReader(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readCSVTable(Readable source) throws IOException {
		Scanner in = new Scanner(source);
		in.useDelimiter("\\s|#.*"); 
		while (in.hasNext()) {
			String str = in.next();
			if(!str.equals(""))	System.out.println(str);
		}
		in.close();
	}
}
