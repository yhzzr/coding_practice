/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyhead1 = new ListNode(0);
        ListNode dummyhead2 = new ListNode(0);
        dummyhead1.next = head;

        ListNode p1 = dummyhead1;
        ListNode p2 = dummyhead2;
        while(p1.next!=null){
            if(p1.next.val >=x){
                ListNode temp = p1.next;
                p1.next = temp.next;
                temp.next=null;
                p2.next = temp;
                p2 = p2.next;
            }else{
                p1 = p1.next;
            }
        }
        p1.next = dummyhead2.next;
        return dummyhead1.next;
    }
}