class Solution {
    public int maxArea(int[] height) {
        int li = 0;
        int ri = height.length - 1;
        int water = 0;
        while(li < ri){
            water = Math.max(water, (ri - li )* Math.min(height[li], height[ri]));
            if(height[li] < height[ri]){
                li++;
            }else{
                ri--;
            }
        }
        return water;
    }
}            