class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[n];
        for(int i = 0;i<n;i++){
            while(!stack.isEmpty() && heights[i] >= heights[stack.peek()]){
                res[stack.pop()]++;
            }
            if(!stack.isEmpty()){
                res[stack.peek()]++;
            }

            stack.push(i);
        }
        return res;
    }
}