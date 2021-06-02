class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        HashMap<String, Boolean> map = new HashMap<>();
        return check(s1, s2, s3, map);
    }
    
    public boolean check(String s1, String s2, String s3, HashMap<String , Boolean> map){
        if(s1.length() + s2.length() != s3.length())return false;
        if(s1.isEmpty() && s2.isEmpty() && s3.isEmpty())return true;
        
        String key = s1 + "->" + s2 + "->" + s3;
        boolean first = false;
        boolean second = false;
        if(!map.containsKey(key)){
            if(!s1.isEmpty() && s1.charAt(0) == s3.charAt(0))first = check(s1.substring(1), s2, s3.substring(1), map);
            if(!s2.isEmpty() && s2.charAt(0) == s3.charAt(0))second = check(s1, s2.substring(1), s3.substring(1), map);
            map.put(key, first || second);
        }
        return map.get(key);
    }
}