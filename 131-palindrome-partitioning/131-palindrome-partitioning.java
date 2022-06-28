class Solution {
    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        part(s, list, res);
        return res;
    }
    
    public boolean isPalindrome(String s){
        int l = 0;
        int r = s.length() - 1;
        
        while(l < r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else{
                return false;
            }
        }
        
        return true;
    }
    
    public void part(String s, List<String> list, List<List<String>> res){
        if(s == null || s.length() == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = 1; i <= s.length(); i++){
            String sleft = s.substring(0, i);
            if(!isPalindrome(sleft))continue;
            
            list.add(sleft);
            part(s.substring(i, s.length()), list, res);
            list.remove(list.size() - 1);
        }
        
        return;
    }
}