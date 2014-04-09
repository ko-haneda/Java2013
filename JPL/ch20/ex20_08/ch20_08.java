package ch20.ex20_08;

import java.io.*;
import java.util.*;

public class ch20_08 {

	public static void main(String[] args) {
		RandomAccessFile raf;
		ArrayList<Long> table = new ArrayList<Long>();
		try {
			raf = new RandomAccessFile(new File("").getAbsolutePath() + "\\src\\ch20\\ex20_08\\in.txt", "r");
			String line;
			long point = raf.getFilePointer();
			while ((line = raf.readLine()) != null) {
				if (line.startsWith("%%")) {
					table.add(point);	//一つ前の値を取得する必要がある。
				}
				point = raf.getFilePointer();
			}

			Random rd = new Random();
			int size = table.size();
			for (int i = 0; i < size - 1; i++) {
				raf.seek(table.remove(rd.nextInt(table.size() - 1)));
				System.out.println(raf.readLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

