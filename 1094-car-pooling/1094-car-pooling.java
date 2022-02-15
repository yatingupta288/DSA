class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] stops = new int[10001];
        for(int[] trip : trips){
            stops[trip[1]] += trip[0];
            stops[trip[2]] -= trip[0];
        }
        
        for(int i = 0; i < stops.length; i++){
            if(i == 0){
                if(stops[i] > capacity)return false;
            }else{
                stops[i] = stops[i] + stops[i - 1];
                if(capacity < stops[i])return false;
            }
        }
        return true;
    }
}