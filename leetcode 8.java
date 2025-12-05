class Solution {
    public int myAtoi(String s) {
        long result = 0;
        boolean isNegative = false;

        s = s.trim();
        if (s.isEmpty()) return 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Handle sign at index 0 only
            if (i == 0) {
                if (c == '-') {
                    isNegative = true;
                    continue;
                }
                if (c == '+') continue;
            }

            // Stop on non-digit
            if (!Character.isDigit(c)) break;

            // Build number
            result = result * 10 + (c - '0');

            // Check overflow
            if (!isNegative && result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if (isNegative && -result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return isNegative ? (int)(-result) : (int)result;
    }
}
