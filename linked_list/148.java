/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode f = head.next.next;
        ListNode p = head;
        while (f != null && f.next != null) {
            p = p.next;
            f =  f.next.next;
        }
        ListNode h2 = sortList(p.next);
        p.next = null;
        return merge(sortList(head), h2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        ListNode head = new ListNode(0);
        ListNode p = head;
        
        while( p1 != null && p2 != null){
            if(p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
            }else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if(p1 != null) p.next = p1;
        if(p2 != null) p.next = p2;
        return head.next;
    }
}