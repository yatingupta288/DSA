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
    public ListNode reverseBetween(ListNode head, int n, int m) {
        if(head == null || head.next == null)return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode root = dummy;
        ListNode newroot = dummy;
        ListNode curr = null;
        while(n-- > 1){
            prev = prev.next;
            curr = prev;
            m--;
        }
        
        root = prev.next;
        newroot = root.next;
        
        while(m-- > 1){
            root.next = newroot.next;
            newroot.next = prev.next;
            prev.next = newroot;
            newroot = root.next;
        }
        if(curr == null){
            head = prev.next;
            
        }
        
        return head;
        
    }
}