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
    public ListNode mid(ListNode head){
        ListNode slow = null;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow == null ? head : slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }
    public ListNode merge(ListNode l1, ListNode l2){
        if(l1== null)return l2;
        if(l2 == null)return l1;
        if(l1.val > l2.val){
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode p = l1;
        while(l1 != null && l2 != null){
            ListNode prev = null;
            while(l1 != null && l1.val <= l2.val){
                prev = l1;
                l1 = l1.next;
            }
            prev.next = l2;
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        return p;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode midd = mid(head);
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(midd);
        
        return merge(l1 , l2);
    }
}