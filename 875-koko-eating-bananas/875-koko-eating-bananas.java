class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000;
        
        while(left <= right){
            int mid = (left + right)/2;
            if(canEat(mid, piles, h))right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
    
    public boolean canEat(int k, int[] piles, int h){
        int hours= 0;
        for(int pile : piles){
            int div = pile/k;
            hours += div;
            
            if(pile%k != 0)hours++;
        }
        return hours <= h;
    }
}