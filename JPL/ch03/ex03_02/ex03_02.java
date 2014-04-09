package ch03.ex03_02;

class X {
	protected int xMask = 0xff00;
	protected int fullMask;

	public X() {
		fullMask = xMask;
	}

	public int mask(int orig) {
		return (orig & fullMask);
	}
}

class Y extends X {
	protected int yMask = 0x00ff;

	public Y() {
		fullMask |= yMask;
	}
}

public class ex03_02 {
	public static void main(String[] args) {
		X val1 = new X();
		Y val2 = new Y();
		
		System.out.printf("%x, %x", val1.fullMask, val2.fullMask);
	}
}
