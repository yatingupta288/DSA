class Solution {
    public boolean isValidBST(TreeNode root) {
        boolean BST = helper(root, null, null);
        return BST;
    }
    public boolean helper(TreeNode root, TreeNode min, TreeNode max){
        if(root == null){
            return true;
        }
        
        if(max != null && root.val >= max.val || min != null && root.val <= min.val){
            return false;
        }
        return helper(root.left, min, root) && helper(root.right, root, max);
    }
}