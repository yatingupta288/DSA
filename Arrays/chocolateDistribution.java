class Solution
{
    public long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        // your code here
        if(m == 0 || n == 0){
            return 0;
        }
        
        if(n < m){
            return -1;
        }
        
        Collections.sort(a);  
        
        long mindiff = Long.MAX_VALUE; 
        
        for(long i = 0; m + i - 1 < n; i++){
            long diff = a.get((int)(m + i - 1)) - a.get((int)i);
            if(mindiff > diff){
                mindiff = diff;
            }
        }
        return mindiff;
    }
}