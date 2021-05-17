class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(queue.size() != 0){
            int size = queue.size();
            List<Integer> cur = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode currnode = queue.remove();
                cur.add(currnode.val);
                if(currnode.left != null){
                    queue.add(currnode.left);
                }
                if(currnode.right != null){
                    queue.add(currnode.right);
                }
            }
            res.add(cur);
        }
        return res;
    }
}