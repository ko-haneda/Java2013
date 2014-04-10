package Interpret6;

import java.awt.*;
import java.awt.event.*;

public class MyFieldFrame implements ItemListener, ActionListener {
	private static Label l1;
	private static Label l2;
	static List l;
	static TextField tf;
	private static Button b;
	private static GridBagLayout gbl = new GridBagLayout();
	
	static {
		l1 = new Label("Field List");
		l2 = new Label("Value");
		l = new List();
		tf = new TextField(90);
		b = new Button("Set");
		b.addActionListener(new MyFieldFrame());
		l.addItemListener(new MyFieldFrame());
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
				MyInitializeFrame.ta.append("フィールドを選択してください。\n");
			}
			else{
				MyField.setField(MyInitializeFrame.list_field.get(l.getSelectedIndex()), MyInitializeFrame.field_obj, tf.getText());
				MyInitializeFrame.ta.append("フィールドを変更しました。\n");
			}
		} catch (IllegalArgumentException | IllegalAccessException | SecurityException e1) {
			MyInitializeFrame.ta.append(e1.toString() + "\n");
		} 	
	}
	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == this.l) {
			try {
				this.tf.setText(MyField.getField(MyInitializeFrame.list_field.get(this.l.getSelectedIndex()), MyInitializeFrame.field_obj).toString());
			} catch (SecurityException | IllegalArgumentException | IllegalAccessException e1) {
				MyInitializeFrame.ta.append(e1.toString() + "\n");
			}
		}
	}
}