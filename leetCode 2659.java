class Solution {
    public long countOperationsToEmptyArray(int[] nums) {
        Map<Integer , Integer> map =  new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
        }
        long n = nums.length;
        Arrays.sort(nums);
        long val =0,res =n;
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i]) < val){
                res += n-i;
            }
            val = map.get(nums[i]);
        }
        return res;
    }
}