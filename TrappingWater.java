public class TrappingWater{

	public static int trapped(int[] arr){


		int left = 0, right = arr.length-1, leftMax = 0, rightMax = 0, trappedWater = 0;
	
		while(left < right){
		
			leftMax = Math.max(leftMax , arr[left]);
			rightMax = Math.max(rightMax , arr[right]);
			
			if(arr[left] <= arr[right]){

						
				trappedWater += leftMax - arr[left];
			
				left++;

			}
			else{ 

				trappedWater += rightMax - arr[right];

				right--;
			}

			// System.out.println(trappedWater);  this will give the vale of the stored water for each loop.


		}

		return trappedWater;
	
	}

	public static void main(String[] args){

		int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};

		System.out.println("The number of water blocked is : "+trapped(arr));



	}
}