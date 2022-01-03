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
    int result = 0;
    public int maxAncestorDiff(TreeNode root) {
        TreeNode prev = null;
        diff(root, prev);
        return result;
    }
    
    public int[] diff(TreeNode root, TreeNode prev){
        if(root == null){
            return new int[]{prev.val, prev.val};
        }
        
        int A[] = diff(root.left, root);
        int B[] = diff(root.right, root);
        
        int diff = Math.max(Math.max(Math.abs(root.val - A[0]),Math.abs(root.val - A[1])), Math.max(Math.abs(root.val - B[0]),Math.abs(root.val - B[1])));
        result = Math.max(result, diff);
        int min = Math.min(root.val, Math.min(A[0], B[0]));
        int max = Math.max(root.val, Math.max(A[1], B[1]));
        
        return new int[]{min, max};
    }
}