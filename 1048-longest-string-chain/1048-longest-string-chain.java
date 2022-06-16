// dp inside dp first using dp for the first problem then using dp for the next LCS.
class Solution {
    public int longestStrChain(String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        int res = Integer.MIN_VALUE;
        for(String w : words){
            map.put(w, 1);
                for(int i = 0; i < w.length(); i++){
                    StringBuilder st = new StringBuilder(w);
                    String s = st.deleteCharAt(i).toString();
                    if(map.containsKey(s) && map.get(s) + 1 > map.get(w)){
                        map.put(w, map.get(s) + 1);
                    }
                }
                res = Math.max(res, map.get(w));
            }
        return res;
    }
}