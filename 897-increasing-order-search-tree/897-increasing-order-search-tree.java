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
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        return BSTHelper(root, null);
    }
    
    public TreeNode BSTHelper(TreeNode root, TreeNode prev){
        if(root == null){
            return prev;
        }
        
        TreeNode newRoot = BSTHelper(root.left, root);
        root.left = null;
        root.right = BSTHelper(root.right, prev);
        
        return newRoot;
    }
}