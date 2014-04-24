package ch22.ch22_08;

import java.io.*;
import java.util.List;

public class ch22_08 {
	public static void main(String[] args) {
		File file = new File(new File("").getAbsolutePath() + "\\src\\ch22_08\\in.csv");
		List<String[]> list;
		try {
			System.out.println("２つの値");
			list = CSV.readCSVTable(new FileReader(file), 2);
			for (String[] strings : list) {
				for(String str : strings){
					System.out.print(str + "\t");
				}
				System.out.println();
			}
			
			System.out.println("５つの値");
			list = CSV.readCSVTable(new FileReader(file), 5);
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
