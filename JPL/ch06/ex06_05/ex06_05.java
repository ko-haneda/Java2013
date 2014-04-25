package ch06.ex06_05;

public class ex06_05 {
	public static void main(String[] args) {
		TraficSignal2 traficSignal = TraficSignal2.RED;
		System.out.println(traficSignal.getColor1().colorName);
	}
}

enum TraficSignal2 {
	BLUE(new Color1("BLUE")) {
		Color1 getColor1() {
			return color;
		}
	},
	YELLOW(new Color1("YELLOW")) {
		Color1 getColor1() {
			return color;
		}
	},
	RED(new Color1("RED")) {
		Color1 getColor1() {
			return color;
		}
	};

	Color1 color;

	private TraficSignal2(Color1 color) {
		this.color = color;
	}

	abstract Color1 getColor1();
}

class Color1 {
	String colorName;

	public Color1() {
		colorName = "BLUE";
	}

	public Color1(String colorName) {
		this.colorName = colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getColorName() {
		return colorName;
	}
}