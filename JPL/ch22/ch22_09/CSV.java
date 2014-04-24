package ch22.ch22_09;

import java.io.*;
import java.util.*;
import java.util.regex.*;


public class CSV {

	public static List<String[]> readCSVTable(Readable source, int cells_num, String exp) throws IOException {
		Scanner in = new Scanner(source);
		List<String[]> vals = new ArrayList<String[]>();
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
				String str = in.nextLine();
				if(str == null){
					in.close();
					throw new IOException("input format error");
				}
			}
		}
		IOException ex = in.ioException();
		in.close();
		if (ex != null)			throw ex;
		return vals;
	}
}
