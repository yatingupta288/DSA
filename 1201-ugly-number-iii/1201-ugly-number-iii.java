class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int lo = 0;
        int ri = (int)2e9;
        int result = 0;
        while(lo <= ri){
            int mid = lo + (ri - lo)/2;
            if(count(mid, a,b,c) >= n){
                result = mid;
                ri = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        
        return result;
    }
    
    public long count(long n, long a, long b, long c){
        return n/a + n/b + n/c
               - n/(lcm(a, b)) -n/(lcm(b, c)) -n/(lcm(a, c)) + n/(lcm(a, lcm(b,c)));
    }
    
    public long gcd(long a, long b){
        if(a == 0){
            return b;
        }
        
        return gcd(b % a, a);
    }
    
    public long lcm(long a, long b){
        return a * b / gcd(a,b);
    }
}