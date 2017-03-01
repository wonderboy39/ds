package com.integers.basic;

import java.util.Scanner;

public class CenterBalance {
	public static void main(String [] args){
		int [] arr;
		int leftsum = 0;
		int rightsum = 0;
		boolean isCenterBalanced = false;
		
		System.out.print("테스트 횟수 입력 :: ");
		Scanner scanner = new Scanner(System.in);
		int numCase = scanner.nextInt();
		
		while(true){
			if(numCase == 0) break;
			System.out.print("테스트할 범위(range) 입력 :: ");
			int range = scanner.nextInt();
			scanner.nextLine();
			arr = new int [range];
			
			System.out.print("배열 요소 입력 (" + range + "개) :: ");
			for(int i=0; i<range; i++){
				arr[i] = scanner.nextInt();
			}
			
			int sum = 0;
			for(int i=0; i<range; i++){
				sum = arr[i] + sum;
			}
			
			for(int i=1; i<range; i++){
				// 배열의 좌측 합 구하기 [A1]+[A2]+...+[Ai-1]
				for(int temp = i; temp>0; temp--){
					leftsum = leftsum + arr[temp-1];
				}
				
				// 배열의 우측 합 구하기 [Ai+1]+[Ai+2]+...+[An]
				rightsum = sum - leftsum - arr[i];
				if(rightsum == leftsum){
					isCenterBalanced = true;
					System.out.println("YES");
					break;
				}
				leftsum = 0;
				rightsum = 0;
			}
			
			if(isCenterBalanced == true){
				isCenterBalanced = false;
			}else{
				System.out.println("NO");
			}
			
			numCase--;
		}
		System.out.println("\n무게중심 테스트 종료. ");
	}
}
