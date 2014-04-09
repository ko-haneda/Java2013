package ch01.ex01_14;

class WalkmanBase {
	private boolean terminalA;

	public void listen_to() {
		if (this.terminalA)
			System.out.println("A端子で音楽を楽しむ");
		else
			System.out.println("A端子が繋がっていない");
	}

	public void on_terminalA() {
		this.terminalA = true;
	}

	public void off_terminalA() {
		this.terminalA = false;
	}

	public boolean get_state() {
		return this.terminalA;
	}
}

class Walkman extends WalkmanBase {
	private boolean terminalB;

	public void listen_to() {
		super.listen_to();
		if (this.terminalB)
			System.out.println("B端子で音楽を楽しむ");
		else
			System.out.println("B端子が繋がっていない");

		if (super.get_state() && this.terminalB) {
			System.out.println("音楽を聞きながら会話もできる。");
		}
	}

	public void on_terminalB() {
		this.terminalB = true;
	}

	public void off_terminalB() {
		this.terminalB = false;
	}
}

public class ex01_14 {
	public static void main(String[] args) {
		Walkman newModel = new Walkman();

		newModel.listen_to();
		System.out.println();

		newModel.on_terminalA();
		newModel.listen_to();
		System.out.println();

		newModel.on_terminalB();
		newModel.listen_to();
		System.out.println();

		newModel.off_terminalA();
		newModel.listen_to();
		System.out.println();

	}
}