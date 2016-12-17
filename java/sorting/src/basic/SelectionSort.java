package basic;

/**
 * @author soon
 * 선택정렬 : 
 *  제자리 정렬 알고리즘이다.
 *  작은양의 데이터에 유용하다.
 *  key는 작고, value는 큰 데이터에 주로 사용된다.
 *  key를 기반으로 선택이 이루어지고 치환(swap)이 필요하다고 판단될때에 치환(swap)이 이루어진다.
 *  
 * 장점: 
 *  구현이 쉽다.
 *  제자리 정렬 알고리즘이다. (추가 저장 공간이 필요없다)
 * 단점:
 *  데이터의 양에 유연하지 않다.
 * 
 * 알고리즘 
 *  1) 목록에서 최소값을 찾는다.
 *  2) 찾은 최소값을 맨 앞의 값과 교체한다.
 *  3) 배열의 전체 요소가 정렬될 때까지 이 과정을 반복한다.
 */
public class SelectionSort {
	public static void main(String [] args){
		int [] arr = {1,5,2,4,3,6};
		
		// before sorting...
		System.out.println("before sorting...");
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
		
		int min = 0;
		for(int i=0; i<arr.length; i++){
			min = i;
			System.out.println("i:" + String.valueOf(i) + ", j:" + String.valueOf(i+1));
			for(int j=i+1; j<arr.length; j++){
				if(arr[min]>arr[j]){
					System.out.println("\t i=="+ String.valueOf(i) + ", j==" + String.valueOf(j));
					min = j;
				}
			}
//			if(min != i){
				System.out.println("min : "+ String.valueOf(min)+", val : " + arr[min]);
				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
				System.out.println("arr[i]::"+String.valueOf(arr[i]));
//			}
		}
		
		// after sorting...
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
	}
}
