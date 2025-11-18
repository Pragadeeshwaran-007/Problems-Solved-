class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : stones){
            pq.offer(num);
        }
        while(pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            int val = Math.abs(a-b);
            if(val != 0){
                pq.offer(val);
            }
        }

        return pq.size() == 0 ? 0: pq.poll();
    }
}