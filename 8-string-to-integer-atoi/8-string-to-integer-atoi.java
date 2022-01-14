class Solution {
    public int myAtoi(String s) {
        if(s.length() == 0){
            return 0;
        }
        boolean pos = true;
        int num = 0;
        int i = 0;
        while(i < s.length() && s.charAt(i) == ' '){
            i++;
        }
        
        if(i == s.length()){
            return 0;
        }
        if(s.charAt(i) == '-'){
            pos = false;
            i++;
        }else if(s.charAt(i) == '+'){
            pos = true;
            i++;
        }
        
        // System.out.print(i + " ");
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            if(Integer.MAX_VALUE /10 < num || Integer.MAX_VALUE/10 == num && Integer.MAX_VALUE %10 < s.charAt(i) - '0'){
                return pos == true ? Integer.MAX_VALUE: Integer.MIN_VALUE;
            }
            num = num * 10 + s.charAt(i++) - '0';
        }
        if(!pos) num = num * -1;
        return num;
    }

}