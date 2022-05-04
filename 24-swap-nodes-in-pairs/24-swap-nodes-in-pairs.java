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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(pre.next != null && pre.next.next != null){
            ListNode node = pre.next;
            ListNode pairNode  = node.next;
            node.next = pairNode.next;
            pairNode.next = pre.next;
            pre.next = pairNode;
            // pairNode = node.next;
            pre = node;
        }
        return dummy.next;
    }
}