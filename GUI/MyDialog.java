package ex01_04;

import java.awt.*;
import java.awt.event.*;

class MyDialog extends Dialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	Label l1;
	Label l2;
	Label l3;
	Label l4;
	Choice c1;
	Choice c2;
	Choice c3;
	Choice c4;
	Button b1;
	Button b2;
	boolean flag;
	GridBagLayout gbl = new GridBagLayout();

	void addComponent(Component c, int x, int y, int w, int h) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbl.setConstraints(c, gbc);
		add(c);
	}

	MyDialog(Frame owner) {
		super(owner);
		this.addWindowListener(new DialogWindowListener());

		flag = false;
		// フォントの指定
		l1 = new Label("フォント");
		add(l1);
		c1 = new Choice();
		c1.add("Type1");
		c1.add("Type2");
		// フォントサイズの指定
		l2 = new Label("フォントサイズ");
		add(l2);
		c2 = new Choice();
		c2.add("Large");
		c2.add("Medium");
		c2.add("Small");
		// 文字色の指定
		l3 = new Label("文字色");
		add(l3);
		c3 = new Choice();
		c3.add("BLACK");
		c3.add("WHITE");
		c3.add("RED");
		c3.add("GREEN");
		c3.add("BLUE");
		// 背景色の設定
		l4 = new Label("背景色");
		add(l4);
		c4 = new Choice();
		c4.add("BLACK");
		c4.add("WHITE");
		c4.add("RED");
		c4.add("GREEN");
		c4.add("BLUE");
		// 設定の更新ボタン
		b1 = new Button("OK");
		b1.addActionListener(this);
		// 設定の更新ボタン
		b2 = new Button("キャンセル");
		b2.addActionListener(this);
		setTitle("MyDialog");
		setSize(400, 400);
		setResizable(false);
		setLayout(gbl);
		addComponent(l1, 0, 0, 1, 1);		
		addComponent(c1, 2, 0, 1, 1);
		
		addComponent(c2, 2, 1, 1, 1);
		addComponent(l2, 0, 1, 1, 2);
		
		addComponent(c3, 2, 2, 1, 1);
		addComponent(l3, 0, 2, 1, 1);

		addComponent(c4, 2, 3, 1, 1); 
		addComponent(l4, 0, 3, 1, 1);
		
		addComponent(b1, 0, 4, 1, 1); 
		addComponent(b2, 2, 4, 1, 1); 

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(b1.getLabel())){
			flag = true;
		}
		if(e.getActionCommand().equals(b2.getLabel())){
			setVisible(false);
		}
		
	}

	class DialogWindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			dispose();
		}
	}
}
