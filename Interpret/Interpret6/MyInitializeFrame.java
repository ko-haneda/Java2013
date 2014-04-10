package Interpret6;

import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.lang.reflect.*;
import java.util.*;


public class MyInitializeFrame implements ActionListener{
	static Label l1;
	static Label l2;
	static Label l3;
	static Button b1;		//コンストラクタ一覧
	static Button b2;		//メソッド一覧
	static Button b3;		//フィールド一覧
	static TextField tf;	//クラス名入力
	static TextArea ta;	//コンソール表示
	static List l;			//インスタンス入力
	private static GridBagLayout gbl = new GridBagLayout();
	static HashMap<String,Object> objs;
	static ArrayList<Field> list_field;
	static ArrayList<Method> list_method;
	static Object field_obj;
	static Object method_obj;
	
	static {
		field_obj = new Object();
		method_obj = new Object();
		objs = new HashMap<String,Object>();
		objs = new HashMap<String,Object>();
		list_field = new ArrayList<Field>();
		list_method = new ArrayList<Method>();
		l1 = new Label("Class Name");
		l2 = new Label("Instance");
		l3 = new Label("Console");
		b1 = new Button("Set");
		b2 = new Button("Method");
		b3 = new Button("Field");
		tf = new TextField(40);
		tf.setText("Interpret.Interpret");
		ta = new TextArea();
		ta.setEditable(false);
		l = new List(10);
		b1.addActionListener(new MyInitializeFrame());
		b2.addActionListener(new MyInitializeFrame());
		b3.addActionListener(new MyInitializeFrame());
	}
	
	private static void layout(Panel p, Component c, int x, int y, int w, int h){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.insets = new Insets(0, 5, 20, 0);
        gbl.setConstraints(c, gbc);
        p.add(c);
	}
	
	public static void add(Panel parent) {
		parent.setLayout(gbl);
		//6 × 3
		layout(parent, l1, 0, 0, 1, 1);
		layout(parent, tf, 1, 0, 3, 1);
		layout(parent, b1, 4, 0, 2, 1);
		layout(parent, l2, 0, 1, 1, 1);
		layout(parent, l,  1, 1, 3, 1);
		layout(parent, b2, 4, 1, 1, 1);
		layout(parent, b3, 5, 1, 1, 1);
		layout(parent, l3, 0, 2, 1, 1);
		layout(parent, ta, 1, 2, 5, 1);
		parent.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) 	コンストラクタ一覧表示();
		if (e.getSource() == b2) 	メソッド一覧表示();
		if (e.getSource() == b3) 	フィールド一覧表示();
	}
	public void コンストラクタ一覧表示(){
		String cl_name = tf.getText();
		try {				
			Constructor<?>[] cons = MyConstructor.getConstructors(cl_name);
			MyConstructorFrame.l.removeAll();
			for (Constructor<?> con : cons) {
				MyConstructorFrame.l.add(MyConstructor.getSimpleName(con));
			}
		} catch (SecurityException | IllegalArgumentException e) {
			this.ta.append(e + "\n");
		} catch (ClassNotFoundException e) {
			this.ta.append("指定したクラス名は存在しません。\n");
		}
	}
	
	public void メソッド一覧表示(){
		if(this.l.getSelectedItem() == null){
			this.ta.append("生成したインスタンスを選択してください。\n");
		}
		else{
			String []strs = this.l.getSelectedItem().split("\\[");
			method_obj = objs.get(strs[0]);
			if(strs.length == 2){
				method_obj = Array.get(method_obj, Integer.parseInt(strs[1].substring(0, strs[1].length() - 1)));
			}
			else if(strs.length == 3){
				method_obj = Array.get(method_obj, Integer.parseInt(strs[1].substring(0, strs[1].length() - 1)));
				method_obj = Array.get(method_obj, Integer.parseInt(strs[2].substring(0, strs[2].length() - 1)));
			}
			else if(strs.length > 3){
				System.out.print("ありえないエラー");
				System.out.println("配列は2次元までです。");
			}
			try {
				Method[] methods = MyMethod.getMethods(method_obj);
				MyMethodFrame.l.removeAll();
				for(Method m : methods){
					MyMethodFrame.l.add(MyMethod.getSimpleName(m));
					list_method.add(m);
				}
			} catch (SecurityException e1) {
				this.ta.append(e1.toString() + "\n");
			} catch (ClassNotFoundException e1) {
				this.ta.append(e1.toString() + "\n");
			}
		}
	}
	public void フィールド一覧表示(){
		if(this.l.getSelectedItem() == null){
			this.ta.append("生成したインスタンスを選択してください。\n");
		}
		else{
			String []strs = this.l.getSelectedItem().split("\\[");
			field_obj = objs.get(strs[0]);
			if(strs.length == 2){
				System.out.println("オブジェクトのサイズ" + Array.getLength(field_obj));
				System.out.println("index" + strs[1].substring(0, strs[1].length() - 1));
				field_obj = Array.get(field_obj, Integer.parseInt(strs[1].substring(0, strs[1].length() - 1)));
			}
			else if(strs.length == 3){
				field_obj = Array.get(field_obj, Integer.parseInt(strs[1].substring(0, strs[1].length() - 1)));
				field_obj = Array.get(field_obj, Integer.parseInt(strs[2].substring(0, strs[2].length() - 1)));
			}
			else if(strs.length > 3){
				System.out.print("ありえないエラー");
				System.out.println("配列は2次元までです。");
			}
			try {
				Field[] fields = MyField.getFields(field_obj);
				MyFieldFrame.l.removeAll();
				System.out.println(fields);
				System.out.println(fields.length);
				if(fields.length != 0){
					for(Field f : fields){
						MyFieldFrame.l.add(MyField.getSimpleName(f));
						list_field.add(f);
						System.out.println(f);
					}
					MyFieldFrame.tf.setText(MyField.getField(fields[0], field_obj).toString());
				}
				else{
					this.ta.append("フィールドは存在しません。\n");
				}
			} catch (SecurityException | ClassNotFoundException | IllegalArgumentException | IllegalAccessException e) {
				this.ta.append(e.toString() + "\n");
			}
		}
	}
}