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
    int lev = 1;
    public int maxDepth(TreeNode root) {
        if(root == null){
                    return 0;
                }
        
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        
        if(root.left == null)return  rh + 1;
        if(root.right == null)return lh + 1;
        
        return Math.max(lh, rh) + 1; 

    }
}