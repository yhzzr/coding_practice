/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while( p1 != null ){
            p1 = p1.next;
            p2 = p2.next;
            if(p2 == null)     {return false;}
            else               {p2 = p2.next;}
            if(p2 == null)     {return false;}
            else if(p1 == p2)  {return true; }
        }
        return false;
    }
}