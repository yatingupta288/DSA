class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }
        int indext = 0;
        int indexs = 0;
        while(indext < t.length()){
            if(t.charAt(indext) == s.charAt(indexs)){
                indexs++;
                if(s.length() == indexs)return true;
            }
            indext++;
        }
        return false;
    }
}