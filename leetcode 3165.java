class Solution {

    static long ans[][][];
    static int n;
    static int arr[];

    static void buildTree(int l, int r, int idx){
        if(l==r){
            ans[idx][0][0] = 0;
            ans[idx][0][1] = ans[idx][1][0] = -(long)(1e12);
            ans[idx][1][1] = (long)arr[l];
            return;
        }

        int mid = l + (r - l) / 2;
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        buildTree(l, mid, left);
        buildTree(mid + 1, r, right);

        ans[idx][0][0] = Math.max(ans[left][0][0] + ans[right][0][0],
                          Math.max(ans[left][0][0] + ans[right][1][0],
                                   ans[left][0][1] + ans[right][0][0]));
        ans[idx][0][1] = Math.max(ans[left][0][0] + ans[right][0][1],
                          Math.max(ans[left][0][0] + ans[right][1][1],
                                   ans[left][0][1] + ans[right][0][1]));
        ans[idx][1][0] = Math.max(ans[left][1][0] + ans[right][0][0],
                          Math.max(ans[left][1][0] + ans[right][1][0],
                                   ans[left][1][1] + ans[right][0][0]));
        ans[idx][1][1] = Math.max(ans[left][1][0] + ans[right][0][1],
                          Math.max(ans[left][1][0] + ans[right][1][1],
                                   ans[left][1][1] + ans[right][0][1]));
    }

    static void update(int l, int r, int idx, int val, int pos){
        if(l == r){
            ans[idx][0][0] = 0;
            ans[idx][0][1] = ans[idx][1][0] = -(long)(1e12);
            ans[idx][1][1] = (long)val;
            return;
        }

        int mid = l + (r - l) / 2;
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        if(mid >= pos) update(l, mid, left, val, pos);
        else update(mid + 1, r, right, val, pos);

        ans[idx][0][0] = Math.max(ans[left][0][0] + ans[right][0][0],
                          Math.max(ans[left][0][0] + ans[right][1][0],
                                   ans[left][0][1] + ans[right][0][0]));
        ans[idx][0][1] = Math.max(ans[left][0][0] + ans[right][0][1],
                          Math.max(ans[left][0][0] + ans[right][1][1],
                                   ans[left][0][1] + ans[right][0][1]));
        ans[idx][1][0] = Math.max(ans[left][1][0] + ans[right][0][0],
                          Math.max(ans[left][1][0] + ans[right][1][0],
                                   ans[left][1][1] + ans[right][0][0]));
        ans[idx][1][1] = Math.max(ans[left][1][0] + ans[right][0][1],
                          Math.max(ans[left][1][0] + ans[right][1][1],
                                   ans[left][1][1] + ans[right][0][1]));
    }

    public int maximumSumSubsequence(int[] nums, int[][] q) {
        long mod = (long)(1e9) + 7;
        arr = nums;
        n = arr.length;
        ans = new long[4 * n][2][2];

        buildTree(0, n - 1, 0);
        long res = 0;
        for(var a : q){
            int pos = a[0];
            int val = a[1];
            update(0, n - 1, 0, val, pos);

            long x = Math.max(ans[0][0][0],
                      Math.max(ans[0][0][1],
                      Math.max(ans[0][1][0], ans[0][1][1]))) % mod;
            res = (res + x) % mod;
        }
        return (int)res;
    }
}
