package ch03.ex03_07;

class Attr{
	private final String name;
	private Object value = null;
	
	public Attr(String name){
		this.name = name;
	}
	
	public Attr(String name, Object value){
		this.name = name;
		this.setValue(value);
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
}

class ScreenColor{
	String color;
	
	ScreenColor(){
		color = "white";
	}
	ScreenColor(Object color){
		this.color = color.toString();
	}
}

class ColorAttr extends Attr{

	private ScreenColor myColor;
	
	public ColorAttr(String name, Object value) {
		super(name, value);
		decodeColor();
	}
	
	public ColorAttr(String name) {
		this(name, "transparent");
	}
	
	public ColorAttr(String name, ScreenColor value) {
		super(name, value.toString());
		myColor = value;
	}
	
	public Object setValue(Object newValue){
		Object retval = super.setValue(newValue);
		decodeColor();
		return retval;
	}
	
	public ScreenColor setValue(ScreenColor newValue){
		super.setValue(newValue.toString());
		ScreenColor oldValue = myColor;
		myColor = newValue;
		return oldValue;
	}
	
	public ScreenColor getColor(){
		return myColor;
	}
	
	protected void decodeColor(){
		if(getValue() == null)
			myColor = null;
		else
			myColor = new ScreenColor(getValue());
	}
	
	public boolean equals(Object obj){
		return false;
	}
	
	public int hashCode(){
		return super.hashCode();
	}
}
public class ex03_07 {
	
	//できませんでした。
	//ハッシュコードを一致させる方法がわからない。
	//2つのオブジェクトのハッシュコードを一致させなければいけないのに、
	//hashCode()にパラメータがない。どこで一致さればいいのかわからなかった。
	

}
