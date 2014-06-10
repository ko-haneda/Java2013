package ch16_11;

import java.io.*;

public class PlayerLoader extends ClassLoader {
	
	public Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			byte[] buf = bytesForClass(name);
			return defineClass(name, buf, 0, buf.length);
		} catch (IOException e) {
			throw new ClassNotFoundException(e.toString());
		}
	}

	private byte[] bytesForClass(String name) throws IOException {
		FileInputStream in = null;
		try {
			in = new FileInputStream(name + ".class");
			byte[] buf = new byte[in.available()];
			in.read(buf);
			return buf;
		} finally {
			if (in != null)	in.close();
		}
	}
}