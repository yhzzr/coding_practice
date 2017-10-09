/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return null;
        ListNode dummyhead = new ListNode(0);
        ListNode p1 = head;
        ListNode p2 = dummyhead;
        ListNode tail = head;
        boolean even = false;
        while(p1 != null){
            if(even){
                //remove even node and put it at the end of the new list
                ListNode temp = p1;
                tail.next = temp.next;
                temp.next = null;
                p2.next = temp;
                p2 = p2.next;
                //move p1 to next odd node, move tail depends on situation
                p1 = tail.next;
                if(p1!=null){
                    tail = p1;
                }
                //flip the bit
                even = !even;
            }else{
                p1 = p1.next;
                even = !even;
            }
        }
        
        //put new list to the next of tail
        tail.next = dummyhead.next;
        return head;
    }
}