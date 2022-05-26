class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() == 0){
            return 0;
        }
        Stack<Integer> st = new Stack<>(); 
        st.push(-1);
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }else{
                if(st.size() > 1 && s.charAt(st.peek()) == '('){
                    st.pop();
                    res = Math.max(res, i - st.peek());
                }else{
                    st.push(i);
                }
            }
        }
        
        return res;
    }
}