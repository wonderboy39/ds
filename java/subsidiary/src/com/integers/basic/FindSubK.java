package com.integers.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author soon
 * 1) 입력받은 배열을 quicksort로 정렬 
 * 2) 정렬 후 이진 탐색  
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
	
	public int binarySearch(int [] arr, int low, int high, int x){
		int result = -1;
		if(high >= low){
//			System.out.println("before binarySearch");
			int mid = low + (high - low)/2;
//			int mid = binarySearch(arr, low, high, x);
			System.out.println("(mid, low, high, x) : " + String.valueOf(mid) +","+
					String.valueOf(low) + "," + String.valueOf(high) + ","+ String.valueOf(x));
			if(x==arr[mid])
				return mid;
			if(x>arr[mid])
				return binarySearch(arr, (mid+1), high, x);
			else
				return binarySearch(arr, low, (mid-1), x);
		}
		return result;
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
//		f.displayArr(arr);
		
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
		
		int count = 0;
		for(int i=0; i<arr.length-1; i++){
			if(f.binarySearch(arr, i+1, arr.length-1, arr[i]+k)!=-1)
				count++;
			if(f.binarySearch(arr, i+1, arr.length-1, arr[i]-k)!=-1)
				count++;
		}
		
		System.out.println("차가 " + String.valueOf(k) + "인 정수의 갯수 :: " + String.valueOf(count));
		System.out.println("\n테스트 종료.");
	}
}
