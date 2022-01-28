public class Trie{
    class Node{
        Node left;
        Node right;
    }
    Node root;
    public Trie(){
        root = new Node();
    }

    public void insert(int val){
        int bits = 30;
        Node curr = root;
        while(bits >= 0){
            int mask = 1 << bits;
            int bit = (mask&val) > 0 ? 1 : 0;
            if(bit == 0){
                if(curr.left == null){
                    curr.left = new Node();
                }
                curr = curr.left;
            }else{
                if(curr.right == null){
                    curr.right = new Node();
                }
                curr = curr.right; 
            }
            bits--;
        }
    }

    public int findQuery(int find){
        int bits = 30;
        int ans = 0;
        Node curr = root;
        while(bits >= 0){
            int mask = 1 << bits;
            int bit = (mask&find) > 0 ? 1 : 0;
            if(bit == 0){
                if(curr.left != null){
                    curr = curr.left;
                }else{
                    curr = curr.right;
                    ans |= mask;
                }
            }else{
                if(curr.right != null){
                    curr = curr.right;
                    ans |= mask;
                }else{
                    curr = curr.left;
                }
            }
            bits--;
        }
        return ans;
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for(int num : nums){
            trie.insert(num);
        }
        int max = 0;
        for(int a : nums){
            int find = Integer.MAX_VALUE ^ a;
            int b = trie.findQuery(find);
            max = Math.max(max, a ^ b);
        }
        return max;
    }
}