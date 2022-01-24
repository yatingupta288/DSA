class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length() == 1)return true;
        char words[] = word.toCharArray();
        int i = 1;
        int ch = words[i];
        if(ch >= 97 &&  ch <= 122){
            while(i < word.length()){
                if((int)words[i] < 97 || (int)words[i] > 122){
                    return false;
                }
                i++;
            }
        }else{
            if(Character.isLowerCase(words[0]))return false;
            while(i < word.length()){
                if((int)words[i] >= 97 && (int)words[i] <= 122){
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}