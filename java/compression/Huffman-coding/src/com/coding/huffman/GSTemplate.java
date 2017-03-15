package com.coding.huffman;

public class GSTemplate <T>{
//	private static GSTemplate instance = null;
	private T data;
//	private GSTemplate(){}
	public GSTemplate(){}
	
	public void setData(T data){
		this.data = data;
	}
	
	public T getData(){
		return data;
	}
	
}
