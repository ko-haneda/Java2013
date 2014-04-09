package ch07.ex07_03;

public class ex07_03 {

	public static void main(String[] args) {
		Pascal a = new Pascal(12);
		System.out.println(a.toStirng());
		System.out.println();
		Pascal b = new Pascal(7);
		System.out.println(b.toStirng());
	}
}

class Pascal{
	private int[][]val;

	Pascal(int N) {
		this.val = new int[N][];

		for (int i = 0; i < this.val.length; i++) {
			this.val[i] = new int[i + 1]; 
			for (int j = 0; j < i + 1; j++) {
				if (i - j == 0 || j == 0)	this.val[i][j] = 1;
				else						this.val[i][j] = this.val[i-1][j-1] + this.val[i-1][j];
			}
		}
	}
	
	public String toStirng(){
		String str = "";
		for (int i = 0; i < this.val.length; i++) {
			for (int j = 0; j < i + 1; j++) {
				str += this.val[i][j];
				str += "\t";
			}
			str += "\n";
		}
		return str;
	}
}