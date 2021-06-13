// public String longestPalindrome(String s) {
//         String max = "";
//         for (int i = 0; i < s.length(); i++) {
//             String s1 = extend(s, i, i), s2 = extend(s, i, i + 1);
//             if (s1.length() > max.length()) max = s1;
//             if (s2.length() > max.length()) max = s2;
//         }
//         return max;
//     }
    
//     private String extend(String s, int i, int j) {
//         for (; 0 <= i && j < s.length(); i--, j++) {
//             if (s.charAt(i) != s.charAt(j)) break;
//         }
//         return s.substring(i + 1, j);
//     }

public class Solution {

    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
		//Dp array for substring palindrome
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); ++i) {
            for (int j = i; j >= 0; --j) {
                boolean startEqEnd = s.charAt(j) == s.charAt(i);

                if (i == j) {
                    //If the same char: 'a' is palindrome
                    dp[i][j] = true;
                } else if (i - j == 1) {
                    //If length 2: 'ab' is palindrome when 'a' == 'b'
                    dp[i][j] = startEqEnd;
                } else if (startEqEnd && dp[i - 1][j + 1]) {
                    //Otherwise: string is palindrome if s(i) == s(j) and substring s(j + 1, i - 1) is palindrome
                    dp[i][j] = true;
                }

                if (dp[i][j] && i - j > end - start ) {
                    end = i;
                    start = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }
}


// class Solution {
//     public String longestPalindrome(String s) {
//         if(s.length() <= 1){
//             return s;
//         }
//         int maxlenSub = 1;
//         int n = s.length();
//         int start = 0, end = 0;
        
//         for(int i = 0; i < s.length(); i++){
//             int len = 1;
//             int l = i, r = i;
//             while(l >= 0 && r < s.length()){
//                 if(s.charAt(l) == s.charAt(r)){
//                     len++;
//                     l--;
//                     r++;
//                 }else{
//                     break;
//                 }
//             }
//             if(maxlenSub < len){
//                 maxlenSub = len;
//                 start = l + 1;
//                 end = r - 1;
//             }
//         }
        
//         for(int i = 0; i < s.length(); i++){
//             int len = 2;
//             int l = i, r = i + 1;
//             while(l >= 0 && r < s.length()){
//                 if(s.charAt(l) == s.charAt(r)){
//                     len++;
//                     l--;
//                     r++;
//                 }else{
//                     break;
//                 }
//             }
//             if(maxlenSub < len){
//                 maxlenSub = len;
//                 start = l + 1;
//                 end = r - 1;
//             }
//         }
        
//         return s.substring(start, end + 1);
//     }
// }