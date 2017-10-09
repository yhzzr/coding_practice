/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode res = new ListNode(0);
        ListNode p = res;
        ListNode i = head;
        int temp = i.val;
        boolean unique = true;
        while(i.next!=null){
            if(i.next.val == i.val){
                unique=false;
            }else{
                if(unique==true){
                    ListNode node = new ListNode(temp);
                    p.next = node;
                    p = p.next;
                    temp = i.next.val;
                }else{
                    temp = i.next.val;
                    unique = true;
                }
            } 
            i=i.next;
        }
        if(unique){
            ListNode last = new ListNode(temp);
            p.next = last;
        }
        return res.next;
    }
}