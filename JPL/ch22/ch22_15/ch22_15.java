package ch22.ch22_15;

import java.util.Stack;

//TODO 全てのStrictMathの機能をテストすること。
public class ch22_15 {

	//逆ポーランド記法による入力をうけつける。
	public static void main(String[] args) {
		System.out.println(calc("11 2 + 3 4 + +"));	//(11 + 2) + (3 + 4)
		System.out.println(calc("90 toRadians sin 0 toRadians cos +"));//sin(90度)+cos(0度)
//		System.out.println(calc(""));
//		System.out.println(calc(""));
//		System.out.println(calc(""));
//		System.out.println(calc(""));
//		System.out.println(calc(""));
//		System.out.println(calc(""));
//		System.out.println(calc(""));
//		System.out.println(calc(""));
//		System.out.println(calc(""));
	}

	private static double calc(String s) { 
		Stack<Double> stack = new Stack<Double>();
		String[] strs = s.split(" ");
		for(String str : strs){
			if(str.equals("+"))				stack.push(stack.pop() + stack.pop());		//
			else if(str.equals("-"))		stack.push(stack.pop() - stack.pop());		//
			else if(str.equals("*"))		stack.push(stack.pop() * stack.pop());		//
			else if(str.equals("/"))		stack.push(stack.pop() / stack.pop());		//
			else if(str.equals("sin"))		stack.push(StrictMath.sin(stack.pop()));	//
			else if(str.equals("cos"))		stack.push(StrictMath.cos(stack.pop()));	//
			else if(str.equals("tan"))		stack.push(StrictMath.tan(stack.pop()));
			else if(str.equals("asin"))		stack.push(StrictMath.asin(stack.pop()));
			else if(str.equals("acos"))		stack.push(StrictMath.acos(stack.pop()));
			else if(str.equals("atan"))		stack.push(StrictMath.atan(stack.pop()));
			else if(str.equals("atan2"))	stack.push(StrictMath.atan2(stack.pop(), stack.pop()));//
			else if(str.equals("toRadians"))stack.push(StrictMath.toRadians(stack.pop()));
			else if(str.equals("toDegrees"))stack.push(StrictMath.toDegrees(stack.pop()));
			else if(str.equals("exp"))		stack.push(StrictMath.exp(stack.pop()));
			else if(str.equals("sinh"))		stack.push(StrictMath.sinh(stack.pop()));
			else if(str.equals("cosh"))		stack.push(StrictMath.cosh(stack.pop()));
			else if(str.equals("tanh"))		stack.push(StrictMath.tanh(stack.pop()));
			else if(str.equals("pow"))		stack.push(StrictMath.pow(stack.pop(), stack.pop()));
			else if(str.equals("log"))		stack.push(StrictMath.log(stack.pop()));
			else if(str.equals("log10"))	stack.push(StrictMath.log10(stack.pop()));
			else if(str.equals("sqrt"))		stack.push(StrictMath.sqrt(stack.pop()));
			else if(str.equals("cbrt"))		stack.push(StrictMath.cbrt(stack.pop()));
			else if(str.equals("signum"))	stack.push(StrictMath.signum(stack.pop()));
			else if(str.equals("ceil"))		stack.push(StrictMath.ceil(stack.pop()));
			else if(str.equals("floor"))	stack.push(StrictMath.floor(stack.pop()));
			else if(str.equals("rint"))		stack.push(StrictMath.rint(stack.pop()));
			else if(str.equals("round"))	stack.push((double)Math.round(stack.pop()));
			else if(str.equals("abs"))		stack.push(StrictMath.abs(stack.pop()));
			else if(str.equals("max"))		stack.push(StrictMath.max(stack.pop(), stack.pop()));
			else if(str.equals("min"))		stack.push(StrictMath.min(stack.pop(), stack.pop()));
			else if(str.equals("hypot"))	stack.push(StrictMath.hypot(stack.pop(), stack.pop()));
			else							stack.push(Double.parseDouble(str));
		}
		return (double)stack.pop(); 
	}
}
