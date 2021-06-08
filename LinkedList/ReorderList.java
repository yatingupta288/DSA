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
    
    public ListNode reverse(ListNode l2){
        if(l2 == null)return null;
        ListNode prev = null;
        ListNode curr = l2;
        ListNode next = l2.next;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
         if (head == null || head.next == null)
                return;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = head;
        ListNode l2 = reverse(slow);
        
        while(l2 != null){
            ListNode next = l1.next;
            l1.next = l2;
            l1 = l2; //OR l1.next;l2 is faster
            l2 = next;
        }
    }
}

 class Solution2 {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null)
                return;

            // 1. Middle of the list
            ListNode slow = head, fast = slow.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // 2. Add Second Half list nodes in Stack
            Stack<ListNode> stack = new Stack();
            ListNode current = slow.next;
            slow.next = null;
            while (current != null) {
                stack.push(current);
                current = current.next;
            }

            // 3. Merge Stack Nodes in first half Alternate Nodes
            current = head;
            while (stack.size() > 0) {
                stack.peek().next = current.next;
                current.next = stack.pop();
                current = current.next.next;
            }
        }
    }
}