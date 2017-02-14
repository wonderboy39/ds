package com.coding.test;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {
	public static void main(String [] args){
		List<String> list = new ArrayList<String>();
		list.add("add1");
		list.add("add2");
		list.add("add3");
		
		for(String word : list){
			System.out.print(word + " ");
		}
		System.out.println();
		
		list.remove("add2");
		for(String word : list){
			System.out.print(word + " ");
		}
	}
}
