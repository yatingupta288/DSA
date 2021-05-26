class Solution { // HERE 0 REPRESENTS WITHOUT ROBBERY AND 1 WITH ROBBERY.
    public int rob(TreeNode root){
        int res[] = rob_(root);
        return Math.max(res[0], res[1]);
    }
    public int[] rob_(TreeNode root) {
        if(root == null)return new int[2];
        
        int[] l = rob_(root.left);
        int[] r = rob_(root.right);
        
        int[] myAns = new int[2];
        
        myAns[0] = Math.max(l[1], l[0]) + Math.max(r[0], r[1]);
        myAns[1] = l[0] + r[0] + root.val;
        
        return myAns;
    }
}