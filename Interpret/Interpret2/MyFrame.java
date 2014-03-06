package Interpret;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MyFrame extends Frame implements ActionListener{
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

	MyFrame() {
		super("MyFrame");
		mfc = new MyFrameConstructor();
		mfm = new MyFrameMethod();
		mff = new MyFrameField();
		setSize(350, 280);
		setLayout(new FlowLayout());
		l1 = new Label("Class Name");
		l2 = new Label("Instance");
		b1 = new Button("Set");
		b2 = new Button("Method");
		b3 = new Button("Field");
		tf = new TextField(20);
		ta = new TextArea(10, 40);
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
		this.setVisible(true);
		this.setResizable(false);
		//Windowを閉じるときの処理
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(b1.getLabel())){
			String cl_name = tf.getText();
			try {
				Constructor<?> []cons = MyConstructor.getConstructors(cl_name);
				for(Constructor<?> con : cons){
					mfc.c.add(con.toString());
				}
				this.setVisible(false);
				mfc.setVisible(true);
				while(!mfc.flag){
					int i = mfc.c.getSelectedIndex();
					Object obj = new Object();
					obj = MyConstructor.newConstructor(cons[i], mfc.tf.getText());
					this.c.add(obj.toString());					
				}
			} catch (SecurityException e1) {
			} catch (ClassNotFoundException e1) {
			} catch (IllegalArgumentException e1) {
			} catch (InstantiationException e1) {
			} catch (IllegalAccessException e1) {
			} catch (InvocationTargetException e1) {
			}
			this.setVisible(true);
		}
		if(e.getActionCommand().equals(b2.getLabel())){
			mfm.setVisible(true);
		}
		if(e.getActionCommand().equals(b3.getLabel())){
			mff.setVisible(true);
		}
	}
}
