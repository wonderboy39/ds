package advanced;

public class QuickSort {
	private int result,pivot,left,right;
	public QuickSort(int [] arr){
		pivot = 0;
		left = 1;
		right = arr.length-1;
		result = 0;
	}
	
	public static void main(String [] args){
		int [] arr = {4,5,2,1,7,3,6,8};
		QuickSort qs = new QuickSort(arr);
//		int partition_result = qs.partition(arr, 0, arr.length-1);
//		System.out.println("partition result :: " + String.valueOf(partition_result));
//		
//		qs.displayArrary(arr);
//		qs.partition(arr, 0, 1);
		qs.quick_sort(arr, 0, arr.length-1);
		qs.displayArrary(arr);
	}
	
	public void test_partition(int [] arr, int start, int end){
		int partition_result = partition(arr, start, end);
		System.out.println("partition result :: " + String.valueOf(partition_result));
		displayArrary(arr);
	}
	
	public int partition(int [] arr, int start, int end){
//		int result = 0;
//		int pivot = start;
//		int left = start+1;
//		int right = end;
		result = 0;
		pivot = start;
		left = start+1;
		right = end;
		
		while(left<=right){
			while(arr[left]<arr[pivot]) left++;
			while(arr[right]>arr[pivot]) right--;
			if(left<=right) swap(arr, left, right);
		}
//		System.out.println("");
//		System.out.println("right == " + String.valueOf(right));
//		System.out.println("left == " + String.valueOf(left));
//		System.out.println("pivot == " + String.valueOf(pivot));
//		displayArrary(arr);
//		System.out.println("");
		swap(arr, right, pivot);
		result = right;
		return result;
	}
	
	public void swap(int [] arr, int num1, int num2){
		int temp = arr[num1];
		arr[num1] = arr[num2];
		arr[num2] = temp;
	}
	
	public void quick_sort(int [] arr, int start, int end){
		if(start<end){
			int pos = partition(arr, start, end);
			quick_sort(arr, start, pos-1);
			quick_sort(arr, pos+1, end);
		}
	}
	
	public void displayArrary(int [] arr){
		for(int i=0; i<arr.length;i++){
			System.out.print(arr[i] + " ");
		}
	}
	
}
