class Solution {
    public String convertToTitle(int cnum) {
        StringBuilder s = new StringBuilder();
        int rem = 0;
        while(cnum > 0){
            cnum--;
            s.insert(0, (char)(cnum%26 + 'A'));
            cnum = cnum/26;
        }
        
        return s.toString();
    }
}