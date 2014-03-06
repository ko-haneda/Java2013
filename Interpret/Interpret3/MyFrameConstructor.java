package Interpret;

import java.awt.*;

public class MyFrameConstructor extends Frame{
	private static final long serialVersionUID = 1L;
	Label l;
	Choice c;
	TextField tf;
	Button b;

	MyFrameConstructor() {
		super("MyConstructor");
		setSize(800, 100);
		setLayout(new FlowLayout());
		l = new Label("Constructor");
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
