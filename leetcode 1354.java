import java.util.*;

class Solution {
    public boolean isPossible(int[] target) {
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int x : target) {
            sum += x;
            pq.offer(x);
        }

        while (true) {
            int max = pq.poll();
            long rest = sum - max;

            if (max == 1 || rest == 1) return true; // all ones possible
            
            if (rest == 0 || rest >= max) return false;

            long prev = max % rest;
            if (prev == 0) return false;

            sum = rest + prev;
            pq.offer((int) prev);
        }
    }
}
