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
        if(root == null){
            return null;
        }
        
        ArrayList<TreeNode> list = new ArrayList<>();
        helper(root, list);
        TreeNode prev = new TreeNode();
        prev = null;
        TreeNode root1 = new TreeNode();
        for(int i = 0; i < list.size(); i++){
            TreeNode node = new TreeNode(list.get(i).val);
            if(i == 0){
                root1 = node;
            }
            if(i != 0){
                prev.left = null;
                prev.right = node;
            }
            
            prev = node;
        }
        return root1;
    }
    
    public void helper(TreeNode root, ArrayList<TreeNode> list){
        if(root != null){
        helper(root.left, list);
        list.add(root);
        helper(root.right, list);
        
        }
    }
}