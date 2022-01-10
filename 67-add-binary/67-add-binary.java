class Solution {
    public String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int sum = 0;
            if(i >= 0)sum += (a.charAt(i--) - '0');
            if(j >= 0)sum += (b.charAt(j--) - '0');
            sum += carry;
            if(sum > 1){
                carry = 1;
            }else{
                carry = 0;
            }
            s.append(sum%2);
            // System.out.print(sum + " ");
        }
        if(carry!= 0)s.append(carry);
        return s.reverse().toString();
    }
}