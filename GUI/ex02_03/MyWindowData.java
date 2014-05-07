package ex02_03;

import java.awt.Color;
import java.awt.Font;

public class MyWindowData {
	
	private Color bgColor;	//背景色
	private Color chColor;	//文字色
	private String fontName;//Fontの種類
	private int fontSize;	//Fontのサイズ

	MyWindowData(){
		this.setBgColor(Color.black);
		this.setChColor(new Color(0, 150, 200));
		this.fontName = "Segoe UI Light";
		this.fontSize = 92;
	}

	public Color getBgColor() {
		return bgColor;
	}

	public void setBgColor(Color bkColor) {
		this.bgColor = bkColor;
	}

	public Color getChColor() {
		return chColor;
	}

	public void setChColor(Color chColor) {
		this.chColor = chColor;
	}

	public String getFontName() {
		return fontName;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public Font getFont() {
		return new Font(this.fontName, Font.BOLD, this.fontSize);
	}
}
