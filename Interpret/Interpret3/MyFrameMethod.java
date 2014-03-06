package Interpret;

import java.awt.*;

public class MyFrameMethod extends Frame {
	private static final long serialVersionUID = 1L;
	Label l;
	Choice c;
	TextField tf;
	Button b;

	MyFrameMethod() {
		super("MyMethod");
		setSize(800, 100);
		setLayout(new FlowLayout());
		l = new Label("Method List");
		c = new Choice();
		tf = new TextField(70);
		b = new Button("Set");
		add(l);
		add(c);
		add(tf);
		add(b);
		this.setVisible(false);
		this.setResizable(false);
	}
}
