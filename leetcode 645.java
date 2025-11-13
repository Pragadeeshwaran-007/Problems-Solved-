class Solution {
    public int[] findErrorNums(int[] arr) {
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        int duplicate = 0,sum =0;
        for(int num  : arr ){
            if(set.contains(num)){
                duplicate = num;
            }
            set.add(num);
            sum += num;
        }
        int total  = n*(n+1)/2;
        int missing = total - (sum - duplicate); 

        return new int[] {duplicate , missing};
    }
}