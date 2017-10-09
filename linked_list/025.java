/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) return head;
        
        int count = 0;
        ListNode ptr = head;
        
        //count the number of nodes in the list
        while(ptr!=null){
            count++;
            ptr = ptr.next;
        }
        
        //determine the number of loops to run
        int n = count/k;
        
        //initialize dummy head;
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = null;
        //initialize dummy tail
        ListNode tail = dummyhead;
        
        //start the loop to reverse the linked list
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                ListNode temp = head;
                head = head.next;
                temp.next = tail.next;
                tail.next = temp;
            }
            while(tail.next!=null){
                tail = tail.next;
            }
        }
        tail.next = head;
        return dummyhead.next;
    }
}