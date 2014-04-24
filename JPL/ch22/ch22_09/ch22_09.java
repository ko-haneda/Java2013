package ch22.ch22_09;

import java.io.*;
import java.util.List;

//TODO 後回し
public class ch22_09 {
	public static void main(String[] args) {
		File file = new File(new File("").getAbsolutePath() + "\\src\\ch22_08\\in.csv");
		List<String[]> list;
		try {
			for(int i = 0; i < 4; i++){
				list = CSV.readCSVTable(new FileReader(file), 4,createExp(i, 4));
				for (String[] strings : list) {
					for(String str : strings){
						System.out.print(str + ",");
					}
					System.out.println();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String createExp(int num, int cells_num){
		StringBuffer str = new StringBuffer();
		
		if(num == 0){
			str.append("^([^,]*?)");
			for(int i = 0; i < cells_num - 1; i++){
				str.append(",([^,]*?)");
			}
			str.append("$");
			return str.toString();
		}
		
		else if(num == 1){
			
			return str.toString();
		}
		
		else if(num == 2){
			
			return str.toString();
		}
		
		else if(num == 3){
			return str.toString();
		}
		
		else {
			return null;
		}
	}
}
