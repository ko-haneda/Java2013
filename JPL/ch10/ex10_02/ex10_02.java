package ch10.ex10_02;

public class ex10_02 {
	public static void main(String[] args) {
		String str = "AB\nCD\tEF\bGH\rIH\fJK\\KM\'NO\"PQ";
		System.out.println("変換前");
		System.out.println(str);
		System.out.println("変換後");
		System.out.println(JavaCode(str));

	}

	public static String JavaCode(String inStr){
		String outStr = "";
		for(int i = 0; i < inStr.length(); i++){
			char ch = inStr.charAt(i);
			switch(ch){
				case('\n'):	outStr += "\\n";	break;
				case('\t'):	outStr += "\\t";	break;
				case('\b'):	outStr += "\\b";	break;
				case('\r'):	outStr += "\\r";	break;
				case('\f'):	outStr += "\\f";	break;
				case('\\'):	outStr += "\\\\";	break;
				case('\''):	outStr += "\\\'";	break;
				case('\"'):	outStr += "\\\"";	break;
				default:	outStr += ch;		break;
			}
		}
		return outStr;
	}
}