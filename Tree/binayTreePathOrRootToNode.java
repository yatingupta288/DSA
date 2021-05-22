class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root != null)helper(root, list, "");
        return list;
    }
    
    public void helper(TreeNode root, List<String> list, String str){
        System.out.println(str);
        if(root.left == null && root.right == null)list.add(str + root.val);
        if(root.left != null)helper(root.left, list, str + root.val + "->" );
        if(root.right != null)helper(root.right, list, str + root.val + "->");
    }
}