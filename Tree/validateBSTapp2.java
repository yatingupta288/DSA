class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        
        long[] temp=helper(root);
        return temp[0]==1?true:false;
    }
    private long[] helper(TreeNode root){
        if(root==null)return new long[]{1,Long.MIN_VALUE,Long.MAX_VALUE};
        
        long[] left=helper(root.left);
        long[] right=helper(root.right);
        
        long[] temp=new long[3];
        temp[0]=left[0]==1&&right[0]==1&&root.val>left[1]&&root.val<right[2]?1:0;
        temp[1]=Math.max(root.val,Math.max(left[1],right[1]));
        temp[2]=Math.min(root.val,Math.min(left[2],right[2]));
        return temp;
    }
}