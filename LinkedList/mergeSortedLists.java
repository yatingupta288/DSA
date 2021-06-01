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
// ITERATIVE:
class Solution {
    public ListNode mergeTwoLists_(ListNode l1, ListNode l2) {
        ListNode p, dummy = new ListNode(0);
        p = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        if(l1.val > l2.val){
            l2.next =  mergeTwoLists(l1, l2.next);
            return l2;
        }else{
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }
}