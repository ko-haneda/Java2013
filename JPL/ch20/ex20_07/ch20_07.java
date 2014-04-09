package ch20.ex20_07;

import java.io.*;

/*
 * 個人メモ
 * DataOutputStreamはOK　少し文字化け
 * DataInputStreamがNG　→ readUTFでEOF　バイトで見るべき？
 * Dataストリームクラスの利点がよくわからない
 */
public class ch20_07 {
	public static void main(String[] args) throws IOException {
//		String test_data = "abracadabra!\nfdsuihfuafdnk";
//		InputStream in = new ByteArrayInputStream("abracadabra!".getBytes());
//    	InputStream in = new FileInputStream(new File("").getAbsolutePath() + "\\src\\ch20\\ex20_07\\in.txt");
		OutputStream out = new FileOutputStream(new File("").getAbsolutePath() + "\\src\\ch20\\ex20_07\\in.txt");
//		Attr attr = new Attr(new DataInputStream(in));
		Attr attr = new Attr("haneda", (Object)"kotaro");
		attr.write(new DataOutputStream(out));
	}
}