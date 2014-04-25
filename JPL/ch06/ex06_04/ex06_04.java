package ch06.ex06_04;

public class ex06_04 {
	public static void main(String[] args) {
		TraficSignal1 e_Signal = TraficSignal1.RED;
		System.out.println(e_Signal.color.getColorName());
	}
}

enum TraficSignal1 {
	BLUE(new Color("BLUE")),
	YELLOW(new Color("YELLOW")),
	RED(new Color("RED"));

	Color color;

	private TraficSignal1(Color color) {
		this.color = color;
	}
}

class Color {
	String colorName;

	public Color() {
		colorName = "BLUE";
	}

	public Color(String colorName) {
		this.colorName = colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getColorName() {
		return colorName;
	}
}
