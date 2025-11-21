class Solution {
    public boolean isPossible(int[] target) {
        int n = target.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;

        for (int num : target) {
            sum += num;
            pq.offer(num);
        }

        while (true) {
            int max = pq.poll();
            long rest = sum - max;

            if (rest == 1 || max == 1) {
                return true;
            }
            if (rest == 0 || rest >= max) {
                return false;
            }

            long prev = max % rest;
            if (prev == 0) {
                return false;
            }

            sum = rest + prev;
            pq.offer((int) prev);
        }
    }
}