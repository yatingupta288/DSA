class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int k = gas.length;
        for(int  i = 0; i <gas.length; i++){
            int fuel = 0;
            int stopcount = 0;
            int j = i;
            while(stopcount < gas.length){
                fuel += gas[j%k] - cost[j%k];
                if(fuel < 0){
                    i = j;
                    break;
                }
                stopcount++;
                j++;
            }
            if(stopcount == k && fuel >= 0 ){
                return i;
            }
        }
        return -1;
    }
}