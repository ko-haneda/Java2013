package ch20.ex20_06;

import java.io.*;
/*
 * 個人メモ
 * ファイルの内容　**** -1 -a +1 +a =1 =A ****
 * Token[n=-1.0], line 1	 : 数値
 * Token['-'], line 1		 : それ以外
 * Token[a], line 1	 		 : 単語
 * Token['+'], line 1		 : それ以外
 * Token[n=1.0], line 1		 : 数値
 * Token['+'], line 1		 : それ以外
 * Token[a], line 1	 		 : 単語
 * Token['='], line 1		 : それ以外
 * Token[n=1.0], line 1	 	 : 数値
 * Token['='], line 1		 : それ以外
 * Token[A], line 1	 		 : 単語
 * "-"に注意
 */
import java.util.HashMap;

public class ch20_06 {
	public static void main(String[] args) throws IOException {
		String file_name = new File("").getAbsolutePath() + "\\src\\ch20\\ex20_06\\in.txt";
				
		FileReader fileIn = new FileReader(file_name);
		HashMap<String, Double> data = new HashMap<String, Double>();
		data.put("suzuki", 0.0);
		data.put("tanaka", 0.0);
		data.put("haneda", 0.0);
		SumStream(data, fileIn);
		System.out.println("suzuki_score : " + data.get("suzuki"));
		System.out.println("tanaka_score : " + data.get("tanaka"));
		System.out.println("haneda_score : " + data.get("haneda"));
	}

	public static void SumStream(HashMap<String, Double> data, Reader source) throws IOException {
		String name = "";
		String option = "";
		double value = 0.0;
		
		StreamTokenizer in = new StreamTokenizer(source);
		in.wordChars('+', '+');
		in.wordChars('=', '=');
		//一回の繰り返しで3個のトークンを読み取る
		while(in.nextToken() != StreamTokenizer.TT_EOF){
			/* *******************単語******************* */
			if(in.ttype == StreamTokenizer.TT_WORD){
				name = in.sval;
			}
			else{
				System.out.println("①入力に誤りがあります。{name op value}");	
				break;
			}
			
			/* *******************オプション******************* */
			in.ordinaryChar('-');	//一度通常文字に直さないといけないらしい
			in.wordChars('-', '-');
			in.nextToken();
			if(in.ttype == StreamTokenizer.TT_WORD){
				option = in.sval;
			}
			else{
				System.out.println(in + ":" + in.sval);
				System.out.println("②入力に誤りがあります。{name op value}");
				break;
			}
			in.parseNumbers();
			
			/* *******************値******************* */
			in.nextToken();
			if(in.ttype == StreamTokenizer.TT_NUMBER){
				value = in.nval;
			}
			else{
				System.out.println("③入力に誤りがあります。{name op value}");
				break;
			}
			
			/* *******************ここから値をセットしていく******************* */
			if(data.get(name) == null){
				System.out.println( name + "という単語は存在しません");
				break;
			}
			double buf_value = data.get(name);
			if(option.equals("+"))		buf_value += value;
			else if(option.equals("-"))	buf_value -= value;
			else if(option.equals("=")) buf_value =  value;
			else{
				System.out.println("optionには+ - = のいずれかを入力してください。");
				break;
			}
			data.put(name, buf_value);
		}
	}
}

