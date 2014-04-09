package ch16.ex16_07;

import java.lang.reflect.*;

class ex16_07 {

	public static void main(String[] args) {
		String str = ""; //要求されたクラス
		try {
			//Method indexM = Class.forName(str).getMethod("メソッド名", メソッド名.getGenericParameterType());
			//System.out.println(indexM.invoke(メソッドを実行するオブジェクトのインスタンス, パラメータの実際の値));
			Method indexM = String.class.getMethod("メソッド名", String.class);		//String classのところにパラメータのクラス
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}