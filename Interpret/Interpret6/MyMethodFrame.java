package Interpret6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import Interpret5.MyMethod;

public class MyMethodFrame implements ActionListener {
	static Label l1;
	static Label l2;
	static List l;
	static TextField tf;
	static Button b;
	private static GridBagLayout gbl = new GridBagLayout();
	
	static {
		l1 = new Label("Method List");
		l2 = new Label("Parameters");
		l = new List();
		tf = new TextField(85);
		b = new Button("Run");
		b.addActionListener(new MyMethodFrame());
	}
	private static void layout(Panel p, Component c, int x, int y, int w, int h){
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
		layout(parent,  l, 1, 0, 1, 1);
		layout(parent, l2, 0, 1, 1, 1);
		layout(parent, tf, 1, 1, 1, 1);
		layout(parent,  b, 0, 3, 2, 1);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if(l.getSelectedIndex() == -1){
				MyInitializeFrame.ta.append("メソッドを選択してください。\n");
			}
			else{
				Object obj = MyMethod.executeMethod(MyInitializeFrame.list_method.get(l.getSelectedIndex()), MyInitializeFrame.method_obj, tf.getText());
				MyInitializeFrame.ta.append("メソッドを実行しました。\n");
				MyInitializeFrame.ta.append(obj + "\n");
				tf.setText("");
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
			MyInitializeFrame.ta.append(e1.toString() + "\n");
		} 		
	}
}