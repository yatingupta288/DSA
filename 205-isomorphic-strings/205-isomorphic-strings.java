class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap map = new HashMap<>();
        HashMap map1 = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!Objects.equals(map.put(s.charAt(i), i), map1.put(t.charAt(i), i))){
                return false;
            }
            // System.out.print(map.get(s.charAt(i)) + "*" + map.get(t.charAt(i)) + " ");
        }
        return true;
    }
}