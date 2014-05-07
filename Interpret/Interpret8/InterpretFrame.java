package Interpret8;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class InterpretFrame extends Frame implements ItemListener, ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	Label l1;
	Label l2;
	Label l3;
	Label l4;
	Label l5;
	Button b1;		//コンストラクタ一覧
	Button b2;		//メソッド一覧
	Button b3;		//フィールド一覧
	Button b4;		//配列生成
	Button b5;		//配列要素表示
	TextField tf1;	//クラス名入力
	TextField tf2;	//クラス名入力
	TextField tf3;	//クラス名入力
	TextArea ta;	//コンソール表示
	List l;			//インスタンス入力
	MyConstructorFrame mfc;
	MyFieldFrame mff;
	MyMethodFrame mfm;
	MyArrayFrame mfa;
	Object field_obj;
	Object method_obj;
	public static LinkedHashMap<String,Object> objs;
	ArrayList<Field> list_field;
	ArrayList<Method> list_method;
	private static GridBagLayout gbl = new GridBagLayout();

	static {
		objs = new LinkedHashMap<String,Object>();
	}
	
	InterpretFrame() {
		super("Interpret");
		field_obj = new Object();
		method_obj = new Object();
		list_field = new ArrayList<Field>();
		list_method = new ArrayList<Method>();
		mfc = new MyConstructorFrame();
		mff = new MyFieldFrame();
		mfm = new MyMethodFrame();
		mfa = new MyArrayFrame();
		l1 = new Label("クラス名");
		l2 = new Label("インスタンス");
		l3 = new Label("コンソール");
		l4 = new Label("配列変数名");
		l5 = new Label("配列サイズ");
		b1 = new Button("コンストラクタ表示");
		b2 = new Button("フィールド表示");
		b3 = new Button("メソッド表示");
		b4 = new Button("配列生成");
		b5 = new Button("配列要素表示");
		tf1 = new TextField(45);
		tf2 = new TextField(45);
		tf3 = new TextField(45);
		ta = new TextArea(13, 55);
		ta.setEditable(false);
		l = new List();
		setSize(1200, 600);
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		Panel p4 = new Panel();
		Panel p5 = new Panel();
		Panel subset_p = new Panel();
		this.ori_add(p1);
		mfc.add(p2);
		mff.add(p3);
		mfm.add(p4);
		mfa.add(p5);
		setLayout(new GridLayout(1, 2));
		subset_p.setLayout(new GridLayout(4, 1));
		this.add(p1);
		this.add(subset_p);
		subset_p.add(p2);
		subset_p.add(p3);
		subset_p.add(p4);
		subset_p.add(p5);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		mfc.b.addActionListener(this);
		mff.b.addActionListener(this);
		mfm.b.addActionListener(this);
		mfa.b.addActionListener(this);
		mff.c.addItemListener(this);
		mfa.c.addItemListener(this);
		tf1.addKeyListener(this);
		this.setResizable(false);
		// Windowを閉じるときの処理
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void layout(Panel p, Component c, int x, int y, int w, int h){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.insets = new Insets(10, 15, 15, 0);
        gbl.setConstraints(c, gbc);
        p.add(c);
	}

	public void ori_add(Panel parent) {
		parent.setLayout(gbl);	
		//6 × 3
		layout(parent, l1, 0, 0, 1, 1);
		layout(parent, tf1, 1, 0, 3, 1);
		layout(parent, b1, 4, 0, 2, 1);
		
		layout(parent, l4, 0, 1, 1, 1);
		layout(parent, tf2, 1, 1, 3, 1);
		layout(parent, l5, 0, 2, 1, 1);
		layout(parent, tf3, 1, 2, 3, 1);
		layout(parent, b4, 4, 2, 2, 1);
		
		layout(parent, l2, 0, 4, 1, 1);
		layout(parent, l,  1, 4, 3, 3);
		layout(parent, b2, 4, 4, 2, 1);
		layout(parent, b3, 4, 5, 2, 1);
		layout(parent, b5, 4, 6, 2, 1);
		
		layout(parent, l3, 0, 7, 1, 1);
		layout(parent, ta, 1, 7, 5, 1);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) 	コンストラクタ一覧表示();
		if (e.getSource() == b2) 	フィールド一覧表示();
		if (e.getSource() == b3) 	メソッド一覧表示();
		if (e.getSource() == b4) 	配列生成();
		if (e.getSource() == b5) 	配列要素表示();
		if (e.getSource() == mfc.b)	インスタンス生成();
		if (e.getSource() == mfm.b)	メソッド実行();
		if (e.getSource() == mff.b)	フィールド変更();
		if (e.getSource() == mfa.b)	配列要素の変更();
	}

	public void 配列要素の変更(){
		try{
			String[] key = mfa.c.getSelectedItem().split("\\[");
			Object old_obj = objs.get(key[0]);
			Object new_obj = objs.get(key[0]);
			if(key.length > 1)	new_obj = Array.get(old_obj, Integer.parseInt(key[1].substring(0, key[1].length() - 1)));
			if(key.length == 3){
				old_obj = new_obj;
				new_obj = Array.get(old_obj, Integer.parseInt(key[2].substring(0, key[2].length() - 1)));
			}
			new_obj = Interpret.createObjectArr(old_obj.getClass(), mfa.tf.getText());
			if(key.length == 2)	Array.set(old_obj, Integer.parseInt(key[1].substring(0, key[1].length() - 1)), new_obj);
			if(key.length == 3)	Array.set(old_obj, Integer.parseInt(key[2].substring(0, key[2].length() - 1)), new_obj);
		}catch(Throwable e){
			this.ta.append(e.toString() + "\n");
		}
	}
	
	public void 配列生成(){
		if(tf2.getText().equals("")){
			this.ta.append("配列変数名は必ず入力してください\n");
			return;
		}
		if(tf3.getText().equals("")){
			this.ta.append("配列サイズは必ず入力して下さい\n");
			return;
		}
		try {
			String[] strs = this.tf3.getText().split(",");
			Object obj = new Object();
			if(strs.length == 1){
				obj = Array.newInstance(Class.forName(this.tf1.getText()), Integer.parseInt(strs[0]));
				for(int i = 0; i < Integer.parseInt(strs[0]); i++){
					this.l.add(this.tf2.getText() + "[" + i + "]");
				}
			}
			else if(strs.length == 2){
				obj = Array.newInstance(Class.forName(this.tf1.getText()), Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
				for(int i = 0; i < Integer.parseInt(strs[0]); i++){
					for(int j = 0; j < Integer.parseInt(strs[1]); j++){
						this.l.add(this.tf2.getText() + "[" + i + "][" + j + "]");
					}
				}
			}
			else{
				this.ta.append("配列は2次元配列までしか作成できません\n");
				return;
			}
			objs.put(this.tf2.getText(), obj);
			this.tf2.setText("");
			this.tf3.setText("");
		}
		catch (NumberFormatException | NegativeArraySizeException| ClassNotFoundException e) {
			this.ta.append(e + "\n");
		}
	}
	
	public void 配列要素表示(){
		if(this.l.getSelectedItem() == null){
			this.ta.append("生成したインスタンスを選択してください。\n");
			return;
		}
		String []strs = this.l.getSelectedItem().split("\\[");
		Object obj = objs.get(strs[0]);
		if(strs.length == 1){
			this.ta.append("そのインスタンスは配列ではありません。\n");
			return;
		}
		if(strs.length == 2){
			mfa.c.removeAll();
			for(int i = 0; i < Array.getLength(obj); i++){
				mfa.c.add(strs[0] + "[" + i + "]");
			}
			obj = Array.get(obj, 0);
			if(obj == null)	mfa.tf.setText("null");	
			else			mfa.tf.setText(obj.toString());	
		}
		else if(strs.length == 3){
			mfa.c.removeAll();
			for(int i = 0; i < Array.getLength(obj); i++){
				Object sub_obj = Array.get(obj, i);
				for(int j = 0; j < Array.getLength(sub_obj); j++){
					mfa.c.add(strs[0] + "[" + i + "][" + j + "]");
				}
				sub_obj = Array.get(sub_obj, 0);
				if(sub_obj == null)	mfa.tf.setText("null");	
				else			mfa.tf.setText(sub_obj.toString());	
			}
		}
		else{
			this.ta.append("配列は2次元までです。\n");
			return;
		}
	}
	
	public void コンストラクタ一覧表示(){
		String cl_name = tf1.getText();
		try {				
			Constructor<?>[] cons = MyConstructor.getConstructors(cl_name);
			mfc.c.removeAll();
			Arrays.sort(cons, new MyConstructor.ConstructorComparator());
			for (Constructor<?> con : cons) {
				mfc.c.add(MyConstructor.getSimpleName(con));
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
				if(method_obj == null){
					this.ta.append("メソッドは存在しません。\n");
					return;
				}
				Method[] methods = MyMethod.getMethods(method_obj);
				mfm.c.removeAll();
				Arrays.sort(methods, new MyMethod.MethodComparator());
				list_method.clear();
				for(Method m : methods){
					mfm.c.add(MyMethod.getSimpleName(m));
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
				if(field_obj == null){
					this.ta.append("フィールドは存在しません。\n");
					return;
				}
				Field[] fields = MyField.getFields(field_obj);
				mff.c.removeAll();
				if(fields.length != 0){
					Arrays.sort(fields, new MyField.FieldComparator());
					list_field.clear();
					for(Field f : fields){
						mff.c.add(MyField.getSimpleName(f));
						list_field.add(f);
					}
					mff.tf.setText(MyField.getField(fields[0], field_obj).toString());
				}
				else{
					this.ta.append("フィールドは存在しません。\n");
				}
			} catch (SecurityException | ClassNotFoundException | IllegalArgumentException | IllegalAccessException e) {
				this.ta.append(e.toString() + "\n");
			}
		}
	}

	public void インスタンス生成(){
		if(mfc.tf1.getText().equals("")/*予約語や数字のみを入力できないようにする。*/){
			this.ta.append("変数名は必ず入力して下さい\n");
		}
		else if(mfc.c.getSelectedIndex() == -1){
			this.ta.append("コンストラクタを選択してください\n");
		}
		else{
			String cl_name = tf1.getText();
			try {
				Constructor<?>[] cons = MyConstructor.getConstructors(cl_name);
				Arrays.sort(cons, new MyConstructor.ConstructorComparator());
				int i = mfc.c.getSelectedIndex();
				Object obj = new Object();
				try {
					cons[i].setAccessible(true);
					obj = MyConstructor.newConstructor(cons[i],	mfc.tf2.getText());
					objs.put(mfc.tf1.getText(), obj);
					this.l.add(mfc.tf1.getText());
					this.ta.append("インスタンスの生成に成功！！\n※引数が参照型の場合、この変数名を入力してください。\n");
					mfc.tf1.setText("");
					mfc.tf2.setText("");
				} catch (InstantiationException e1) {
					this.ta.append(e1.getCause() + "\n");
				} catch (IllegalAccessException e1) {
					this.ta.append(e1.getCause() + "\n");
				} catch (IllegalArgumentException e1) {
					this.ta.append(e1.getCause() + "\n");
				} catch (InvocationTargetException e1) {
					this.ta.append(e1.getCause() + "\n");
				}
			} catch (SecurityException e2) {
				this.ta.append(e2.getCause() + "\n");
			} catch (ClassNotFoundException e2) {
				this.ta.append(e2.getCause() + "\n");
			} catch (IllegalArgumentException e2) {
				this.ta.append(e2.getCause() + "\n");
			}
		}
	}
	public void フィールド変更(){
		try {
			if(mff.c.getSelectedIndex() == -1){
				this.ta.append("フィールドを選択してください。\n");
			}
			else{
				MyField.setField(list_field.get(mff.c.getSelectedIndex()), field_obj, mff.tf.getText());
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
	public void メソッド実行(){
		try {
			if(mfm.c.getSelectedIndex() == -1){
				this.ta.append("メソッドを選択してください。\n");
			}
			else{
				Object obj = MyMethod.executeMethod(list_method.get(mfm.c.getSelectedIndex()), method_obj, mfm.tf.getText());
				this.ta.append("メソッドを実行しました。\n");
				this.ta.append(obj + "\n");
				mfm.tf.setText("");
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
			this.ta.append(e1.getCause() + "\n");
		} 
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == mff.c) {
			try {
				mff.tf.setText(MyField.getField(list_field.get(mff.c.getSelectedIndex()), field_obj).toString());
			} catch (SecurityException | IllegalArgumentException | IllegalAccessException e1) {
				this.ta.append(e1.toString() + "\n");
			}
		}
		if (e.getSource() == mfa.c) {
			String[] key = mfa.c.getSelectedItem().split("\\[");
			Object obj = objs.get(key[0]);
			if(key.length > 1)	obj = Array.get(obj, Integer.parseInt(key[1].substring(0, key[1].length() - 1)));
			if(key.length == 3)	obj = Array.get(obj, Integer.parseInt(key[2].substring(0, key[2].length() - 1)));
			if(obj == null)	mfa.tf.setText("null");	
			else			mfa.tf.setText(obj.toString());	
		}
	}
	
	public void setVisible(boolean flag){
		this.l.removeAll();
		for (String key : objs.keySet()) {
			if(objs.get(key).getClass().isArray()){
				Object obj = objs.get(key);
				for(int i = 0; i < Array.getLength(obj); i++){
					String sub_key = key + "[" + i + "]";
					Object sub_obj = Array.get(obj, i);
					if(sub_obj.getClass().isArray()){
						for(int j = 0; j < Array.getLength(sub_obj); j++){
							String sub_sub_key = sub_key + "[" + j + "]";
							this.l.add(sub_sub_key);
						}
					}
					else{
						this.l.add(sub_key);
					}
				}
			}
			else{
				this.l.add(key);
			}
		}
		super.setVisible(flag);
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if(e.getSource() == tf1){
			if(e.getKeyCode() == '1')	tf1.setText("Interpret8.InterpretFrame");
			if(e.getKeyCode() == '2')	tf1.setText("java.lang.String");
			if(e.getKeyCode() == '3')	tf1.setText("java.lang.Integer");
			if(e.getKeyCode() == '4')	tf1.setText("java.lang.Float");
			if(e.getKeyCode() == '5')	tf1.setText("java.awt.Frame");
			if(e.getKeyCode() == '6')	tf1.setText("java.awt.Button");
			if(e.getKeyCode() == '7')	tf1.setText("java.awt.Color");
			if(e.getKeyCode() == 10)	コンストラクタ一覧表示();	//EnterキーをPUSH
		}
	}

	public void keyTyped(KeyEvent e) {
	}
}