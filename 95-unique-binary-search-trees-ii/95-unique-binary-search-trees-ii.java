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
    public List<TreeNode> generateTrees(int n) {
        return makingNodes(1, n);
    }
    
    public List<TreeNode> makingNodes(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if(start > end){
            list.add(null);
            return list;
        }
        
        for(int root = start; root <= end; root++){
            List<TreeNode> leftSubtree = makingNodes(start,  root - 1);
            List<TreeNode> rightSubtree = makingNodes(root + 1, end);
            
            for(TreeNode rightroot : rightSubtree){
                for(TreeNode leftroot : leftSubtree){
                    TreeNode node = new TreeNode(root);
                    node.left = leftroot;
                    node.right = rightroot;
                    list.add(node);
                }
            }
        }
        
        return list;
    }
}