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
    public ListNode insertionSortList(ListNode head) {
                
        ListNode headSort = new ListNode();
        while(head != null){
            
            ListNode pSort = headSort;
            while(pSort.next != null && pSort.next.val < head.val)
                pSort = pSort.next;
            ListNode nextSort = pSort.next;
            pSort.next = head;
            head = head.next;
            pSort.next.next = nextSort;                
        }        
        return headSort.next;
    }
}
