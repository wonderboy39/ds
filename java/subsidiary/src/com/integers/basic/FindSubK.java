package com.integers.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author soon
 * 1) 입력받을 때 해당 정수에 대해 2/-2차이가 값을 Map<Integer index, ArrayList<Integer>>에 저장,  (x)
 * 	  다음 입력시에 입력값이 있을 경우 Map<Integer index, ArrayList<Integer>>에 저장한다.
 *    subMap	:: i : -2,2 ... 이런 형태는 별로 필요 없음
 *    resultMap ::  자기자신이 k만큼의 차이를 가지고 있으면 해당 인덱스에 대해 자기자신의 값을 resultMap에 저
 *    		3 : 1,3번째 인덱스
 *    		4 : 2 번째 인덱스 
 *    등등...
 *      
 * 2) 
 */

public class FindSubK {
	public static void main(String [] args){
		int [] arr;
		Scanner scanner = new Scanner(System.in);
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		Map<Integer, ArrayList<Integer>> subMap = new HashMap<Integer, ArrayList<Integer>>();
		Map<Integer, ArrayList<Integer>> resultMap = new HashMap<Integer, ArrayList<Integer>>();
//			인덱스 ,  차가 k인 정수들 
		int range = scanner.nextInt();
		int k = scanner.nextInt();
		
		System.out.print("배열 요소 입력 ("+ range +"개) : ");
		arr = new int[range];
		for(int i=0; i<range; i++){
			arr[i] = scanner.nextInt();
			
			if(resultMap.get(i).contains(arr[i])){
				//resultMap.get(i).contains(arr[i])
			}
			else{
				
			}
//			indexMap.put(i, arr[i]); // 그저 배열의 표현방식의 Map으로 변했을뿐 크게 달라진 표현은 아니다. 
			ArrayList<Integer> subList = new ArrayList<Integer>();
			subList.add(arr[i]-k);
			subList.add(arr[i]+k);
			subMap.put(i, subList);
			
		}

		int count = 0;
		// arr[i=0~n]에 대해서 arr[j=i+1~ n]과의 차가 k인 정수의 갯수를 카운팅  
		for(int i=0; i<range; i++){
			for(int j=i+1; j<range; j++){
				int sub = arr[i] - arr[j];
				if(sub==k || sub== (-1) * k){
					count++;
				}
			}
		}
		
		System.out.println("차가 " + String.valueOf(k) + "인 정수의 갯수 :: " + String.valueOf(count));
		System.out.println("/n테스트 종료.");
	}
}
