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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)return new TreeNode(val);
        helper(root, val, null);
        return root;
    }
    
    public void helper(TreeNode root, int val, TreeNode prev){
        if(root == null){
            if(prev.val >= val){
                prev.left = new TreeNode(val);
            }else{
                prev.right = new TreeNode(val);
            }
            return;
        }
        
        if(root.val >= val){
            helper(root.left, val, root);
        }else{
            helper(root.right, val, root);
        }
        
    }
}