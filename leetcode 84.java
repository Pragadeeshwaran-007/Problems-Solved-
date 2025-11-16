class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i =0 ; i < n ; i++){    
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int h = heights[stack.pop()];
                int  left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;
                int w = (right - left - 1);
                int area = h * w;

                if(area > max){
                    max = area;
                }
                
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int h = heights[stack.pop()];
            int left = stack.isEmpty() ? -1 : stack.peek();
            int right = n;
            int w = right - left -1;
            int area = h*w;

            if(area > max) max = area;
        }

        return max;
    }
}