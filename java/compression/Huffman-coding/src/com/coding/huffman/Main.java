package com.coding.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String [] args){
		Main m = new Main();
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		List<Priority> pList = new ArrayList<Priority>();
		
//		StringBuilder sb = m.setString("abcacbcdcbcacdcacddd");
		StringBuilder sb = m.setString("ACABFEAFDE");
		System.out.println("length == " + String.valueOf(sb.length()));
		int [] countArr = new int[sb.length()];
		
		Util util = new Util();
//		char c = 'a';
		char c = 'A';
		
		//빈도수 계산 
		for(int i = 0; i<countArr.length; i++){
			Priority p = new Priority();
			p.setPriority(util.countProb(sb, c)/(float)sb.length());
			p.setData(c);
			pList.add(p);
			countArr[i] = util.countProb(sb, c++);
			System.out.println("countArr["+String.valueOf(i)+"] == " + countArr[i]);
		}
		System.out.println();
		util.printList(pList);
		System.out.println();
		
		// Priority Queue sorting.
		util.sortingList(pList);
		util.printList(pList);
		
		util.buildingTree(pList);	
	}
	
	public StringBuilder setString(String str){
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		return sb;
//		StringBuilder sb = new StringBuilder();
//		
//		sb.append("abca");
//		sb.append("cbcd");
//		sb.append("cbca");
//		sb.append("cdca");
//		sb.append("cddd");
	}
}
