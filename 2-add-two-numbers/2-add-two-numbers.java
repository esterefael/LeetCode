/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        // if(l1 == null)
        //     return l1;
        // if(l2 == null)
        //     return l2;
        ListNode head = new ListNode();
        ListNode p = head;
        int res = 0, addOnes = 0;
        while(l1 != null && l2 != null){
            
            res = l1.val + l2.val + addOnes;
            addOnes = res / 10;
            p.next = new ListNode(res % 10);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode l = l1 != null ? l1 : l2;
        while(l != null){
            
            res = l.val + addOnes;
            addOnes = res / 10;
            p.next = new ListNode(res % 10);
            p = p.next;
            l = l.next;          
        }
        if(addOnes > 0)
            p.next = new ListNode(addOnes);
        return head.next;
    }
}