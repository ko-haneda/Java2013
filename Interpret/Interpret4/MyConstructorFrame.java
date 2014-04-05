package Interpret;

import java.awt.*;

public class MyConstructorFrame extends Frame{
	private static final long serialVersionUID = 1L;
	Label l1;
	Label l2;
	Label l3;
	List l;
	TextField tf1;
	TextField tf2;
	Button b;

	MyConstructorFrame() {
		super("MyConstructor");
		setSize(730, 200);
		setLayout(new FlowLayout());
		l1 = new Label("Constructor List");
		l2 = new Label("Variable Name");
		l3 = new Label("Parameters");
		l = new List();
		tf1 = new TextField(82);
		tf2 = new TextField(85);
		b = new Button("　　　　　　　　　　　　　　Run　　　　　　　　　　　　　　");
		add(l1);
		add(l);
		add(l2);
		add(tf1);
		add(l3);
		add(tf2);
		add(b);
		this.setVisible(false);
		this.setResizable(false);
	}
}