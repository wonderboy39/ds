package heap;

import java.util.ArrayList;

public class Test {
	public static void main(String [] args){
		ArrayList<String> strList = new ArrayList<String>();
		System.out.println("size :: " + String.valueOf(strList.size()));
		
		strList.add("a");
		strList.add("b");
		strList.add("c");
		
		for(String data : strList){
			System.out.println(String.valueOf(data));
		}
		
		System.out.println("String at 2 :: "+strList.get(2));
		System.out.println("String at 1 :: "+strList.get(1));
		System.out.println("String at 0 :: "+strList.get(0));
	}
}
