class Solution {
    public String longestNiceSubstring(String s) {
        if(s.length() == 1)return "";
        char arr[] = s.toCharArray();
        Set<Character> set =  new HashSet<>();
        for(char ch : arr){
            set.add(ch);
        }
        
        for(int i = 0; i < arr.length; i++){
            if(set.contains(Character.toUpperCase(arr[i])) && set.contains(Character.toLowerCase(arr[i]))){
                continue;
            }
            String sub1 = longestNiceSubstring(s.substring(0, i));
            String sub2 =  longestNiceSubstring(s.substring(i + 1));
            
            return sub1.length() >= sub2.length() ? sub1 : sub2;
        }
        
        return s;
    }
}