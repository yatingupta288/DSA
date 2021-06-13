class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for(int i = 0; i < chalk.length; i++){
            sum += chalk[i]; 
        }
        
        int temp = (int)(k % sum);
        if(temp == 0){
            return 0;
        }
        for(int i = 0; i < chalk.length; i++){
            temp -= chalk[i];
            if(temp < 0){
                return i;
            }
        }
        
        return -1;
    }
}