import java.util.*;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int [nums1.length+nums2.length];
        int index =0,left = 0,right = arr.length-1;
        double res;

        for(int nums : nums1){
            arr[index++] = nums; 
        }
        for(int nums : nums2){
            arr[index++] = nums;
        }
        Arrays.sort(arr);
        int mid = (left+right)/2;
        if((left+right)%2==0){
         
            return (double) arr[mid];
        }
        else{

            res = (double) (arr[mid]+arr[mid+1])/2;

        }
        return res;


    }
}