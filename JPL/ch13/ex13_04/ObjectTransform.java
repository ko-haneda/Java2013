package ch13.ex13_04;

import java.util.*;

public class ObjectTransform {
	private List<Object> list = new ArrayList<Object>();
	
	ObjectTransform(String str){
		String[] strs = str.split("\n");
		
		for(String s : strs){
			String[] input = s.split(" ");
			if(input.length != 2)	throw new IllegalArgumentException("type value形式で入力して下さい。");
			if(input[0].equals("Byte"))				list.add(new Byte(input[1]));
			else if(input[0].equals("Short"))		list.add(new Short(input[1]));
			else if(input[0].equals("Integer"))		list.add(new Integer(input[1]));
			else if(input[0].equals("Long"))		list.add(new Long(input[1]));
			else if(input[0].equals("Float"))		list.add(new Float(input[1]));
			else if(input[0].equals("Double"))		list.add(new Double(input[1]));
			else if(input[0].equals("Character"))	list.add(new Character(input[1].charAt(0)));
			else if(input[0].equals("Boolean"))		list.add(new Boolean(input[1]));
			else									throw new IllegalArgumentException("valueが不正です。");
		}
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for(Object obj : list){
			sb.append(obj);
			sb.append("(");
			String class_name = obj.getClass().toString();
			sb.append(class_name.substring(16));
			sb.append(")");
			sb.append("\n");
		}
		return sb.toString();
	}
}
