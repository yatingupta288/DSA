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
public class Solution {
    // int max = 0;
    
    public class Pair{
        int dia;
        int ht;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        Pair res = diameter(root);
        return res.dia;
    }
    public Pair diameter(TreeNode root){
        if(root == null){
            Pair res = new Pair();
            res.dia = 0;
            res.ht = -1;
            return res;
        }
        Pair ld = diameter(root.left);
        Pair rd = diameter(root.right);
        
        Pair md = new Pair();
        md.ht = Math.max(ld.ht, rd.ht) + 1;
        md.dia = Math.max(Math.max(ld.dia, rd.dia), ld.ht + rd.ht + 2);
        
        return md;
    }
//     private int maxDepth(TreeNode root) {
//         if (root == null) return 0;
        
//         int left = maxDepth(root.left);
//         int right = maxDepth(root.right);
        
//         max = Math.max(max, left + right);
        
//         return Math.max(left, right) + 1;
//     }
}