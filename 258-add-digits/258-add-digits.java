class Solution {
    public int addDigits(int num) {
        String s = sumOfDigits(num);
        System.out.print(s + " ");
        if(s.length() == 1){
            return Integer.parseInt(s);
        }else{
            return addDigits(Integer.parseInt(s));
        }
    }
    
    public String sumOfDigits(int num){
        int sum = 0;
        while(num > 0){
            sum += (num % 10);
            num = num/10;
        }
        
        return sum + "";
    }
}