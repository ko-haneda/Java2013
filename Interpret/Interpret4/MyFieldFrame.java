package Interpret;

import java.awt.*;

public class MyFieldFrame extends Frame {
	private static final long serialVersionUID = 1L;
	Label l1;
	Label l2;
	List l;
	TextField tf;
	Button b;

	MyFieldFrame() {
		super("MyField");
		setSize(730, 160);
		setLayout(new FlowLayout());
		l1 = new Label("Field List");
		l2 = new Label("Value");
		l = new List();
		tf = new TextField(90);
		b = new Button("　　　　　　　　　　　　　　Set　　　　　　　　　　　　　　");
		add(l1);
		add(l);
		add(l2);
		add(tf);
		add(b);
		this.setVisible(false);
		this.setResizable(false);
	}
}