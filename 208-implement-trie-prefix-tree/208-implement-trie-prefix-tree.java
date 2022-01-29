class Trie {
    class Node{
        private Node links[];
        
        private int R = 26;
        
        private boolean isEnd;
        
        public Node(){
            links = new Node[R];
        }
        
        public boolean ContainsKey(char ch){
            return links[ch - 'a'] != null; 
        }
        
        public Node get(char ch){
            return links[ch - 'a'];
        }
        
        public void set(char ch, Node node){
            links[ch - 'a'] = node;
        }
        
        public boolean isEnd(){
            return isEnd;
        }
        
        public void setEnd(){
            isEnd = true;
        }
    }
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()){
            if(!curr.ContainsKey(ch)){
                curr.set(ch, new Node());
            }
            
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
    
    public Node searchPrefix(String word){
        Node curr = root;
        for(char ch : word.toCharArray()){
            if(curr.ContainsKey(ch)){
                curr = curr.get(ch);
            }else{
                return null;
            }
        }
        return curr;
    }
    
    public boolean search(String word) {
        Node node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node = searchPrefix(prefix);
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */