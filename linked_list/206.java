/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode tail = null;
        while(head!=null){
            ListNode newhead = head;
            head = head.next;
            newhead.next = tail;
            tail = newhead;
        }
        return tail;
    }
}