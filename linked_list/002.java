/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode result = new ListNode(0);
        result.next = null;
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode h3 = result;
        int carryon = 0;
        
        while(h1 !=null || h2 !=null) {
            int temp1 = 0;
            int temp2 = 0;
            if(h1 != null)
                temp1 = h1.val;
            if(h2 != null)
                temp2 = h2.val;
                
            h3.val = ( temp1 + temp2 + carryon) % 10;
            carryon = ( temp1 + temp2 + carryon)/10;
            
            if(carryon != 0) {
                h3.next = new ListNode(carryon);
                h3 = h3.next;
                h3.next = null;
                if(h1 != null)
                    h1 = h1.next;
                if(h2 != null)
                    h2 = h2.next;
            }
            else {
                if(h1 != null)
                    h1 = h1.next;
                if(h2 != null)
                    h2 = h2.next;
                if(h1 != null || h2 != null){
                    h3.next = new ListNode(carryon);
                    h3 = h3.next;
                    h3.next = null;
                }
            }
        }
        
        return result; 
    }
}