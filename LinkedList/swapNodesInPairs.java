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
// LINK CHANGING METHOD
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode root = head;
        while (root != null && root.next != null) {
            ListNode nextPair = root.next.next;
            ListNode newRoot = root.next;
            root.next = nextPair;
            newRoot.next = root;
            pre.next = newRoot;
            pre = root;
            root = nextPair; 
            
        }
        return dummy.next;
        
    }
}


// POINTER METHOD
// class Solution {
//     public ListNode swapPairs(ListNode head) {
//         if(head == null || head.next == null){
//             return head;
//         }
//         ListNode fast = head.next;
//         ListNode slow = head;
        
//         int temp = slow.val;
//         slow.val = fast.val;
//         fast.val = temp;
        
//         while(slow.next.next != null){
//             if(fast.next.next != null){
//                 slow = slow.next.next;
//                 fast = fast.next.next;

//                 temp = slow.val;
//                 slow.val = fast.val;
//                 fast.val = temp;
//             }else{
//                 break;
//             }
//         }
        
//         return head;
//     }
// }