class Solution {
    public void zigzagLevelOrder1(TreeNode root, List<List<Integer>> result) {
    if (root == null) {
        return;
    }
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean reverse = false;
    
    while (!queue.isEmpty()) {
        int size = queue.size();

        /* use linkedlist to control time complexity of addFirst to O(1) */
        LinkedList<Integer> tempList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            TreeNode curNode = queue.poll();
            if (reverse) {
                tempList.addFirst(curNode.val);
            }
            else {
                tempList.add(curNode.val);
            }
            
            if (curNode.left != null) {
                queue.offer(curNode.left);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
            }
        }
        result.add(tempList);
        reverse = !reverse;
    }
}
    public void zigzagLevelOrder(TreeNode root, List<List<Integer>>list){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(q.size() != 0){
            int c = q.size();
            List<Integer> cur = new ArrayList<>();
            for(int i = 0; i < c; i++){
                TreeNode cc = q.remove();
                if(cc != null){
                    cur.add(cc.val);
                    q.add(cc.left);
                    q.add(cc.right);
                }
            }
            if(cur.size() != 0){
                    if(level % 2 == 1){
                        Collections.reverse(cur);
                    }
                    list.add(cur);
                }
                level++;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        zigzagLevelOrder1(root, list);
        return list;
    }
}