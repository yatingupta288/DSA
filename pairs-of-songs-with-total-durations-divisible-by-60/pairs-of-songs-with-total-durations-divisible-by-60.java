class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int rem[] = new int[60];
        int res = 0;
        for(int i = 0; i < time.length; i++){
            res += rem[(60 - time[i] % 60)%60];
            rem[time[i]%60]++;
        }
        return res;
    }
}