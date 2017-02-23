package com.utils.print;

public class PrintUtil {
	public static void printArr(int [] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(String.valueOf(arr[i]) + " ");
		}
		System.out.println();
	}
}
