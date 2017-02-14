package com.coding.huffman;

public class Util {
	public Util(){
		
	}
	public int countProb(StringBuilder sb, char c){
		int result = 0;
		for(int i=0; i<sb.length(); i++){
			if(c == sb.charAt(i)){
				result++;
			}
		}
		return result;
	}
	
}
