package ch21.ch21_07;

import java.io.*;

//委譲すべき。
//継承した場合、remove等、本来Stackにない機能が使えるようになってしまう。
//※java.util.StackではVectorを継承しているためremove等が使えるようになっているが...
public class ch21_07 {
	public static void main(String[] args) throws IOException {
		MyStack<Integer> stack = new MyStack<Integer>();

		//empty()のテスト
		if(stack.empty())	System.out.println("stackは空です。");
		System.out.println("push : \t" + stack.push(5));
		if(stack.empty())	System.out.println("stackは空です。");
		//pushのテスト
		System.out.println("push : \t" + stack.push(4));
		System.out.println("push : \t" + stack.push(3));
		System.out.println("push : \t" + stack.push(2));
		System.out.println("push : \t" + stack.push(1));
		System.out.println();
		//searchのテスト
		System.out.println("search:\t" + stack.search(5));
		System.out.println("search:\t" + stack.search(3));
		System.out.println("search:\t" + stack.search(1));
		System.out.println("search:\t" + stack.search(6));
		System.out.println();
		//popのテスト①
		System.out.println("pop : \t" + stack.pop());
		System.out.println("pop : \t" + stack.pop());
		System.out.println();
		//peekのテスト
		System.out.println("peek : \t" + stack.peek());
		System.out.println();
		//popのテスト②
		System.out.println("pop : \t" + stack.pop());
		System.out.println("pop : \t" + stack.pop());
		System.out.println("pop : \t" + stack.pop());
		
	}
}
