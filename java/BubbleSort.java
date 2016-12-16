
public class BubbleSort {
	public static void main(String [] args){
		int [] arr = {1,5,2,4,3,6};
		
		System.out.println("Unordered result : ");
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]);
			if(i!=arr.length-1) System.out.print(", ");
		}
		System.out.println("");
		for(int i=0; i<arr.length; i++){
			for(int j=i+1; j<arr.length-1; j++){
				if(arr[i] > arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println("ordered result : ");
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]);
			if(i!=arr.length-1) System.out.print(", ");
		}
		System.out.println("");
	}
}
