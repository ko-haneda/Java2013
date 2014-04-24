package ch22.ch22_03;

import java.util.*;

public class WhichChars {
	private Map<Byte, BitSet> hm = new HashMap<Byte, BitSet>();

	public WhichChars(String str) {
		for (int i = 0; i < str.length(); i++) {
			byte b = (byte)(str.charAt(i) >>> 8);
			BitSet bs = hm.get(b);
			if (bs == null) {
				bs = new BitSet();
				bs.set(str.charAt(i) & 0x00FF);
				hm.put(b, bs);
			}
			bs.set(str.charAt(i) & 0x00FF);
		}
	}

	public String toString() {
		String desc = "[";
		for (Byte key : hm.keySet()) {
			BitSet bs = hm.get(key);
			for(int i = bs.nextSetBit(0); i >= 0; i = bs.nextSetBit(i + 1)){
				desc += (char)((key << 8) +  i);
			}
		}
		return desc + "]";
	}
}
