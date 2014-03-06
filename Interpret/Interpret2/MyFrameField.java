package Interpret;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrameField extends Frame {
	private static final long serialVersionUID = 1L;
	Label l1;
	Label l2;
	Button b1;
	Button b2;
	Button b3;
	TextField tf;
	TextArea ta;
	Choice c;

	MyFrameField() {
		super("MyField");
		setSize(350, 280);
		setLayout(new FlowLayout());
		l1 = new Label("Class Name");
		l2 = new Label("Instance");
		b1 = new Button("Set");
		b2 = new Button("Method");
		b3 = new Button("Field");
		tf = new TextField(20);
		ta = new TextArea(10, 40);
		ta.setEditable(false);
		c = new Choice();
		add(l1);
		add(tf);
		add(b1);
		add(l2);
		add(c);
		add(b2);
		add(b3);
		add(ta);
		this.setVisible(false);
		this.setResizable(false);
		//Windowを閉じるときの処理
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
