package Interpret;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class MyFrame extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	Label l1;
	Label l2;
	Button b1;
	Button b2;
	Button b3;
	TextField tf;
	TextArea ta;
	Choice c;
	MyFrameConstructor mfc;
	MyFrameMethod mfm;
	MyFrameField mff;
	ArrayList<Object> objs;
	MyFrame() {
		super("Interpret");
		objs = new ArrayList<Object>();
		mfc = new MyFrameConstructor();
		mfm = new MyFrameMethod();
		mff = new MyFrameField();
		setSize(730, 280);
		setLayout(new FlowLayout());
		l1 = new Label("Class Name");
		l2 = new Label("Instance");
		b1 = new Button("Set");
		b2 = new Button("Method");
		b3 = new Button("Field");
		tf = new TextField(80);
		ta = new TextArea(10, 100);
		ta.setEditable(false);
		c = new Choice();
		add(l1);
		add(tf);
		add(b1);
		add(l2);
		add(c);
		add(b2);
		add(b3);
		add(ta);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		mfc.b.addActionListener(this);
		mfm.b.addActionListener(this);
		mff.b.addActionListener(this);
		this.setVisible(true);
		this.setResizable(false);
		// Windowを閉じるときの処理
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			String cl_name = tf.getText();
			try {				
				Constructor<?>[] cons = MyConstructor.getConstructors(cl_name);
				mfc.c.removeAll();
				for (Constructor<?> con : cons) {
					mfc.c.add(con.toString());
				}
				mfc.setVisible(true);
				this.setVisible(false);
			} catch (SecurityException e2) {
			} catch (ClassNotFoundException e2) {
			} catch (IllegalArgumentException e2) {
			}
		}
		if (e.getSource() == b2) {
			Object obj = objs.get(this.c.getSelectedIndex());
			try {
				Method[] methods = MyMethod.getMethods(obj);
				mfm.c.removeAll();
				for(Method m : methods){
					mfm.c.add(m.toString());
				}
				mfm.setVisible(true);
				this.setVisible(false);
			} catch (SecurityException e1) {
			} catch (ClassNotFoundException e1) {
			}
			mfm.setVisible(true);
		}
		if (e.getSource() == b3) {
			Object obj = objs.get(this.c.getSelectedIndex());
			try {
				Field[] fields = MyField.getFields(obj);
				mff.c.removeAll();
				for(Field f : fields){
					mff.c.add(f.toString());
				}
				mff.setVisible(true);
				this.setVisible(false);
			} catch (SecurityException e1) {
			} catch (ClassNotFoundException e1) {
			}
		}
		if(e.getSource() == mfc.b){
			String cl_name = tf.getText();
			try {
				Constructor<?>[] cons = MyConstructor.getConstructors(cl_name);
				int i = mfc.c.getSelectedIndex();
				Object obj = new Object();
				try {
					cons[i].setAccessible(true);
					obj = MyConstructor.newConstructor(cons[i],	mfc.tf.getText());
				} catch (InstantiationException e1) {
				} catch (IllegalAccessException e1) {
				} catch (IllegalArgumentException e1) {
				} catch (InvocationTargetException e1) {
				}
				objs.add(obj);
				this.c.add(obj.toString());
				this.ta.append("SUCCESS: create Constructor\n");
				mfc.setVisible(false);
				this.setVisible(true);
			} catch (SecurityException e2) {
			} catch (ClassNotFoundException e2) {
			} catch (IllegalArgumentException e2) {
			}
			mfc.tf.setText("");
		}
		if(e.getSource() == mfm.b){
			mfm.setVisible(false);
			this.setVisible(true);
		}
		if(e.getSource() == mff.b){
			mff.setVisible(false);
			this.setVisible(true);
		}
		
	}
}
