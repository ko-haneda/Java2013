package ch21.ch21_01;

import java.io.*;

public class SubFilterReader extends FilterReader{

	public SubFilterReader(Reader r) {
		super(r);
	}
	
	public String readLine() throws IOException{
		String str = "";
		int ch;
		
		while((ch = read()) != -1 && ch != '\n' && ch != '\r'){
			str += (char)ch;
		}
		if(str.equals(""))	return null;
		else				return str;
	}
}
