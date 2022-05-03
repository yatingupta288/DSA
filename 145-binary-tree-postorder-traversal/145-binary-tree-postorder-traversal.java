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

// only add left nodes to the stack
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        TreeNode visited = null;
        while(!st.isEmpty() || node != null){
            while(node != null){
                st.push(node);
                node = node.left;
            }
            
            TreeNode curr = st.peek();
            if(curr.right != null && curr.right != visited){
                node = curr.right;
            }else{
                list.add(curr.val);
                visited = st.pop();
            }
        }
        return list;
    }
}

// List<Integer> list = new ArrayList<>();
//         if(root == null)return list;
//         Stack<TreeNode> st = new Stack();
//         TreeNode curr = root;
//         TreeNode visited = null;
//         while(curr != null || !st.isEmpty()){
//             while(curr != null){
//                 st.push(curr);
//                 curr = curr.left;
//             }
//             TreeNode peek = st.peek();
//             if(peek.right != null && peek.right != visited){
//                 curr = peek.right;
//             }else{
//                 list.add(peek.val);
//                 visited = st.pop();
//             }
//         }
//         return list;

 // List<Integer> list = new ArrayList<>();
 //        if(root == null)return list;
 //        Stack<TreeNode> st = new Stack();
 //        st.push(root);
 //        TreeNode curr = root;
 //        while(!st.isEmpty() || !st.isEmpty()){
 //            curr = st.pop();
 //            if(curr != null){
 //                list.add(0, curr.val);
 //                if(curr.left != null)st.push(curr.left);
 //                if(curr.right != null)st.push(curr.right);
 //            }
 //        }
 //        return list;


// if(root == null)return new ArrayList<>();
//         List<Integer> list = new ArrayList<>();
//         Stack<TreeNode> st = new Stack<>();
//         st.push(root);
//         while(!st.isEmpty()){
//             TreeNode curr = st.pop();
//             list.add(0, curr.val);
//             if(curr.left != null){
//                 st.push(curr.left);
//             }
//             if(curr.right != null){
//                 st.push(curr.right);
//             }
//         }
//         return list;