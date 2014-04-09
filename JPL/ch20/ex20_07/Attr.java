package ch20.ex20_07;

import java.io.*;

public class Attr{
	private final String name;
	private Object value = null;
	
	public Attr(String name){
		this.name = name;
	}
	
	public Attr(String name, Object value){
		this.name = name;
		this.setValue(value);
	}
	
	public Attr(DataInputStream in) {
		String name = "";		
		try {
			name = in.readUTF();
			ObjectInputStream ois = new ObjectInputStream(in);
			this.value = ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

	public Object setValue(Object newValue) {
		Object oldVal = value;
		value = newValue;
		return oldVal;
	}

	public String toString(){
		return name + "='" + value + "'";
	}
	
	public void write(DataOutputStream out) {
		try {
			out.writeUTF(name);
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}