public class SubArraySum{


	public static int sumSub(int[] arr , int k){


		int count =0;

		for(int i = 0; i < arr.length; i++){

			int total =0;
			
			for(int j = i;j < arr.length; j++){

				total+=arr[j];
				
				if(total == k){
				
				count++;

				}
			
			}


		}
		return count;


	}


	public static void main(String[] args){


		int[] arr = {1,2,3,-1,5};

		int target = 5;	
	
		System.out.println("The sum of subarray of "+ target +" is the count of : "+sumSub(arr,target));



	}

}