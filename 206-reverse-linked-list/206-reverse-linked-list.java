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
    // iteration
    // public ListNode reverseList(ListNode head) {
    //     if(head == null)
    //         return null;
    //     ListNode res = head, next = head.next;
    //     res.next = null;
    //     while(next != null){
    //         head = next; 
    //         next = head.next;
    //         head.next = res;
    //         res = head; 
    //     }
    //     return res;    
    // }
    
    // recursion
//     public ListNode reverseList(ListNode head) {
//         return reverseList(null, head);
//     }
    
//     public ListNode reverseList(ListNode pre, ListNode cur) {
//         if(cur == null)
//             return pre;
//         ListNode res = reverseList(cur, cur.next);
//         cur.next = pre;
//         return res;
//     }
    
// iteration

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
// // recursion
//     public ListNode reverseList(ListNode head) {
//         return reverseList(null, head);
//     }

//     private ListNode reverseList(ListNode prev, ListNode cur) {
//         if (cur == null)
//             return prev;
//         ListNode next = cur.next;
//         cur.next = prev;
//         return reverseList(cur, next);
//     }
}






