class Solution {
    public void zigzagLevelOrder(TreeNode root,int l, List<List<Integer>>list){
        if(root != null){
            if(l == list.size()){
                List<Integer> cur = new ArrayList<>();
                list.add(cur);
            }
        
        if(l % 2 == 1){
            list.get(l).add(0, root.val);
        }else{
            list.get(l).add(root.val);
        }
        zigzagLevelOrder(root.left, l + 1, list);
        zigzagLevelOrder(root.right, l + 1, list);
    }
}
    public void zigzagLevelOrder(TreeNode root, List<List<Integer>>list){
        TreeNode c = root;
        Stack<TreeNode> st = new Stack<>();
        Stack<TreeNode> st1 = new Stack<>();
        int level = 1;
        st.push(root);
        while(st.size() != 0){
            
            List<Integer> cur = new ArrayList<>();
            while(st.size() != 0){
                c = st.pop();
                cur.add(c.val);
                if(c.left != null)st1.push(c.left);
                if(c.right != null)st1.push(c.right);
            }
            list.add(cur);
            cur = new ArrayList<>();
            while(st1.size() != 0){
                c = st1.pop();
                cur.add(c.val);
                if(c.right != null)st.push(c.right);
                if(c.left != null)st.push(c.left);
            }
            if(cur.size() != 0)list.add(cur);
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        zigzagLevelOrder(root, 0, list);
        return list;
    }
}