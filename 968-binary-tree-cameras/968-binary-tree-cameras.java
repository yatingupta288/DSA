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
    int count = 0;
    public int minCameraCover(TreeNode root) {
        if(helper(root) == -1)count++;
        return count;
    }
    
    public int helper(TreeNode root){
        if(root == null){
            return 1;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        if(left == -1 || right == -1){
            count++;
            return 0;  //parent has camera now
        }else if(left == 0 || right == 0){
            return 1; // child covered parent 
        }
        
        
        return -1; // child is covered but as for parent it needs the camera for its parent
    }
}