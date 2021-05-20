class Solution {
    int tilt = 0;
    public int findTilt_(TreeNode root){
        if(root == null){
            return 0;
        }
        int lt = findTilt_(root.left);
        int rt = findTilt_(root.right);
        int stilt = Math.abs(lt - rt);
        tilt += stilt;
        int sum = lt + rt + root.val;
        return sum;
    }
    public int findTilt(TreeNode root) {
        return findTilt2(root)[0];
    }
    
    public int[] findTilt2(TreeNode root){
        if(root == null){
            return new int[]{0, 0};
        }
        
        int[] left = findTilt2(root.left);
        int[] right = findTilt2(root.right);
        
        int tilt1 = Math.abs(left[1] - right[1]) + left[0] + right[0];
        int maxSum = left[1] + right[1] + root.val; 
        
        return new int[]{tilt1, maxSum};
    }
}