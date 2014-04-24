package ch22.ch22_11;

import java.io.*;
import java.util.List;

public class ch22_11 {
	
	public static void main(String[] args) {
		File file = new File(new File("").getAbsolutePath() + "\\src\\ch22_11\\in.csv");
		List<String[]> list;
		try {
			list = CSV.readCSVTable(new FileReader(file), 2);
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
