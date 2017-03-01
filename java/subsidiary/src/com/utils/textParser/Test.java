package com.utils.textParser;

public class Test {
	public static void main(String [] args){
		TextFileParser t = new TextFileParser("./sample.txt");
		String fullStr = t.readStringFromText();
//		t.printOrgString();
		t.close();
		
//		String subStr = fullStr.substring(fullStr.indexOf(":")+2);
		int codNumIdx = fullStr.indexOf(":", fullStr.indexOf(":")+1)+2;
		String subStr = fullStr.substring(codNumIdx);
		System.out.println("result");
		System.out.println(subStr);
	}
}
