package Interpret6;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;

public class MyConstructorFrame implements ActionListener {
	static Label l1;
	static Label l2;
	static Label l3;
	static List l;
	static TextField tf1;
	static TextField tf2;
	static Button b;
	private static GridBagLayout gbl = new GridBagLayout();

	static {
		l1 = new Label("Constructor List");
		l2 = new Label("Variable Name");
		l3 = new Label("Parameters");
		l = new List();
		tf1 = new TextField(82);
		tf2 = new TextField(85);
		b = new Button("Run");
		b.addActionListener(new MyConstructorFrame());
	}
	
	private static void layout(Panel p, Component c, int x, int y, int w, int h) {
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

	public static void add(Panel parent) {
		parent.setLayout(gbl);
		// 2 × 4
		layout(parent, l1, 0, 0, 1, 1);
		layout(parent, l, 1, 0, 1, 1);
		layout(parent, l2, 0, 1, 1, 1);
		layout(parent, tf1, 1, 1, 1, 1);
		layout(parent, l3, 0, 2, 1, 1);
		layout(parent, tf2, 1, 2, 1, 1);
		layout(parent, b, 0, 3, 2, 1);
	}

	public void actionPerformed(ActionEvent e) {
		if (tf1.getText().equals("")) {
			MyInitializeFrame.ta.append("変数名は必ず入力して下さい\n");
		} else if (l.getSelectedIndex() == -1) {
			MyInitializeFrame.ta.append("コンストラクタを選択してください\n");
		} else {
			String cl_name = MyInitializeFrame.tf.getText();
			try {
				Constructor<?>[] cons = MyConstructor.getConstructors(cl_name);
				int i = l.getSelectedIndex();
				Object obj = new Object();
				String strs[];
				try {
					cons[i].setAccessible(true);
					strs = tf1.getText().split(",");
					if (strs.length == 1) {
						obj = MyConstructor.newConstructor(cons[i], tf2.getText());
					} else if (strs.length == 2) {
						obj = Array.newInstance(Class.forName(cl_name),
								Integer.parseInt(strs[1]));
						for (int j = 0; j < Integer.parseInt(strs[1]); j++) {
							Array.set(obj, j, MyConstructor.newConstructor(cons[i], tf2.getText()));
						}
					} else if (strs.length == 3) {
						obj = Array.newInstance(Class.forName(cl_name),
								Integer.parseInt(strs[1]),
								Integer.parseInt(strs[2]));
						for (int j = 0; j < Integer.parseInt(strs[1]); j++) {
							for (int k = 0; k < Integer.parseInt(strs[2]); k++) {
								Array.set(Array.get(obj, j), k, MyConstructor.newConstructor(cons[i], tf2.getText()));
							}
						}
					} else {
						MyInitializeFrame.ta.append("配列は2次元配列までしか作成できません\n");
					}
					MyInitializeFrame.objs.put(strs[0], obj);
					if (strs.length == 1) {
						MyInitializeFrame.l.add(tf1.getText());
					} else if (strs.length == 2) {
						for (int j = 0; j < Integer.parseInt(strs[1]); j++) {
							MyInitializeFrame.l.add(strs[0] + "[" + j + "]");
						}
					} else if (strs.length == 3) {
						for (int j = 0; j < Integer.parseInt(strs[1]); j++) {
							for (int k = 0; k < Integer.parseInt(strs[2]); k++) {
								MyInitializeFrame.l.add(strs[0] + "[" + j + "][" + k + "]");
							}
						}
					}
					MyInitializeFrame.ta.append("インスタンスの生成に成功！！\n※引数が参照型の場合、この変数名を入力してください。\n");
					tf1.setText(" "); // なぜかこの一行いれないとクリアできない。この１文を入れると最適化がうまくいかないようにできるということ
					tf1.setText("");
					tf2.setText("");
				} catch (InstantiationException | IllegalAccessException | 
						 IllegalArgumentException | InvocationTargetException e1) {
					MyInitializeFrame.ta.append(e1 + "\n");
				}
			} catch (SecurityException | ClassNotFoundException | IllegalArgumentException e2) {
				MyInitializeFrame.ta.append(e2 + "\n");
			}
		}
	}
}