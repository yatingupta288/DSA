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
    class Pair{
        TreeNode node;
        int d;
        
        Pair(TreeNode node, int d){
            this.node = node;
            this.d = d;
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair p = depth(root, 0);
        return p.node;
    }
    
    public Pair depth(TreeNode node,  int d){
        if(node == null){
            return new Pair(null, d);
        }
        
        Pair l = depth(node.left, d + 1);
        Pair r = depth(node.right, d + 1);
        
        if(l.d == r.d){
            return new Pair(node, l.d);
        }else{
            return l.d > r.d ? l : r;
        }
    }
}
//     int deepest = 0;
//     TreeNode lca;

//     public TreeNode lcaDeepestLeaves(TreeNode root) {
//         helper(root, 0);
//         return lca;
//     }

//     private int helper(TreeNode node, int depth) {
//         deepest = Math.max(deepest, depth);
//         if (node == null) {
//             return depth;
//         }
//         int left = helper(node.left, depth + 1);
//         int right = helper(node.right, depth + 1);
//         if (left == deepest && right == deepest) {
//             lca = node;
//         }
//         return Math.max(left, right);
//     }