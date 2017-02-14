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
			p.setPriority(util.countProb(sb, c));
			p.setData(c);
			pList.add(p);
			
			countArr[i] = util.countProb(sb, c++);
			System.out.println("countArr["+String.valueOf(i)+"] == " + countArr[i]);
		}
		
		int min = 0;
		for(int i=0; i<pList.size(); i++){
			min = pList.get(i).getPriority();
			for(int j=i+1; j<pList.size(); j++){
				if(min > pList.get(j).getPriority()){
					Collections.swap(pList, i, j);
				}
			}
		}
		
		System.out.println("priority");
		for(Priority p : pList){
			System.out.println(String.valueOf(p.getPriority()) + " ");
		}
		
//		int min,minIdx =0;
//		for(int i=0; i<countArr.length; i++){
//			min = countArr[i];
//			for(int j=i+1; j<countArr.length; j++){
//				if(min>countArr[j]){
//					min = countArr[j];
//					minIdx = j;
//				}
//			}
//			Priority p = new Priority();	
//		}
		
		System.out.println();
		Node root = new Node("root",123);
		root.setLeft(new Node("A",11));
		root.setRight(new Node("B",12));
		
//		System.out.println();
//		System.out.println("root == " + root.getData());
//		System.out.println("left == " + root.getLeft().getData()+", percent == " + String.valueOf(root.getLeft().getPercent()));
//		System.out.println("right == " + root.getRight().getData()+", percent == " + String.valueOf(root.getRight().getPercent()));
	}
}
