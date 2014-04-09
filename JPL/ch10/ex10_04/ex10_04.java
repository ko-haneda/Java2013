package ch10.ex10_04;

//ex01_13をdo-while文に置き換える。
//ex10_2をdo-while文に置き換える。
public class ex10_04 {
	public static void main(String[] args) {
		ex01_13Main();
		ex10_2Main();
		//ともにwhile文に書きなおすことができる。
		//ただし、ex01_13では長さが10としているため、うまくいくが、
		//ex10_2のように長さが特別決まっていない場合、問題が起こる可能性がある。
		//問題が起きるときはStringの長さが0の場合である。
		//do-whileではなくwhile文で行えば問題はない。
		}
	public static void ex01_13Main(){
		fibonacci_info array[] = new fibonacci_info[10];
		int lo = 1;
		int hi = 1;
		for (int i = 0; i < array.length; i++){
			array[i] = new fibonacci_info();
		}
		array[0].set_value(lo);
		int i = 1;
		do{
			array[i].set_value(hi);
			hi = lo + hi;
			lo = hi - lo;
			i++;
		}while(i < array.length);
		for (int j = 0; j < array.length; j++) {
			System.out.printf("%d : %d%s\n", j, array[j].value, array[j].even ? " *" : "");
		}
	}
	public static void ex10_2Main(){
		String str = "AB\nCD\tEF\bGH\rIH\fJK\\KM\'NO\"PQ";
		System.out.println("変換前");
		System.out.println(str);
		System.out.println("変換後");
		System.out.println(JavaCode(str));
	}
	public static String JavaCode(String inStr){
		int i = 0;
		String outStr = "";
		do{
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
			i++;
		}while(i < inStr.length());
		return outStr;
	}
}

class fibonacci_info{
	int value;
	boolean even;

	public void set_value(int value) {
		this.value = value;
		if (this.value % 2 == 0)
			this.even = true;
		else
			this.even = false;
	}
}