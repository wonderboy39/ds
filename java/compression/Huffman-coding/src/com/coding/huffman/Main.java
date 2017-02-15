package com.coding.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String [] args){
		int [] countArr = new int[4];
		
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		List<Priority> pList = new ArrayList<Priority>();
		
		GSTemplate<Node> gs = new GSTemplate<Node>();
		StringBuilder sb = new StringBuilder();
		
		sb.append("abca");
		sb.append("cbcd");
		sb.append("cbca");
		sb.append("cdca");
		sb.append("cddd");
		
		Util util = new Util();
		char c = 'a';
		for(int i = 0; i<countArr.length; i++){
			countMap.put(String.valueOf(c), util.countProb(sb, c));
			Priority p = new Priority();
			p.setPriority(util.countProb(sb, c)/(float)sb.length());
			p.setData(c);
			pList.add(p);
			
			countArr[i] = util.countProb(sb, c++);
			System.out.println("countArr["+String.valueOf(i)+"] == " + countArr[i]);
		}
		System.out.println();
		
		// Priority Queue sorting.
		util.sortingList(pList);
		util.printList(pList);
		
//		Node root = new Node("root",123);
//		root.setLeft(new Node("A",11));
//		root.setRight(new Node("B",12));
//		
//		System.out.println();
//		System.out.println("root == " + root.getData());
//		System.out.println("left == " + root.getLeft().getData()+", percent == " + String.valueOf(root.getLeft().getPercent()));
//		System.out.println("right == " + root.getRight().getData()+", percent == " + String.valueOf(root.getRight().getPercent()));
	}
}
