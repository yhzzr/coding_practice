/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        if(head.val > head.next.val){
            int temp = head.next.val;
            head.next.val = head.val;
            head.val = temp;
        }
        ListNode node = head.next.next;
        head.next.next = null;
        return insertion(head, node);
    }
    
    private ListNode insertion(ListNode head, ListNode node){
        if(node == null) return head;
        ListNode dummyHead = new ListNode(0);
        ListNode newNode = node.next;
        dummyHead.next = head;
        head = dummyHead;
        while(head.next != null && head.next.val < node.val)
            head = head.next;
        node.next = head.next;
        head.next = node;
        return insertion(dummyHead.next, newNode);
    }
}