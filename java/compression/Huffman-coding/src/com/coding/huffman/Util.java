package com.coding.huffman;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
	
	public void sortingList_org(List<Priority> pList){
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
	
	public void sortingList(List<Priority> pList){
		float min = 0.0f;
		for(int i=0; i<pList.size(); i++){
			min = pList.get(i).getPriority();
			for(int j=i+1; j<pList.size(); j++){
				if(min>=pList.get(j).getPriority()){
					if(min==pList.get(j).getPriority()){
						if(pList.get(i).getData()>pList.get(j).getData()){
							min = pList.get(i).getPriority();
							Collections.swap(pList, i, j);
						}
					}
					else{
						min = pList.get(j).getPriority();
						Collections.swap(pList, i, j);
					}
				}
			}
		}
	}
	
	public void printList(List<Priority> pList){
		// print priority list
		for(Priority p : pList){
			System.out.println("priority : " + String.valueOf(p.getPriority()) + "\t, " + p.getData());
		}
	}
	
	public Node buildingTree_test(List<Priority> pList){
		// Node 내부에 Priority타입을 가리킬수 있는 객체를 선언해서 사용하도록 수정
		float sum = pList.get(0).getPriority() + pList.get(1).getPriority();
		
		Node left = new Node(String.valueOf(pList.get(0).getData()));
		left.setPriority(pList.get(0).getPriority(), pList.get(0).getData());
//		left.setPriority(pList.get(0));

		Node right = new Node(String.valueOf(pList.get(1).getData()));
		right.setPriority(pList.get(1).getPriority(), pList.get(1).getData());
//		right.setPriority(pList.get(1));
		
		Node root = new Node("sum");
		Priority p = new Priority();
		p.setData('-');
		p.setPriority(sum);
		root.setPriority(p);
		
		pList.remove(0);
		pList.remove(0);
		root.setLeft(left);
		root.setRight(right);
		
		pList.add(p);
		sortingList(pList);
//		System.out.println();
//		printList(pList);
		
		System.out.println();
		System.out.println("root = " + root.getPriority().getPriority());
		System.out.println("left = " + root.getLeft().getPriority().getPriority());
		System.out.println("right = " + root.getRight().getPriority().getPriority());
		return root;
	}
	
	public Node buildingTree(List<Priority> pList){
		// Node 내부에 Priority타입을 가리킬수 있는 객체를 선언해서 사용하도록 수정
		Node root = null;
		Node left = null;
		Node right = null;
		while(pList.size()!=1){
			float sum = pList.get(0).getPriority() + pList.get(1).getPriority();
			
			left = new Node(String.valueOf(pList.get(0).getData()));
			left.setPriority(pList.get(0).getPriority(), pList.get(0).getData());

			right = new Node(String.valueOf(pList.get(1).getData()));
			right.setPriority(pList.get(1).getPriority(), pList.get(1).getData());
			
			root = new Node("sum");
			Priority p = new Priority();
			p.setData('-');
			p.setPriority(sum);
			root.setPriority(p);
			
			pList.remove(0);
			pList.remove(0);
			root.setLeft(left);
			root.setRight(right);
			
			pList.add(p);
			sortingList(pList);
		}
		System.out.println();
		System.out.println("root = " + root.getPriority().getPriority());
		System.out.println("left = " + root.getLeft().getPriority().getPriority());
		System.out.println("right = " + root.getRight().getPriority().getPriority());
		return root;
	}
	
	public Priority copyPriority(Priority input){
		Priority result = null;
		try {
			Class parameterTypes[] = new Class[2];
			parameterTypes[0] = Float.class;
			parameterTypes[1] = String.class;
			Constructor<?> classLink = Class.forName("Priority").getConstructor(parameterTypes);
			
			Object parameterTypesValue [] = new Object[2];
			parameterTypesValue[0] = new Float(input.getPriority());
			parameterTypesValue[1] = new String(String.valueOf(input.getData()));
			result = (Priority) classLink.newInstance(parameterTypesValue);
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
