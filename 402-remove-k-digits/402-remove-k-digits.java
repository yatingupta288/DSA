class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        StringBuilder s = new StringBuilder("");
        st.push(num.charAt(0) - '0');
        for(int i = 1; i < num.length(); i++){
            int a = num.charAt(i) - '0';
            while(k > 0 && !st.isEmpty() && st.peek() > a){
                st.pop();
                k--;
            }
            st.push(a);
        }
        if(k != 0){
            while(k > 0){
                st.pop();
                k--;
            }
        }
        while(!st.isEmpty()){
            s.insert(0,st.pop());
        }
        int i = 0;
        for(char ch : s.toString().toCharArray()){
            if(ch != '0'){
                break;
            }
            i++;
        }
        int a;
        String s1  = s.toString().substring(i, s.length());
       if(s1 == "" || s1 == null){
           return "0";
       }
        
        return s1;
    }
}