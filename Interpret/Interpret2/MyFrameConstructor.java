package Interpret;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrameConstructor extends Frame  implements ActionListener{
	private static final long serialVersionUID = 1L;
	Label l;
	Choice c;
	TextField tf;
	Button b;
	boolean flag;

	MyFrameConstructor() {
		super("MyConstructor");
		setSize(350, 280);
		setLayout(new FlowLayout());
		l = new Label("Constructor");
		c = new Choice();
		tf = new TextField(20);
		b = new Button("Set1");
		flag = false;
		add(l);
		add(tf);
		add(c);
		add(b);
		b.addActionListener(this);
		this.setVisible(false);
		this.setResizable(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("fasdfdsaf");
		flag = true;
		this.setVisible(false);
	}
}
