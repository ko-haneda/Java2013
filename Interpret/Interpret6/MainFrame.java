package Interpret6;

import java.awt.*;
import java.awt.event.*;

public class MainFrame extends Frame {
	private static final long serialVersionUID = 1L;
	
	MainFrame() {
		super("Interpret");
		setSize(1600, 500);
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		Panel p4 = new Panel();
		Panel subset_p = new Panel();
		MyInitializeFrame.add(p1);
		MyConstructorFrame.add(p2);
		MyFieldFrame.add(p3);
		MyMethodFrame.add(p4);
		setLayout(new GridLayout(1, 2));
		this.add(p1);
		subset_p.add(p2);
		subset_p.add(p3);
		subset_p.add(p4);
		this.add(subset_p);
		this.setVisible(true);
		this.setResizable(false);
		// Windowを閉じるときの処理
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
