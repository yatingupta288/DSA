class Solution {
    public int maxArea(int[] height) {
        int li = 0;
        int ri = height.length - 1;
        int max = 0;
        while(li < ri){
            max = Math.max(max, (ri - li)*Math.min(height[ri], height[li]));
            if(height[li] > height[ri]){
                ri--;
            }else{
                li++;
            }
        }
        
        return max;
    }
}