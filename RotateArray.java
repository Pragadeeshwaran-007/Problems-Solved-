import java.util.*;

public class RotateArray{


	public static void rotate(int[] arr ,int k){

		reverse(arr , 0 , arr.length-1);
		reverse(arr , 0, k-1);
		reverse(arr , k, arr.length-1);


			
	}

	public static void reverse(int[] arr , int start , int end){

		while(start<end){
			int temp = arr[start];
			arr[start] = arr[end];	
			arr[end] = temp;
			start++;
			end--;
		}

		
	}

	public static void main(String[] args){

		
		int[] arr = {1,2,3,4,5,6,7,8,9,10};

		rotate(arr,4);
		
		System.out.println(Arrays.toString(arr));



	}


}