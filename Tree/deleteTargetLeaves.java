class Solution {
    public TreeNode removeLeafNodes(TreeNode node, int target) {
        
        if(node.left != null)node.left = removeLeafNodes(node.left, target);
        if(node.right != null)node.right = removeLeafNodes(node.right, target);
        
        return node.left == null && node.right == null && node.val == target ? null : node;
    }
}