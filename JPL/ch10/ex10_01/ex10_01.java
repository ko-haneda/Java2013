package ch10.ex10_01;

public class ex10_01 {
	public static void main(String[] args) {
		String str = "AB\nCD\tEF\bGH\rIH\fJK\\KM\'NO\"PQ";
		System.out.println("変換前");
		System.out.println(str);
		System.out.println("変換後");
		System.out.println(JavaCode(str));

	}

	public static String JavaCode(String inStr){
//		str = str.replaceAll("\n", "\\\n");
//		str = str.replaceAll("\t", "\\\t");
//		str = str.replaceAll("\b", "\\\b");
//		str = str.replaceAll("\r", "\\\r");
//		str = str.replaceAll("\f", "\\\f");
//		str = str.replaceAll("\\", "\\\\");
//		str = str.replaceAll("\'", "\\\'");
//		str = str.replaceAll("\"", "\\\"");
		String outStr = "";
		for(int i = 0; i < inStr.length(); i++){
			char ch = inStr.charAt(i);
			if(ch == '\n')		outStr += "\\n";
			else if(ch == '\t')	outStr += "\\t";
			else if(ch == '\b')	outStr += "\\b";
			else if(ch == '\r')	outStr += "\\r";
			else if(ch == '\f')	outStr += "\\f";
			else if(ch == '\\')	outStr += "\\\\";
			else if(ch == '\'')	outStr += "\\\'";
			else if(ch == '\"')	outStr += "\\\"";
			else				outStr += ch;
		}
		return outStr;
	}
}