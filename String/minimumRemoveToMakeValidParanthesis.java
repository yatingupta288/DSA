class Solution {
    public String minRemoveToMakeValid(String s){
        int open = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;
            }else if(ch == ')'){
                if(open == 0)continue;
                open--;
            }
            
            sb.append(ch);
        }
        
        StringBuilder res = new StringBuilder(); 
        for(int i = sb.length() - 1; i >= 0; i--){
            if(sb.charAt(i) == '(' && open-- > 0)continue;
            res.append(sb.charAt(i));
        }
        
        return res.reverse().toString();
    }
}


// Stack<Integer> st = new Stack<>();
//         StringBuilder sb = new StringBuilder(s);
//         for(int i = 0; i < s.length(); i++){
//             char ch = sb.charAt(i);
//             if(ch == '('){
//                 st.push(i);
//             }else{
//                 if(ch == ')'){
//                     if(!(st.size() == 0)){
//                         st.pop();
//                     }else{
//                         sb.setCharAt(i, '*');
//                     }
//                 }
//             }
//         }
//         while(!(st.size() == 0)){
//             sb.setCharAt(st.pop(), '*');
//         }
//         return sb.toString().replaceAll("\\*", "");