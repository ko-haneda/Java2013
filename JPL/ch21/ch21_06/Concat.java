package ch21.ch21_06;

import java.io.*;
import java.util.*;

public class Concat {

	// p463　ほとんどそのまま
	public static void concatenate1(String[] files_name) throws IOException {
		InputStream in;
		if (files_name.length == 0) {
			in = System.in;
		} else {
			InputStream fileIn, bufIn;
			List<InputStream> inputs = new ArrayList<InputStream>(files_name.length);
			for (String file_name : files_name) {
				fileIn = new FileInputStream(file_name);
				bufIn = new BufferedInputStream(fileIn);
				inputs.add(bufIn);
			}
			Enumeration<InputStream> files = Collections.enumeration(inputs);
			in = new SequenceInputStream(files);
		}
		int ch;
		while ((ch = in.read()) != -1) {
			System.out.write(ch);
		}
		System.out.println();
	}

	//独自
	public static void concatenate2(String[] files_name) throws IOException {
		MyEnumeration<InputStream> files = new MyEnumeration<InputStream>(Arrays.asList(files_name));
		while (files.hasMoreElements()) {
			InputStream in = files.nextElement();
			int ch;
			while ((ch = in.read()) != -1) {
				System.out.print((char) ch);
			}
		}
		System.out.println();
	}
}
