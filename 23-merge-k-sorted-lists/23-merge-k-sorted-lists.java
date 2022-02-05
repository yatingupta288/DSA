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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            ListNode dummy = new ListNode();
            return dummy.next;
        }
        return mergeListHelper(lists, 0, lists.length - 1);
    }
    
    public ListNode mergeLL(ListNode c1, ListNode c2){
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while(c1 != null && c2 != null){
            if(c1.val < c2.val){
                p.next = c1;
                c1 = c1.next;
            }else{
                p.next = c2;
                c2 = c2.next;
            }
            
            p = p.next;
        }
        
        p.next = c1 == null ? c2 : c1;
        
        return dummy.next;
    }
    
    public ListNode mergeListHelper(ListNode[] lists, int lo, int hi){
        if(lo == hi){
            return lists[lo];
        }
        int mid = (lo + hi )/2;
        ListNode l1 = mergeListHelper(lists, lo, mid);
        ListNode l2 = mergeListHelper(lists, mid + 1, hi);

        return mergeLL(l1, l2);
    }
}