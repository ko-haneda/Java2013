package Interpret;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import javax.swing.JOptionPane;

public class Interpret {
	public static void main(String[] args) {
		try {
			String str = JOptionPane.showInputDialog("フィールドの表示\nクラス名を入力");
			Field[] fields = Class.forName(str).getDeclaredFields();
			str = "";
			for (Field field : fields) {
				str += (field.toString() + "\n");
//				System.out.println(field.getGenericType());
			}
			JOptionPane.showMessageDialog(null, str);

			str = JOptionPane.showInputDialog("コンストラクタの表示\nクラス名を入力");
			Constructor[] cons = Class.forName(str).getDeclaredConstructors();
			for (Constructor c : cons) {
				// アクセス修飾子を緩める。
				c.setAccessible(true);
				str += (c.toString() + "\n");
			}
			JOptionPane.showMessageDialog(null, str);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
