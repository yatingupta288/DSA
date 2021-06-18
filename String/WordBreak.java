class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int dp[] = new int[s.length()];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j <= i; j++){
                if(wordDict.contains(s.substring(j, i + 1))){
                    if(j > 0){
                        dp[i] += dp[j - 1];
                    }else{
                        dp[i] = 1;
                    }
                }
            }
        }
        return dp[s.length() - 1] > 0 ? true : false;
    }
}

// HashMap<String, Boolean> map = new HashMap<>();
//     public boolean wordBreak(String s, List<String> wordDict) {
//         if(wordDict.contains(s)){
//             return true;
//         }
//         if(map.containsKey(s)){
//             return map.get(s);
//         }
//         for(int i = 0; i < s.length(); i++){
//             if(wordDict.contains(s.substring(0, i + 1)) && wordBreak(s.substring(i + 1), wordDict)){
//                 map.put(s, true);
//                 return true;
//             }
//         }
//         map.put(s, false);
//         return false;
//     }