public class MergeSort{


	public static void main(String[] args){


		int[] arr = {8,7,2,1,9,37,32};
		System.out.println("Before Sorting");
		
		for(int num : arr){

			System.out.print(num + " ");
		}
		System.out.println();
	
		mergesort(arr,0,arr.length-1);

		System.out.println("After Sorting");

		for(int num : arr){

			System.out.print(num + " ");
		}




	}

	public static void mergesort(int[] arr, int l , int r){
		if(l < r){

			int mid = (l+r)/2;

			mergesort(arr, l , mid);
			mergesort(arr, mid+1,r);

			merge(arr, l, mid, r);
		}
	}



	public static  void merge(int[] arr, int l,int mid ,int r){
		
		int n1 = mid - l + 1;
		
		int n2 = r - mid;

		int[] left = new int[n1];

		int[] right = new int[n2];

		for(int i=0;i<n1;i++){

			left[i] = arr[l+i];
		}

		for(int i = 0; i < n2; i++){

			right[i] = arr[mid+1+i];

		}


		int i = 0;
		int j = 0;
		int k = l;

		while(i < n1 && j< n2){
	
			if(left[i] <= right[j]){

				arr[k] = left[i++]; 		
			}
			
			else{

				arr[k] = right[j++];
			}

			k++;


		}
		while(i<n1){

			arr[k++] = left[i++];
	
		}

		while(j<n2){

			arr[k++] = right[j++];		

		}	



	}


}