class Solution {
    public boolean wordPattern(String pattern, String s) {
        String str[] = s.split(" ");
        if(pattern.length() != str.length){
            return false;
        }
        HashMap map = new HashMap<>();
        for(int i = 0; i < str.length; i++){
            if(!Objects.equals(map.put(pattern.charAt(i), i), map.put(str[i], i))){
                return false;
            }
        }
        return true;
    }
}