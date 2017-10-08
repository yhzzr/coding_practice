/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i=0;i<lists.length;i++){
            ListNode head = lists[i];
            while(head!=null){
                heap.add(head.val);
                head = head.next;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(heap.size()!=0){
            int value = heap.poll();
            ListNode node = new ListNode(value);
            p.next = node;
            p = p.next;
        }
        return dummy.next;
    }
}