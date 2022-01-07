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
    int width = 0;
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        width(root, 0, 1, list);
        return width;
    }
    
    public int width(TreeNode root, int depth, int id, List<Integer> list){
        if(root == null)return 0;
        if(list.size() == depth){
            list.add(id);
        }
        width = Math.max(width, id - list.get(depth) + 1);
        width(root.left, depth + 1, 2 * id, list);
        width(root.right, depth + 1, 2 * id + 1, list);
        
        return width;
    }
}