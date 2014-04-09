package ch12.ex12_01;

public class ObjectNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	public final String name;
	
	public ObjectNotFoundException(String name){
		super("No LinkedList named \" " + name + " \" found");
		this.name = name;
	}
}
