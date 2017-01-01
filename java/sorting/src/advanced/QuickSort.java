package advanced;

public class QuickSort {
	public static void main(String [] args){
		int [] arr = {4,5,2,1,7,3,6,8};
		QuickSort qs = new QuickSort();
		int partition_result = qs.partition(arr, 0, arr.length-1);
		System.out.println("partition result :: " + String.valueOf(partition_result));
		
		qs.displayArrary(arr);
//		qs.partition(arr, 0, 1);
	}
	
	public int partition(int [] arr, int start, int end){
		int result = 0;
		int pivot = start;
		int left = start+1;
		int right = end;
		
		while(left<=right){
			while(arr[left]<arr[pivot]) left++;
			while(arr[right]>arr[pivot]) right--;
			if(left<=right) swap(arr, left, right);
		}
//		System.out.println("");
		System.out.println("right == " + String.valueOf(right));
		System.out.println("left == " + String.valueOf(left));
		System.out.println("pivot == " + String.valueOf(pivot));
		displayArrary(arr);
		System.out.println("");
		swap(arr, right, pivot);
		result = right;
		return result;
	}
	
	public void swap(int [] arr, int num1, int num2){
		int temp = arr[num1];
		arr[num1] = arr[num2];
		arr[num2] = temp;
	}
	
	public void quick_sort(int [] arr,int start, int end){
		
	}
	
	public void displayArrary(int [] arr){
		for(int i=0; i<arr.length;i++){
			System.out.print(arr[i] + " ");
		}
	}
}






