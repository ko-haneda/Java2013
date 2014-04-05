package Interpret;

import java.awt.*;

public class MyMethodFrame extends Frame {
	private static final long serialVersionUID = 1L;
	Label l1;
	Label l2;
	List l;
	TextField tf;
	Button b;

	MyMethodFrame() {
		super("MyMethod");
		setSize(730, 160);
		setLayout(new FlowLayout());
		l1 = new Label("Method List");
		l2 = new Label("Parameters");
		l = new List();
		tf = new TextField(85);
		b = new Button("　　　　　　　　　　　　　　Run　　　　　　　　　　　　　　");
		add(l1);
		add(l);
		add(l2);
		add(tf);
		add(b);
		this.setVisible(false);
		this.setResizable(false);
	}
}