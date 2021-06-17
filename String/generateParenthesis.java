class Solution {
    public List<String> generateParenthesis(int n) {
        int n1 = n;
        int n2 = n;
        String str = "";
        
        List<String> list = new ArrayList<>();
        helper(n1, n2, str, list);
        return list;
    }
    
    public void helper(int n1, int n2, String str, List<String> list){
        if(n1 == 0 && n2 == 0 ){
            list.add(str);
            return;
        }else if(n1 < 0 || n2 < 0 || n1 > n2){
            return;
        }
        
        helper(n1 - 1,n2,  str + "(", list);
        helper(n1, n2 - 1, str + ")", list);
    }
}

