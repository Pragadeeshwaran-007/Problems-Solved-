import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
                        Scanner s1 = new Scanner(System.in);
        int n = s1.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = s1.nextInt();
        }
        int left = 0;
        int right =1;
        while(right<n){
            if(arr[right]!=0){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                right++;
                left++;
            }
            else{
                right++;
            }
        }
        for(int num : arr){
            System.out.print(num + " ");
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}