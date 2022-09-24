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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;
        int len = findLenAndConnectEndToBegin(head);
        int rotate = k % len;
        int step = len - rotate - 1;
        while(step-- > 0)
            head = head.next;
        ListNode res = head.next;
        head.next = null;
        return res; 
    }
    public int findLenAndConnectEndToBegin(ListNode head){
        
        ListNode p = head;
        int res = 1;
        while(p.next != null){
            
            p = p.next;
            res++;
        }
        p.next = head;
        return res;
    }
}