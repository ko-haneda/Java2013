package ch16.ex16_08;

import java.lang.reflect.Method;

class ex16_08 {

	static double[] testData = {0.3, 1.3e-2, 7.9, 3.17};

	public static void main(String[] args) {
		String []str = {"ex16_08.SimpleSortDouble"};
		try{
			for(String name : str){
				Class<?> classFor = Class.forName(name);
				System.out.println("test");
				Object sorter = (Object) classFor.newInstance();
				SortMetrics metrics = ((SortDouble)sorter).sort(testData);
				System.out.println(name + ":" + metrics);
				for(double data : testData){
					System.out.println("\t" + data);
				}
			}
		} catch(Exception e){
			System.err.println(e);
		}
	}
}
