package ch20.ex20_03;
import java.io.*;

public class EncryptOutputStream extends FilterOutputStream{
	private byte key;
	
	public EncryptOutputStream(OutputStream out, byte key) {
		super(out);
		this.key = key;
	}
	
	public void write(int ch) throws IOException{
		super.write(ch ^ key);
	}
	
//	public void write(byte[] buf) throws IOException{
//		for(byte b : buf){
//			b ^= key;
//		}
//		super.write(buf);
//	}
	
	public void write(byte[] buf, int offset, int count) throws IOException{
		for(int i = offset; i < offset + count; i++){
			buf[i] ^= key;
		}
		super.write(buf, offset, count);
	}
}
