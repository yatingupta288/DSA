class Solution{
    static int minJumps(int[] arr){
        // your code here
        
        if(arr.length <= 1){
            return 0;
        }
        
        if(arr[0] == 0){
            return -1;
        }
        
        int maxreach = arr[0];
        int steps = arr[0];
        int jumps = 1;
        
        for(int i = 1; i < arr.length; i++){
            if(i == arr.length - 1){
                return jumps;
            }
            
            maxreach = Math.max(maxreach, i + arr[i]);
            
            steps--;
            
            if(steps == 0){
                jumps++;
                
                if(i >= maxreach){
                    return -1;
                }
                
                steps = maxreach - i;
            }
            
        }
        return -1;
    }
}