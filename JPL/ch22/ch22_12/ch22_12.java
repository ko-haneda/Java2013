package ch22.ch22_12;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

public class ch22_12 {
	
	public static void main(String[] args) {
		File file = new File(new File("").getAbsolutePath() + "\\src\\ch22_12\\in.txt");
		Attributed<Double> list;
		try {
			//StreamTokenizerの場合
			list = readAttrsST(new FileReader(file));
			for(Iterator i = list.attrs(); i.hasNext();){
				System.out.println(i.next());
			}
			System.out.println("------------------------");
			//Scan
			list = readAttrsScanner(new FileReader(file));
			for(Iterator i = list.attrs(); i.hasNext();){
				System.out.println(i.next());
			}
			System.out.println("------------------------");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//TODO 問題の題意はPattern.compile("^(.*?)=(.*?)$, Pattern.MULTILINE)のようなことをいっているかも・・・（時間があまれば書き換える）
	public static Attributed readAttrsScanner(Reader source) throws IOException{
		Scanner in = new Scanner(source);
		AttributedImpl<?> attrs = new AttributedImpl<>();
		Attr attr = null;
		while(in.hasNext()){
			if(attr != null){
				attr.setValue(in.next());
				attr = null;
			}
			else{
				attr = new Attr(in.next());
				attrs.add(attr);
			}
		}
		return attrs;	
	}
	
	public static Attributed readAttrsST(Reader source) throws IOException{
		StreamTokenizer in = new StreamTokenizer(source);
		AttributedImpl<?> attrs = new AttributedImpl<>();
		Attr attr = null;
		in.commentChar('#');
		in.ordinaryChar('/');
		while(in.nextToken()!= StreamTokenizer.TT_EOF){
			if(in.ttype == StreamTokenizer.TT_WORD){
				if(attr != null){
					attr.setValue(in.sval);
					attr = null;
				}
				else{
					attr = new Attr(in.sval);
					attrs.add(attr);
				}
			}
			else if(in.ttype == '='){
				if(attr == null)			throw new IOException();
			}
			else{
				if(attr == null)	throw new IOException();
				attr.setValue(new Double(in.nval));
				attr = null;
			}
		}
		return attrs;	
	}
}
