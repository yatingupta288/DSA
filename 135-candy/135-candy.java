class Solution {
    public int candy(int[] ratings) {
        int offer[] = new int[ratings.length];
        offer[0] = 1;
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1]){
                offer[i] = offer[i - 1] + 1; 
            }else{
                offer[i] = 1;
            }
        }
        
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                if(offer[i] > offer[i + 1]){
                    continue;
                }else{
                    offer[i] = offer[i + 1] + 1;
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < ratings.length; i++){
            sum += offer[i];
        }
        
        return sum;
    }
}