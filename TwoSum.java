import java.util.*;
public class TwoSum{


	public static int[] twoSum(int[] arr , int target){
		
		int left = 0,right = arr.length-1;
		
		while(left<right){

		if(arr[left] + arr[right] == target) return new int[] {left , right};

		else if(arr[right]>target) right --;

		else left++;


		}


		return new int[] {};
	}
		

	public static void main (String[] args){

		int[] arr = {2,3,4,7,78,87};
		int target = 11;
		
		System.out.println(Arrays.toString(twoSum(arr,target)));

	}
}