package ex02_02;

import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private MyFrame frame;
	private MyFrameData data;
	
	public MyPanel(MyFrame frame, MyFrameData data) {
		this.frame = frame;
		this.data = data;
	}
	
	public void paintComponent(Graphics g) {
		setBackground(data.getBgColor());
		super.paintComponent(g);
		g.setColor(data.getChColor());
		g.setFont(data.getFont());
		FontMetrics fm = g.getFontMetrics();
		int w = fm.stringWidth(Time.getTime());
		int h = fm.getHeight() + 60;
		frame.setSize(w, h);
		Dimension size = frame.getSize();
		g.drawString(Time.getTime(),
				     (size.width - w) / 2,
					 (size.height - h) / 2 + fm.getMaxAscent());
	}

	
//	public int seachFontSize(Graphics g, int wid, int hei){
//		String str = Time.getTime();
//		int w;
//		int h;
//		int font_size = 1;
//		Font f = g.getFont();
//		while(true){
//			g.setFont(new Font(f.getFontName(), f.getStyle(), font_size));
//			h = g.getFontMetrics().getHeight();
//			w = g.getFontMetrics().stringWidth(str);
//			if(w >= wid) break;
//			if(h >= hei) break;
//			font_size++;
//		}
//		g.setFont(new Font(f.getFontName(), f.getStyle(), font_size - 1));
//		return font_size - 1;
//	}
}
