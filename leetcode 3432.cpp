class Solution {
public:
    int countPartitions(vector<int>& nums) {
        int n = nums.size();
        int total = 0;
        for(int num : nums) total += num;
        int leftSum = 0 , rightSum = 0 , count  = 0;
        for(int i = 0 ;i < n-1 ; i++){
            int num = nums[i];
            leftSum += num;
            rightSum = total-leftSum;
            
            if((leftSum % 2) == (rightSum % 2)){
                count++;
            }
        }

        return count;  
    }
};
