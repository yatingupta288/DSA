class Solution {
    int res;
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int maxPathIncluded = Math.max(Math.max(left, right) + root.val, root.val);
        int maxAsInLoop = Math.max(maxPathIncluded, left + right + root.val);
        res = Math.max(maxAsInLoop, res);
        
        return maxPathIncluded;
    }
    
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }
}