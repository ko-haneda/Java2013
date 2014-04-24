package ch22.ch22_11;

import java.io.*;
import java.util.*;

public class CSV {

	final int MAXSIZE = 100;
	public static List<String[]> readCSVTable(Reader source, int cells_num) throws IOException {
		StreamTokenizer in = new StreamTokenizer(source);
		List<String[]> list = new ArrayList<String[]>();
		String[] cells = new String[cells_num];
		int index = 0;
		
		in.whitespaceChars(',', ','); // ,を区切りにする
		in.commentChar('#');
		in.eolIsSignificant(true);
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			if(in.ttype == '\n'){
				if(index == cells_num){
					list.add(cells);
				}
				index = 0;
			}
			if(in.ttype == StreamTokenizer.TT_WORD){
				if(index < cells_num){
					cells[index] = in.sval;
				}
				index++;
			}
		}
		return list;
	}
}
