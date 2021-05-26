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
    int maxlen;
    public int longestZigZag(TreeNode root) {
        longestZigZag_(root);
        return maxlen;
    }
    
    public int[] longestZigZag_(TreeNode root){
        if(root == null)return new int[]{-1, -1};
        int[] l = longestZigZag_(root.left);
        int[] r = longestZigZag_(root.right);
        
        maxlen = Math.max(maxlen, Math.max(l[1], r[0]) + 1);
        return new int[]{l[1] + 1, r[0] + 1};
    }
}

//     public class Pair{
//         int rightbranch = -1;
//         int leftbranch = -1;
//         int maxlength = 0;
//     }
//     public int longestZigZag(TreeNode root) {
//         Pair p = longestZigZag_(root);
//         return p.maxlength;
//     }
        
//     public Pair longestZigZag_(TreeNode root){
//         if(root == null)return new Pair();
    
//         Pair l = longestZigZag_(root.left);
//         Pair r = longestZigZag_(root.right);

//         Pair mp = new Pair();

//         mp.maxlength = Math.max(Math.max(l.maxlength, r.maxlength),Math.max(l.rightbranch, r.leftbranch) + 1);
//         mp.leftbranch = l.rightbranch + 1;
//         mp.rightbranch = r.leftbranch + 1;
        
//         return mp;
//     }