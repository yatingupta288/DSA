class Solution {
    List<TreeNode> path = null;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        path = new ArrayList<>();
        nodeToRootPath(root, target);
        List<Integer> paths = new ArrayList<>();
        for( int i = 0; i < path.size(); i++){
            kLevelsDown(path.get(i), k - i, i == 0 ? null : path.get(i - 1), paths);
        }
        return paths;
    }
    
    public void kLevelsDown(TreeNode root, int k, TreeNode blocker, List<Integer> paths){
        if(root == null || k < 0 || (blocker != null && root == blocker)){
            return;
        }
        
        if(k == 0){
            paths.add(root.val);
        }
        
        kLevelsDown(root.left, k - 1, blocker, paths);
        kLevelsDown(root.right, k - 1, blocker, paths);
    }
    
    public boolean nodeToRootPath(TreeNode root, TreeNode target){
        if(root == null){
            return false;
        }
        
        if(root == target || nodeToRootPath(root.left, target) || nodeToRootPath(root.right, target)){
            path.add(root);
            return true;
        }
        return false;
    }
}