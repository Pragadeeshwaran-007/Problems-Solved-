class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        Arrays.fill(dp, 0);

        for (int num : nums) {
            int[] curr = Arrays.copyOf(dp, 3);
            for (int i = 0; i < 3; i++) {
                int newSum = curr[i] + num;
                dp[newSum % 3] = Math.max(dp[newSum % 3], newSum);
            }
        }

        return dp[0]; 
    }
}
