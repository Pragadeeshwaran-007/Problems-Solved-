/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
       
       if(lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(ListNode nodes : lists){

            if(nodes != null ) pq.add(nodes);
        }

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while(!pq.isEmpty()){

            ListNode node = pq.poll();

            tail.next = node;
            tail = tail.next;
            if(node.next != null){
                pq.add(node.next);
            }


        } 
        return dummy.next;

    }
}