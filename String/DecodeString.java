class Solution {
    public String decodeString(String s) {
        Stack<Integer> st1 = new Stack<>();
        Stack<String> st2 = new Stack<>();
        String res = "";
        int i = 0;
        while(i < s.length()){
            if(Character.isDigit(s.charAt(i))){
                int count = 0;
                while(Character.isDigit(s.charAt(i))){
                    count = count * 10 + s.charAt(i) - '0';
                    i += 1;
                }
                st1.push(count);
            }else if(s.charAt(i) == '['){
                st2.push(res);
                res = "";
                i += 1;
            }else if(s.charAt(i) == ']'){
                StringBuilder sb = new StringBuilder(st2.pop());
                int count = st1.pop();
                for(int j = 0; j < count; j++){
                    sb.append(res);
                }
                res = sb.toString();
                i += 1;
            }else{
                res += s.charAt(i);
                i += 1;
            }
        }
        return res;
    }
}

// if(s.length()==0) return "";
//         Stack<String> st = new Stack<>();
//         String res = "";
//         int k = 0;
//         for(int i = 0; i < s.length(); i++){
//                 if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
//                     k = k * 10 + s.charAt(i) - '0'; 
//                 }else if(s.charAt(i) == '['){
//                     st.push(k + "");
//                     st.push("[");
//                     k = 0;
//                 }else if(s.charAt(i) == ']'){
//                     String str = "";
//                     while(st.peek() != "["){
//                         str = st.pop() + str;
//                     }
//                     st.pop();
//                     int r = Integer.valueOf(st.pop());
//                     StringBuilder sb = new StringBuilder();
//                     for(int j = 0; j < r; j++){
//                         sb.append(str);
//                     }
//                     st.push(sb.toString());
//                 }else{
//                     st.push(s.charAt(i) + "");
//                 }
//             }
//         while(!st.isEmpty()){
//          res = st.pop() + res;   
//         }
//         return res;