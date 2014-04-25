package ex02_01;

import javax.swing.JFrame;

public class MyFrame {
	public static void main(String[] args) {
		JFrame frame = new JFrame("CLOCK");
		frame.setSize(500, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPanel panel = new MyPanel();
		panel.setPreferredSize(frame.getSize());
		frame.add(panel);
		frame.setVisible(true);
		while (true) {
			try {
				Thread.sleep(1000);
				panel.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
