package Interpret;

import java.awt.*;

public class MyArrayFrame {
	Label l1;
	Label l2;
	Choice c;
	TextField tf;
	Button b;
	private static GridBagLayout gbl = new GridBagLayout();

	MyArrayFrame() {
		l1 = new Label("配列要素一覧");
		l2 = new Label("値");
		c = new Choice();
		tf = new TextField(60);
		b = new Button("更新");
	}
	
	private void layout(Panel p, Component c, int x, int y, int w, int h) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbc.insets = new Insets(5, 5, 0, 0);
		gbl.setConstraints(c, gbc);
		p.add(c);
	}

	public void add(Panel parent) {
		parent.setLayout(gbl);
		// 2 × 4
		layout(parent, l1, 0, 0, 1, 1);
		layout(parent, c, 1, 0, 1, 1);
		layout(parent, l2, 0, 1, 1, 1);
		layout(parent, tf, 1, 1, 1, 1);
		layout(parent, b, 0, 3, 2, 1);
	}
}