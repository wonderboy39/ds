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
	private int result, pivot, left, right;
	public FindSubK(int [] arr){
		pivot = 0;
		left = 1;
		right = arr.length-1;
		result = 0;
	}
	
	
	public int partition(int [] arr, int start, int end){
		result = 0;
		pivot = start;
		left = start+1;
		right = end;
		
		while(left<right){
			while(arr[left]<arr[pivot] && left<end) left++;
			while(arr[right]>arr[pivot] && right>start) right--;
			if(left<right) swap(arr, left, right);
		}
		
		swap(arr, right, pivot);
		result = right;
		return result;
	}
	
	public void quick_sort(int [] arr, int start, int end){
		if(start<end){
			int pos = partition(arr, start, end);
			quick_sort(arr, start, pos-1);
			quick_sort(arr, pos+1, end);
		}
	}
	
	public void swap(int [] arr, int left, int right){
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	public void displayArr(int [] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(String.valueOf(arr[i]) + " ");
		}
		System.out.println();
	}
	
	public static void main(String [] args){
		int [] arr = null;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("배열의 길이, 차 입력 : ");
		int range = scanner.nextInt();
		int k = scanner.nextInt();
		
		System.out.print("배열 요소 입력 ("+ range +"개) : ");
		arr = new int[range];
		FindSubK f = new FindSubK(arr);
		for(int i=0; i<range; i++){
			arr[i] = scanner.nextInt();
		}
		
		f.quick_sort(arr, 0, arr.length-1);
		f.displayArr(arr);
		
		int count = 0;
		
//		이진 탐색으로 고쳐야 하는 부분.
//		arr[i=0~n]에 대해서 arr[j=i+1~ n]과의 차가 k인 정수의 갯수를 카운팅
//		현재 2중 for문으로 인해 n^2의 시간복잡도를 보이고 있다. 
//		이를 개선하기 위해서는 조금 더 개선된 탐색 기법이 필요하다.
//		조금 더 개선된 기법인 이진탐색으로 고쳐야 한다!!!
//		for(int i=0; i<range; i++){
//			for(int j=i+1; j<range; j++){
//				int sub = arr[i] - arr[j];
//				if(sub==k || sub== (-1) * k){
//					count++;
//				}
//			}
//		}
		
		System.out.println("차가 " + String.valueOf(k) + "인 정수의 갯수 :: " + String.valueOf(count));
		System.out.println("/n테스트 종료.");
	}
}
