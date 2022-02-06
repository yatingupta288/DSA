class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tcost = 0;
        int tgas = 0;
        
        for(int i = 0; i < gas.length; i++){
            tcost += cost[i];
            tgas += gas[i];
        }
        
        if(tcost > tgas)return -1;
        int fuel = 0;
        int start = 0;
        for(int i = start; i < gas.length; i++){
            fuel += gas[i] - cost[i];
            
            if(fuel < 0){
                fuel = 0;
                start = i + 1;
            }
        }
        
        return fuel >= 0 ? start : -1; 
    }
}