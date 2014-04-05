package Interpret;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;

public class InterpretFrame extends Frame implements ItemListener, ActionListener {
	private static final long serialVersionUID = 1L;
	Label l1;
	Label l2;
	Label l3;
	Button b1;		//コンストラクタ一覧
	Button b2;		//メソッド一覧
	Button b3;		//フィールド一覧
	TextField tf;	//クラス名入力
	TextArea ta;	//コンソール表示
	List l;		//インスタンス入力
	boolean flag = true;	//チョイスのサイズをあわせるだけのフラグ
	MyConstructorFrame mfc;
	MyMethodFrame mfm;
	MyFieldFrame mff;
	Object field_obj;
	Object method_obj;
	public static HashMap<String,Object> objs;
	ArrayList<Field> list_field;
	ArrayList<Method> list_method;
	InterpretFrame() {
		super("Interpret");
		field_obj = new Object();
		method_obj = new Object();
		objs = new HashMap<String,Object>();
		list_field = new ArrayList<Field>();
		list_method = new ArrayList<Method>();
		mfc = new MyConstructorFrame();
		mfm = new MyMethodFrame();
		mff = new MyFieldFrame();
		setSize(730, 235);
		setLayout(new FlowLayout());
		l1 = new Label("Class Name");
		l2 = new Label("Instance");
		l3 = new Label("Console");
		b1 = new Button("Set");
		b2 = new Button("Method");
		b3 = new Button("Field");
		tf = new TextField(80);
		tf.setText("Interpret.Interpret");
		ta = new TextArea(5, 90);
		ta.setEditable(false);
		l = new List();
		l.add("　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		add(l1);
		add(tf);
		add(b1);
		add(l2);
		add(l);
		add(b2);
		add(b3);
		add(l3);
		add(ta);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		mfc.b.addActionListener(this);
		mfm.b.addActionListener(this);
		mff.b.addActionListener(this);
		mff.l.addItemListener(this);
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
		//コンストラクタ一覧
		if (e.getSource() == b1) {
			String cl_name = tf.getText();
			try {				
				Constructor<?>[] cons = MyConstructor.getConstructors(cl_name);
				mfc.l.removeAll();
				for (Constructor<?> con : cons) {
					mfc.l.add(MyConstructor.getSimpleName(con));
				}
				mfc.l.add("　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
				mfc.setVisible(true);
			} catch (SecurityException e1) {
				this.ta.append(e1 + "\n");
			} catch (ClassNotFoundException e1) {
				this.ta.append("指定したクラス名は存在しません。\n");
			} catch (IllegalArgumentException e1) {
				this.ta.append(e1 + "\n");
			}
		}
		//メソッド一覧
		if (e.getSource() == b2) {
			if(this.l.getSelectedItem() == null){
				this.ta.append("生成したインスタンスを選択してください。\n");
			}
			else{
				method_obj = objs.get(this.l.getSelectedItem());
				try {
					Method[] methods = MyMethod.getMethods(method_obj);
					mfm.l.removeAll();
					for(Method m : methods){
						mfm.l.add(MyMethod.getSimpleName(m));
						list_method.add(m);
					}
					mfm.l.add("　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
					mfm.setVisible(true);
				} catch (SecurityException e1) {
					this.ta.append(e1.toString() + "\n");
				} catch (ClassNotFoundException e1) {
					this.ta.append(e1.toString() + "\n");
				}
				mfm.setVisible(true);
			}
		}
		//フィールド一覧
		if (e.getSource() == b3) {
			if(this.l.getSelectedItem() == null){
				this.ta.append("生成したインスタンスを選択してください。\n");
			}
			else{
				field_obj = objs.get(this.l.getSelectedItem());
				try {
					Field[] fields = MyField.getFields(field_obj);
					mff.l.removeAll();
					for(Field f : fields){
						mff.l.add(MyField.getSimpleName(f));
						list_field.add(f);
					}
					mff.l.add("　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
					mff.setVisible(true);
					mff.tf.setText(MyField.getField(fields[0], field_obj).toString());
				} catch (SecurityException e1) {
					this.ta.append(e1.toString() + "\n");
				} catch (ClassNotFoundException e1) {
					this.ta.append(e1.toString() + "\n");
				} catch (IllegalArgumentException e1) {
					this.ta.append(e1.toString() + "\n");
				} catch (IllegalAccessException e1) {
					this.ta.append(e1.toString() + "\n");
				}
			}
		}
		//コンストラクタ実行
		if(e.getSource() == mfc.b){
			if(mfc.tf1.getText().equals("")/*予約語や数字のみを入力できないようにする。*/){
				this.ta.append("変数名は必ず入力して下さい\n");
			}
			else if(mfc.l.getSelectedIndex() == -1){
				this.ta.append("コンストラクタを選択してください\n");
			}
			else{
				String cl_name = tf.getText();
				try {
					Constructor<?>[] cons = MyConstructor.getConstructors(cl_name);
					int i = mfc.l.getSelectedIndex();
					Object obj = new Object();
					try {
						cons[i].setAccessible(true);
						obj = MyConstructor.newConstructor(cons[i],	mfc.tf2.getText());
						objs.put(mfc.tf1.getText(), obj);
//						objs.put(mfc.tf1.getText() + "\t" + obj.getClass().getSimpleName(), obj);
						if(flag){
							this.l.remove(0);
							flag = false;
						}
						this.l.add(mfc.tf1.getText());
						this.ta.append("インスタンスの生成に成功！！\n※引数が参照型の場合、この変数名を入力してください。\n");
						mfc.tf1.setText(" ");	//なぜかこの一行いれないとクリアできない。
						mfc.tf1.setText("");
						mfc.tf2.setText("");
					} catch (InstantiationException e1) {
						this.ta.append(e1 + "\n");
					} catch (IllegalAccessException e1) {
						this.ta.append(e1 + "\n");
					} catch (IllegalArgumentException e1) {
						this.ta.append(e1 + "\n");
					} catch (InvocationTargetException e1) {
						this.ta.append(e1 + "\n");
					}
				} catch (SecurityException e2) {
					this.ta.append(e2 + "\n");
				} catch (ClassNotFoundException e2) {
					this.ta.append(e2 + "\n");
				} catch (IllegalArgumentException e2) {
					this.ta.append(e2 + "\n");
				}
			}
		}
		//メソッド実行
		if(e.getSource() == mfm.b){
			try {
				if(mfm.l.getSelectedIndex() == -1){
					this.ta.append("メソッドを選択してください。\n");
				}
				else{
					Object obj = MyMethod.executeMethod(list_method.get(mfm.l.getSelectedIndex()), method_obj, mfm.tf.getText());
					this.ta.append("メソッドを実行しました。\n");
					this.ta.append(obj + "\n");
					mfm.tf.setText("");
				}
			} catch (IllegalAccessException e1) {
				this.ta.append(e1.toString() + "\n");
			} catch (IllegalArgumentException e1) {
				this.ta.append(e1.toString() + "\n");
			} catch (InvocationTargetException e1) {
				this.ta.append(e1.toString() + "\n");
			} 
		}
		//フィールド実行
		if(e.getSource() == mff.b){
			try {
				if(mff.l.getSelectedIndex() == -1){
					this.ta.append("フィールドを選択してください。\n");
				}
				else{
					MyField.setField(list_field.get(mff.l.getSelectedIndex()), field_obj, mff.tf.getText());
					this.ta.append("フィールドを変更しました。\n");
				}
			} catch (IllegalArgumentException e1) {
				this.ta.append(e1.toString() + "\n");
			} catch (IllegalAccessException e1) {
				this.ta.append(e1.toString() + "\n");
			} catch (SecurityException e1) {
				this.ta.append(e1.toString() + "\n");
			}
		}
	}
	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == mff.l) {
			try {
				mff.tf.setText(MyField.getField(list_field.get(mff.l.getSelectedIndex()), field_obj).toString());
			} catch (SecurityException e1) {
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		}
	}
}