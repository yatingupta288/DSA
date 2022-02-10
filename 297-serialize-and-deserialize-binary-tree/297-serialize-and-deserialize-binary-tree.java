/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public void serHelper(TreeNode root, StringBuilder s){
        if(root == null){
            s.append("n ");
            return;
        }
        
        s.append(root.val + " ");
        serHelper(root.left, s);
        serHelper(root.right, s);
    }
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        serHelper(root, s);
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.print(data);
        String s[] = data.split(" ");
        int idx[] = new int[1];
        TreeNode root = deser(s, idx);
        return root;
    }
    
    public TreeNode deser(String[] arr, int[] idx){
        if(idx[0]>arr.length|| arr[idx[0]].equals("n")){
            idx[0]++;
            return null;
        }
        
        int i=idx[0]++;
        int val=Integer.parseInt(arr[i]);
        TreeNode root=new TreeNode(val);
        
        root.left=deser(arr,idx);
        root.right=deser(arr,idx);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));