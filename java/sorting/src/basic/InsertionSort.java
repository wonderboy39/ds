package basic;

public class InsertionSort {
	public static void main(String [] args){
		int [] arr = {1,5,2,4,3,6};
		
		System.out.println("before sorting...");
		for(int i = 0; i<arr.length; i++){
			System.out.print(String.valueOf(arr[i]) + " ");
		}
		System.out.println("");
		
		for(int i = 0; i<arr.length; i++){
			for(int j=i+1; j-1>=0 && j<arr.length; j--){
				if(arr[j-1]>arr[j]){
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println("after sorting...");
		for(int i = 0; i<arr.length; i++){
			System.out.print(String.valueOf(arr[i]) + " ");
		}
		System.out.println("");
	}
}
