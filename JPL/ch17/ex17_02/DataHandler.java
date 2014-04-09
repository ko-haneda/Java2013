package ch17.ex17_02;

import java.lang.ref.*;
import java.io.*;

public class DataHandler {
	private File lastFile1;
	private WeakReference<File> lastFile2;
	private WeakReference<byte[]> lastData;
	
	byte[] readFile1(File file){
		byte[] data;
		
		if(file.equals(lastFile1)){
			System.out.println("さっきのファイルを読み込む。");
			data = lastData.get();
			if(data != null)	return data;
		}
		data = readBytesFromFile(file);
		lastFile1 = file;
		lastData = new WeakReference<byte[]>(data);
		return data;
	}
	
	byte[] readFile2(File file){
		byte[] data;
		
		if(file.equals(lastFile2)){
			System.out.println("さっきのファイルを読み込む。");
			data = lastData.get();
			if(data != null)	return data;
		}
		data = readBytesFromFile(file);
		lastFile2 = new WeakReference<File>(file);
		lastData = new WeakReference<byte[]>(data);
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
