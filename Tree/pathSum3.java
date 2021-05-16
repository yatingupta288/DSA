class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int count = 0;
        int cursum = 0;
        h.put(0, 1);
        count = pathSumHelper(root, cursum, targetSum, h);
        return count;
    }
    
    public int pathSumHelper(TreeNode root, int c, int t, HashMap<Integer, Integer> h){
        if(root == null){
            return 0;
        }
        
        c += root.val; 
        int res = h.getOrDefault(c - t, 0);
        h.put(c, h.getOrDefault(c,0) + 1);
        
        res += pathSumHelper(root.left, c, t, h) + pathSumHelper(root.right, c, t, h);
        h.put(c, h.get(c) - 1);
        return res;
    }
}