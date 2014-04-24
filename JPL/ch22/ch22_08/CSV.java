package ch22.ch22_08;

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
	/*----------------------------------------------------------------
	 * 
	 * 教科書p.286を参照！！　疑問に思っていたことが全て書かれている。
	 * 
	 * ---------------------------------------------------------------*/
	
	//line.split(,).size と cells_numを比較する方法は問題の題意とは異なるのでNG?
	//正規表現で行うのが正しい？？
	public static List<String[]> readCSVTable(Readable source, int cells_num) throws IOException {
		Scanner in = new Scanner(source);
		List<String[]> vals = new ArrayList<String[]>();
		//"^([^,]*?)(,([^,]*?)){" + (cells_num - 1) + "}$"でなぜできないのかわからない。
		StringBuilder exp = new StringBuilder("^([^,]*?)"); //ネットに書いてあった通りやってみたらできた。よく理解できていない。あとで見返す。　"^(.*)"でなぜだめ？二回目の^は否定で使われている？
		for(int i = 0; i < cells_num - 1; i++){
			exp.append(",([^,]*?)");
		}
		exp.append("$");
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
