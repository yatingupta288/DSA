//     DFS 
//     int xdepth = -1;
//     int ydepth = -1;
//     TreeNode xparent = null;
//     TreeNode yparent = null;
//     public boolean isCousins(TreeNode root, int x, int y) {
//         getdepthAndparent(root, x, y, 0, null);
//         return xdepth == ydepth && xparent != yparent;
        
//     }
    
//     public void getdepthAndparent(TreeNode root, int x, int y, int depth, TreeNode parent){
//         if(root == null){
//             return;
//         }
        
//         if(root.val == x){
//             xparent = parent;
//             xdepth = depth;
//         }
//         else if(root.val == y){
//             yparent = parent;
//             ydepth = depth;
//         }else{
//             getdepthAndparent(root.left, x, y, depth + 1, root);
//             getdepthAndparent(root.right, x, y, depth + 1, root);
//         }
//     }

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer , int[]> map = new HashMap<>();
        getdepthAndparent(root, x, y, 0, 0, map);
        int[] X = map.get(x);
        int[] Y = map.get(y);
        return X != null && Y != null && X[0] == Y[0] && X[1] != Y[1];
        
    }
    
    public void getdepthAndparent(TreeNode root, int x, int y, int depth, int parent, Map<Integer, int[]> map){
        if(root == null){
            return;
        }
        
        if(root.val == x){
            map.put(root.val, new int[]{depth, parent});
        }
        else if(root.val == y){
            map.put(root.val, new int[]{depth, parent});
        }else{
            getdepthAndparent(root.left, x, y, depth + 1, root.val, map);
            getdepthAndparent(root.right, x, y, depth + 1, root.val, map );
        }
    }
}

// BFS : BEST method
//     public boolean isCousins(TreeNode root, int x, int y) {
//         if(root == null){
//             return false;
//         }
        
//         Queue<TreeNode> q = new ArrayDeque<>();
//         q.offer(root);
    
//         while(!q.isEmpty()){
//             int size = q.size();
//             boolean isXExist = false;
//             boolean isYExist = false;
//             for(int i = 0; i < size; i++){
//                 TreeNode curr = q.poll();
//                 if(curr.val == x)isXExist = true;
//                 if(curr.val == y)isYExist = true;
//                 if(curr.left != null && curr.right != null){
//                     if(curr.left.val == x && curr.right.val == y){
//                         return false;
//                     }
//                     if(curr.left.val == y && curr.right.val == x){
//                         return false;
//                     }
//                 }
//                 if(curr.left != null)q.offer(curr.left);
//                 if(curr.right != null)q.offer(curr.right);
//             }
//             if(isXExist && isYExist)return true;
//         }
//         return false;
//     }