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
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }
    
    public int sum(TreeNode root , int currSum){
        if(root == null){
            return 0;
        }
        
        if(root.left == null && root.right == null){
            return currSum*10 + root.val;
        }
        
        int left = sum(root.left, currSum*10 + root.val);
        int right = sum(root.right, currSum*10 + root.val);
        
        return left + right;
    }
}

//         int sum = 0;
//         List<String> path = new ArrayList<>();
//         if(root != null)LeafToRootPath(root, path, "");
//         for( int i = 0 ; i < path.size(); i++){
//             sum += Integer.parseInt(path.get(i));
//         }
//         return sum;
//     }
    
//     public void LeafToRootPath(TreeNode root, List<String> path, String str){
//         if(root.left == null && root.right == null)path.add(str + root.val);
//         if(root.left != null)LeafToRootPath(root.left, path, str + root.val);
//         if(root.right != null)LeafToRootPath(root.right, path, str + root.val);
//     }