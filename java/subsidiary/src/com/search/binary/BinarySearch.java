package com.search.binary;

import com.utils.print.PrintUtil;

public class BinarySearch {
	public static void main(String [] args){
		int [] arr = {9,8,5,4,2,3,1,6,7};
		BinarySearch b = new BinarySearch();
		b.quicksort(arr, 0, arr.length-1);
		System.out.println("RESULT >> ");
		PrintUtil.printArr(arr);
		
		int result = b.binarySearch(arr, 6);
		if(result != -1){
			System.out.println("FOUND.");
			System.out.println("arr[" + result +"] : " + arr[result]);
		}
		else{
			System.out.println("Not found.");
		}
	}
	
	public void quicksort(int [] arr, int start, int end){
		if(start<end){
			int pivot = partition(arr, start, end);
			quicksort(arr, start, pivot-1);
			quicksort(arr, pivot+1, end);
		}
	}
	
	public int partition(int [] arr, int start, int end){
		int pivot = start;
		int left = start+1;
		int right = end;
		int result = -1;
		
		while(left<right){
			if(arr[left]<arr[pivot] && left<end) left++;
			if(arr[right]>arr[pivot] && right>start) right--;
			if(left<right) swap(arr, left, right); 
		}
		
		swap(arr, right, pivot);
		result = right;
		return result;
	}
	
	public void swap (int [] arr, int num1, int num2){
		int temp = arr[num1];
		arr[num1] = arr[num2];
		arr[num2] = temp;
	}
	
	// 재귀를 사용하지 않는 이진탐색의 예 
	public int binarySearch(int [] arr, int target){
		int start = 0;
		int end = arr.length-1;
		int result = -1;
		while(start<=end){
			int mid = (start+end)/2;
			if (target>arr[mid]) start = mid+1;
			else if(target<arr[mid]) end = mid-1;
			else{
				result = mid;
				return result;
			}
		}
		return result;
	}
	
	// 재귀를 사용하는 예 - 내일!!!
	public int rbinarySearch(int [] arr, int target ){
		int result = -1;
		return result;
	}
	
	// List를 사용할 경우의 binarySearch
	
}
