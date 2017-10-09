/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2.next!=null && p2.next.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode preMiddle = p1;
        ListNode preCurrent = preMiddle.next;
        p2 = reverse(preCurrent);
        p1 = head;
        while(p1!=preMiddle){
            //need more inspection
            preMiddle.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=preMiddle.next;
        }
    }
    
    private ListNode reverse(ListNode head){
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