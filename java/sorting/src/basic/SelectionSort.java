package basic;

/**
 * @author soon
 * 선택정렬 :
 *  1) 목록에서 최소값을 찾는다.
 *  2) 찾은 최소값을 맨 앞의 값과 교체한다.
 *  3) 배열의 전체 요소가 정렬될 때까지 이 과정을 반복한다.
 */
public class SelectionSort {
	public static void main(String [] args){
		int [] arr = {1,5,2,4,3,6};
		int min = 0;
		
		// before sorting...
		System.out.println("before sorting...");
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
		
		for(int i=0; i<arr.length; i++){
			min = i;
			for(int j=i+1; j<arr.length; j++){
				if(arr[min]>arr[j]){
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		
		// after sorting...
		System.out.println("after sorting...");
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
	}
}
