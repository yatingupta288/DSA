class Complete{
    
    // Function for finding maximum and value pair
    public static int minSwap (int arr[], int n, int k) {
        int count = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] <= k){
                count++;
            }
        }
        
        int bad = 0;
        for(int i = 0; i < count; i++){
            if(arr[i] > k){
                bad++;
            }
        }
        
        int ans = 0;
        ans = bad;
        for(int j = count ; j < n; j++){
            if(arr[j - count] > k){
                bad--;
            }
            
            if(arr[j] > k){
                bad++;
            }
            
            ans = Math.min(bad, ans);
        }
        return ans;
    }
}
