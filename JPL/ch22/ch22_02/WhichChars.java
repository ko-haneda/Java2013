package ch22.ch22_02;

import java.util.*;

public class WhichChars {
	private Set<Character> used = new HashSet<Character>();

	public WhichChars(String str) {
		for (int i = 0; i < str.length(); i++) {
			used.add(str.charAt(i));
		}
	}

	public String toString() {
		String desc = "[";
		for (Character c : used) {
			desc += c;
		}
		return desc + "]";
	}
}
