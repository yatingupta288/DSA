class Solution {
    public boolean isSymmetricHelper2(TreeNode root, Stack<TreeNode> st){
        st.push(root.left);
        st.push(root.right);
        while(st.size() > 0){
            TreeNode right = st.pop();
            TreeNode left = st.pop();
            if(right == null && left == null){
                continue;
            }
            if(right == null || left == null || right.val != left.val){
                return false;
            }
            
            st.push(left.left);
            st.push(right.right);
            st.push(left.right);
            st.push(right.left);
        }
        return true;
    }
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        return (root == null) || isSymmetricHelper2(root, st);
        
    }
    
    public boolean isSymmetricHelper(TreeNode left , TreeNode right){
        if(right == null || left == null){
            return left == right;
        }
        
        if(right.val != left.val){
            return false;
        }
        
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right ,right.left);
    }
}