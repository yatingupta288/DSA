//  DFS USING ARRAY
// public int kthSmallest(TreeNode root, int k){
//         int[] c = new int[]{0, 0};
//         kthSmallest_(root, k, c);
//         return c[1];
//     }
    
//     public int[] kthSmallest_(TreeNode root, int k, int c[]){
//         if(root == null || c[0] > k)return new int[2];
        
//         kthSmallest_(root.left, k, c);
//         c[0]++;
//         if(k == c[0])c[1] = root.val;
//         kthSmallest_(root.right, k, c);
//         return c;
//     }

class Solution {
    public int kthSmallest(TreeNode root, int k) {
     Stack<TreeNode> stack = new Stack<>();
     while(root != null || !stack.isEmpty()) {
         while(root != null) {
             stack.push(root);
             root = root.left;
         } 
         root = stack.pop();
         if(--k == 0) break;
         root = root.right;
     }
     return root.val;
 }
}
//     DFS USING GLOBAL VARIABLE
//     int count = 0;
//     int res = 0;
//     public int kthSmallest(TreeNode root, int k) {
//         kthSmallest_(root, k);
//         return res;
//     }
    
//     public void kthSmallest_(TreeNode root, int k){
//         if(root.left != null)kthSmallest_(root.left, k);
//         count ++;
//         if(count == k)res = root.val;
//         if(root.right != null)kthSmallest_(root.right, k);
//     }