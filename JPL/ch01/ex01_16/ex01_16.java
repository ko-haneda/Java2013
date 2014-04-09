package ch01.ex01_16;

import java.io.*;

class BadDataSetException extends Exception {
	private static final long serialVersionUID = 1L;
	String message;
	IOException e;

	BadDataSetException(String message, IOException e) {
		this.message = message;
		this.e = e;
		System.out.println(this.message);
		System.out.println(this.e);

		System.out.println();
	}
}

class MyUtilities {
	public double[] getDataSet(String setName) throws BadDataSetException {
		String file = setName + ".dset";
		FileInputStream in = null;

		try {
			in = new FileInputStream(file);
			return readDataSet(in);
		} catch (IOException e) {
			throw new BadDataSetException("error", e);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				;
			}
		}
	}

	public double[] readDataSet(FileInputStream setName) {
		double a[] = { 0.0, 1.2 };
		return a;
	}
}

public class ex01_16 {
	public static void main(String[] args) throws BadDataSetException {
		double a[];

		MyUtilities test = new MyUtilities();
		a = test.getDataSet("test");
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}