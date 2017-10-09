/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode p1 = head;
        ListNode p2 = head;
        while( p2.next != null && p2.next.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        p1 = p1.next;
        ListNode head2 = reverseList(p1);
        while( head2 != null){
            if(head.val != head2.val) return false;
            else{
                head = head.next;
                head2 = head2.next;
            }
        }
        return true;
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while( head != null){
            ListNode node = head.next;
            head.next = newHead;
            newHead = head;
            head = node;
        }
        return newHead;
    }
}