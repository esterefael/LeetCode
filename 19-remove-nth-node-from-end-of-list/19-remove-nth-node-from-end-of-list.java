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
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {     
        
//         int length = countNodes(head);
//         if(length == n)
//             return null;
//         ListNode p = head;
//         for(int i = 1; i < length - n; i++)
//             p = p.next;
//         p.next = p.next.next;
//         while(p.next != null)
//             p = p.next;
//         return head;
//     }
//     public int countNodes(ListNode head){
//         int cnt = 0;
//         while(head != null){
//             cnt++;
//             head = head.next;
//         }
//         return cnt;            
//     }
// }

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode sential = new ListNode(0, head), slow = sential, fast = head;
        while(n-- > 0)
            fast = fast.next;
        while(fast != null){
            
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return sential.next;
    }      
}


