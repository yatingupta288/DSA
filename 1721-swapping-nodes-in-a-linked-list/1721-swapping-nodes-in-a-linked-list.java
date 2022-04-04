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
    public ListNode swapNodes(ListNode head, int k) {
        if(k == 0)return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        
        for(int i = 0; i < k; i++){
            second = second.next;
        }
        
        ListNode pos1 = second;
        
        while(second.next != null){
            second = second.next;
            first = first.next;
        }
        
        ListNode pos2 = first.next;
        
        int temp = pos1.val;
        pos1.val = pos2.val;
        pos2.val = temp;
        
        return dummy.next;
    }
}