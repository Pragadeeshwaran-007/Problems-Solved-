class Solution {
    private int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int left = grid[0][0], right = n * n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean[][] visited = new boolean[n][n];
            if (canReach(grid, 0, 0, mid, visited)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canReach(int[][] grid, int x, int y, int t, boolean[][] visited) {
        int n = grid.length;
        if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || grid[x][y] > t) 
            return false;
        if (x == n - 1 && y == n - 1) return true;

        visited[x][y] = true;
        for (int[] dir : dirs) {
            if (canReach(grid, x + dir[0], y + dir[1], t, visited)) return true;
        }
        return false;
    }
}

