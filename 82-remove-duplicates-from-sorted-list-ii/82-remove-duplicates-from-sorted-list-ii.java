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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(-101, head);
        ListNode pre = res;
        boolean isDuplicate;
        while(pre.next != null){
            ListNode cur = pre.next;
            isDuplicate = false;
            while(cur.next != null && cur.val == cur.next.val){
                cur.next = cur.next.next;
                isDuplicate = true;                
            }
            if(isDuplicate)
                pre.next = cur.next;
            else
                pre = pre.next;
        }
        return res.next;
    }
}