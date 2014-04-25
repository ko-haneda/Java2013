package ex02_01;

import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public MyPanel() {
		setBackground(Color.BLACK);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int w = this.getSize().width;
		int h = this.getSize().height;
		int font_size = getFontSize(w, h);
		g.setColor(new Color(0, 150, 200));
		g.setFont(new Font("TimesRoman", Font.BOLD, font_size));
		g.drawString(Time.getTime(), getLayoutX(w, font_size), getLayoutY(h, font_size));
	}

	//widthは8文字(7で合わせると丁度)、heightは1文字。　3ピクセルは4ポイント。　フォントサイズは小さい方にあわせる。
	public int getFontSize(int w, int h){
		return (int)((((w / 7.0) < h) ? w / 7.0 : h) * (4.0 / 3.0));
	}
	
	public int getLayoutX(int w, int fs){
		return (int)((w - (fs * 7 * 3.0 / 4.0)) / 2);
	}
	
	public int getLayoutY(int h, int fs){
		//	(3/4) / 2 = 0.35 
		return (int)(h / 2 + fs * 0.375);
	}
}
