class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        // Find first & last occurrences
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            first[c] = Math.min(first[c], i);
            last[c] = i;
        }

        int res = 0;

        // Check each character as the outer characters of the palindrome
        for (int c = 0; c < 26; c++) {
            int L = first[c];
            int R = last[c];

            if (R - L < 2) continue;  // not enough space for middle char

            boolean[] memo = new boolean[26];

            // Count unique middle characters
            for (int i = L + 1; i < R; i++) {
                int idx = s.charAt(i) - 'a';
                if (!memo[idx]) {
                    memo[idx] = true;
                    res++;
                }
            }
        }

        return res;
    }
}