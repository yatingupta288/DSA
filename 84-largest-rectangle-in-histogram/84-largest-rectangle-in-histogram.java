class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int r[] = new int[n];
        r[n-1] = n;
        for(int i = n - 2; i >= 0; i--){
            int p = i + 1;
            while(p != n && heights[p] >= heights[i]){
                p = r[p];
            }
            r[i] = p;
        }
        int l[] = new int[n];
        l[0] = -1;
        for(int i = 1; i < n; i++){
            int p = i - 1;
            while(p >= 0 && heights[p] >= heights[i]){
                p = l[p];
            }
            
            l[i] = p;
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, heights[i] * (r[i] - l[i] - 1));
        }
        return max;
    }
}