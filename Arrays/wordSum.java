class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return getInt(firstWord) + getInt(secondWord) == getInt(targetWord);   
    }
    
    public int getInt(String s){
        int result = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            result += (s.charAt(i) - 'a') * (Math.pow(10, s.length() - i - 1));
        }
        System.out.println(result);
        
        return result;
    }
}