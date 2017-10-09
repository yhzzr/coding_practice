/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if( head == null || head.next == null) return head;
        
        ListNode temp = head.next;
        head.next = temp.next;
        temp.next = head;
        head = temp;
        head.next.next  = swapPairs(head.next.next);
        return head;
    }
}