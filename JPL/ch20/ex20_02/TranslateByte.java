package ch20.ex20_02;
import java.io.*;

public class TranslateByte extends FilterInputStream{
	private byte from;
	private byte to;
	
	public TranslateByte(InputStream in, byte from, byte to) {
		super(in);
		this.from = from;
		this.to = to;
	}
	
	public int read() throws IOException{
		int b = super.read();
		return (b == -1 ? b : b == from ? to : b);
	}
	
	public int read(byte[] buf) throws IOException{
		int b = super.read(buf);
		for(int i = 0; i < b; i++){
			buf[i] = (buf[i] == from ? to : buf[i]);
		}
		return b;
	}
	
	public int read(byte[] buf, int offset, int count) throws IOException{
		int b = super.read(buf, offset, count);
		for(int i = offset; i < offset + b; i++){
			buf[i] = (buf[i] == from ? to : buf[i]);
		}
		return b;
	}
}
