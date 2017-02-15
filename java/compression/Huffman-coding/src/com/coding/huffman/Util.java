package com.coding.huffman;

import java.util.Collections;
import java.util.List;

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
	
	public void sortingList(List<Priority> pList){
		float min = 0;
		for(int i=0; i<pList.size(); i++){
			min = pList.get(i).getPriority();
			for(int j=i+1; j<pList.size(); j++){
				if(min>pList.get(j).getPriority()){
					min = pList.get(j).getPriority();
					Collections.swap(pList, i, j);
				}
			}
		}
	}
	
	public void printList(List<Priority> pList){
		// print priority list
		for(Priority p : pList){
			System.out.println("priority : " + String.valueOf(p.getPriority()) + " , " + p.getData());
		}
	}
	
	public Node buildingTree(List<Priority> pList){
		// Node 내부에 Priority타입을 가리킬수 있는 객체를 선언해서 사용하도록 수
		Node left = new Node(String.valueOf(pList.get(0).getData()));
		Node right = new Node(String.valueOf(pList.get(1).getData()));
		Node root = new Node("sum");
		
		Priority p = new Priority();
		p.setData('-');
		p.setPriority(pList.get(0).getPriority() + pList.get(1).getPriority());
		
		pList.remove(0);
		pList.remove(0);
		root.setLeft(left);
		root.setRight(right);
		
		pList.add(p);
		sortingList(pList);
		System.out.println();
		printList(pList);
		
		return root;
	}
}
