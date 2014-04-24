package ch21.ch21_02;

import java.util.WeakHashMap;
import java.io.*;

public class DataHandler {
	private WeakHashMap<File, byte[]> lastData = new WeakHashMap<File, byte[]>();
	
	byte[] readFile(File file){
		byte[] data;
		
		
		if(lastData.containsKey(file)){
			System.out.println("さっきのファイルを読み込む。");
			data = lastData.get(file);
			if(data != null)	return data;
		}
		data = readBytesFromFile(file);
		lastData.put(file, data);
		return data;
	}

	 byte[] readBytesFromFile(File file) {
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        byte[] bytes = null;
        try {
        	fis = new FileInputStream(file);
	        baos = new ByteArrayOutputStream();
	        int b;    
			while((b = fis.read()) != -1){
			    baos.write(b);
			}
			bytes = baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				fis.close();
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        return bytes;
    }
}
