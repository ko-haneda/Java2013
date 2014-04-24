package ch22.ch22_07;

import java.io.*;
import java.util.*;
import java.util.regex.*;


public class CSV {

	static final int CELLS = 4;
	
	public static List<String[]> readCSVTable(Readable source) throws IOException {
		Scanner in = new Scanner(source);
		List<String[]> vals = new ArrayList<String[]>();
		String exp = "^(.*),(.*),(.*),(.*)";
		Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);
		
		while (in.hasNextLine()) {
			String line = in.findInLine(pat);
			if (line != null) {
				String[] cells = new String[CELLS];
				MatchResult match = in.match();
				for (int i = 0; i < CELLS; i++){
					cells[i] = match.group(i + 1);
				}
				vals.add(cells);
				in.nextLine();
			}
			else {
				in.close();
				throw new IOException("input format error");
			}
		}
		IOException ex = in.ioException();
		in.close();
		if (ex != null)			throw ex;
		return vals;
	}

	public static List<String[]> readCSVTable(Readable source, int cells_num) throws IOException {
		Scanner in = new Scanner(source);
		List<String[]> vals = new ArrayList<String[]>();
		StringBuilder exp = new StringBuilder("^(.*)");
		for (int cell = 1; cell < cells_num; cell++) {
			exp.append(",(.*)");
		}
		Pattern pat = Pattern.compile(exp.toString(), Pattern.MULTILINE);
		while (in.hasNextLine()) {
			String line = in.findInLine(pat);
			if (line != null) {
				String[] cells = new String[cells_num];
				MatchResult match = in.match();
				for (int i = 0; i < cells_num; i++){
					cells[i] = match.group(i + 1);
				}
				vals.add(cells);
				in.nextLine();
			}
			else {
				in.close();
				throw new IOException("input format error");
			}
		}
		IOException ex = in.ioException();
		in.close();
		if (ex != null)			throw ex;
		return vals;
	}
}
