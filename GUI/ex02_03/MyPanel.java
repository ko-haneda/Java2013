package Swing.ex02_03;

import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private MyWindow frame;
	private MyWindowData data;
	
	public MyPanel(MyWindow frame, MyWindowData data) {
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
		int h = fm.getHeight();
		frame.setSize(w, h);
		Dimension size = frame.getSize();
		g.drawString(Time.getTime(),
				     (size.width - w) / 2,
					 (size.height - h) / 2 + fm.getMaxAscent());
	}
}
