import java.util.*;

class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        long count = 0;
        ArrayList<Integer> st = new ArrayList<>(); // sorted list of seen values
        
        for (int i = 0; i < n; i++) {
            long val = (long) nums1[i] - nums2[i];
            
            // Count how many previous values <= val + diff
            int pos = upperBound(st, (int)(val + diff)); 
            count += pos; // all elements before 'pos' satisfy condition
            
            // Insert val into sorted position (maintain sorted order)
            int insertPos = orderOfKey(st, (int) val);
            st.add(insertPos, (int) val);
        }
        return count;
    }

    // Find how many elements < key
    private int orderOfKey(ArrayList<Integer> st, int key) {
        int pos = Collections.binarySearch(st, key);
        return pos < 0 ? -pos - 1 : pos;
    }

    // Find how many elements <= key
    private int upperBound(ArrayList<Integer> st, int key) {
        int pos = Collections.binarySearch(st, key);
        if (pos < 0) pos = -pos - 1;
        else {
            while (pos < st.size() && st.get(pos) == key) pos++;
        }
        return pos;
    }
}
