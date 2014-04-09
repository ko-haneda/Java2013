package ch20.ex20_03;
import java.io.*;

public class DecryptInputStream extends FilterInputStream{
	private byte key;
	
	public DecryptInputStream(InputStream in, byte key) {
		super(in);
		this.key = key;
	}
	
	public int read() throws IOException{
		return super.read() ^ key;
	}
	
//	public int read(byte[] buf) throws IOException{
//		int b = super.read(buf);
//		下のコードがいらないのは内部的にread(byte[], int, int)を呼び出してるため	(親が)
//		このあたりの動作について、もう一度勉強しなおす。オーバーライドされているからといって、親にまで影響あるんだっけ？
//		for(int i = 0; i < b; i++){
//			buf[i] ^= key;
//		}
//		return b;
//	}
	
	public int read(byte[] buf, int offset, int count) throws IOException{
		int b = super.read(buf, offset, count);
		for(int i = offset; i < offset + b; i++){
			buf[i] ^= key;
		}
		return b;
	}
}
