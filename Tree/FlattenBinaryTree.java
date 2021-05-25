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
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = null;
        
        flatten(left);
        flatten(right);
        
        root.right = left;
        TreeNode curr = root;
        while(curr.right != null){
            curr = curr.right;
        }
        curr.right = right;
    }
}
// if(root == null){     this is efficient but has global variable
    //         return;
    //     }
    //     flatten(root.right);
    //     flatten(root.left);
    //     root.right = prev;
    //     root.left = null;
    //     prev = root;
