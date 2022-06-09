/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Inorder Morris traversal is used to recover the tree in O(1) space 
// but to do this we can also use simple recursive inorder and two pointer approach to recover the tree.
class Solution {
    // private TreeNode first = null;
    // private TreeNode second = null;
    // private TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public TreeNode rightmost(TreeNode curr, TreeNode leftNode){
        while(leftNode.right!= null && leftNode.right != curr){
            leftNode= leftNode.right;
        }
        
        return leftNode;
    }
    public void recoverTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode a = null;
        TreeNode b = null;
        while(curr != null){
            TreeNode leftNode = curr.left;
            if(leftNode == null){
                if(prev != null && prev.val > curr.val){
                    if(a == null){
                        a = prev;
                    }
                    b = curr;
                }
                prev = curr;
                curr = curr.right;
            }else{
                TreeNode rightmost = rightmost(curr, leftNode);
                if(rightmost.right == null){
                    rightmost.right = curr;
                    curr = curr.left;
                }else{
                    rightmost.right = null;
                    if(prev != null && prev.val > curr.val){
                        if(a == null){
                            a = prev;
                        }
                        b = curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        
        if(a != null && b != null){
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }
    }
}

// class Solution {
//     private TreeNode first = null;
//     private TreeNode second = null;
//     private TreeNode prev = new TreeNode(Integer.MIN_VALUE);
//     public void recoverTree(TreeNode root) {
//         inorder(root);
//         int temp = first.val;
//         first.val = second.val;
//         second.val = temp;
//     }
    
//     public void inorder(TreeNode root){
//         if(root == null){
//             return;
//         }
        
//         inorder(root.left);
//         if(first == null && prev.val > root.val){
//             first = prev;
//         }
        
//         if(first != null && prev.val > root.val){
//             second = root;
//         }
        
//         prev = root;
//         inorder(root.right);
//     }
// }