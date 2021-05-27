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

// public ListNode reverseBetween(ListNode head, int left, int right) {
//         if(head == null || head.next == null){
//             return head;
//         }
//         int li = left;
//         int ri = right;
//         while(li < ri){
//             ListNode left1 = getNodeAt(head, li);
//             ListNode right1 = getNodeAt(head, ri);
//             int temp = left1.val; 
//             left1.val = right1.val;
//             right1.val = temp;
//             li++;
//             ri--;       
//         }
//         return head;
//     }
    
//     public ListNode getNodeAt(ListNode head, int pos){
//         ListNode temp = head;
//         for(int i = 0; i < pos - 1; i++){
//             temp = temp.next;
//         }
//         return temp;
//     }
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        // Empty list
        if(head == null){
            return null;
        }
        
        ListNode prev = null; 
        ListNode curr = head;
        
        while(m > 1){
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }
        
        ListNode reverseHead = prev;
        ListNode reverseTail = curr;
        ListNode pointer = null;
        while(n > 0){
            pointer = curr.next;
            curr.next = prev;
            prev = curr; 
            curr = pointer;
            n--;
        }
        
        if(reverseHead == null){
            head = prev;
        }else{
            reverseHead.next = prev;
        }
        
        reverseTail.next = curr;
        return head;
    }
}