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

// Step 1: Initialize current as root

// Step 2: While current is not NULL,

// If current does not have left child

//     a. Add current’s value

//     b. Go to the right, i.e., current = current.right

// Else

//     a. In current's left subtree, make current the right child of the rightmost node

//     b. Go to this left child, i.e., current = current.left

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                list.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode pointer = curr.left;
                while(pointer.right != null){
                    pointer = pointer.right;
                }
                
                pointer.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
        
        return list;
    }
}





















// ArrayList<Integer> list = new ArrayList<>();
        
//         Stack<TreeNode> st = new Stack<>();
//         TreeNode curr = root;
//         while(curr != null || !st.isEmpty()){
//             while(curr != null){
//                 st.push(curr);
//                 curr = curr.left;
//             }
//             curr = st.pop();
//             list.add(curr.val);
//             curr = curr.right;
//         }
//         return list;





// List<Integer> list = new ArrayList<>();
//     public List<Integer> inorderTraversal(TreeNode root) {
//         helper(root);
//         return list;
//     }
//     public void helper(TreeNode root){
//         if(root != null){
//             inorderTraversal(root.left);
//             list.add(root.val);
//             inorderTraversal(root.right);
//         }
//     }
