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
//		int [] arr = {4,5,2,1,7,3,6,8};
		int [] arr = {5,3,2,4,8,1,6,7};
		QuickSort qs = new QuickSort(arr);
		qs.quick_sort(arr, 0, arr.length-1);
		qs.displayArrary(arr);
	}
	
	public void test_partition(int [] arr, int start, int end){
		int partition_result = partition(arr, start, end);
		System.out.println("partition result :: " + String.valueOf(partition_result));
		displayArrary(arr);
	}
	
	public int partition(int [] arr, int start, int end){
//		result,pivot,left,right는 member field로 선언해서 사용해야 
//		매 step마다의 재귀호출시에 result,pivot,left,right에 대한 증감연산이 기억된다.
		
//		int result = 0;
//		int pivot = start;
//		int left = start+1;
//		int right = end;
		result = 0;
		pivot = start;
		left = start+1;
		right = end;
		
		while(left<right){ //modified :: left == right일 경우를 거치는 것은 모호한 연산이므로 =연산 제거 
			// modified : 매 step마다 left, right 값의 상한/하한을 정해줘야 에러가 발생하지 않는다.
			while(arr[left]<arr[pivot] && left<end) left++;
			while(arr[right]>arr[pivot] && right>start) right--;
			if(left<right) // modified :: left == right일 경우를 거치는 것은 모호한 연산이므로 =연산 제
				swap(arr, left, right);
		}
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
