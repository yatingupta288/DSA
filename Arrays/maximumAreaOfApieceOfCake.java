class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxhcut = 0;
        int maxvcut = 0;
        
        for(int i = 0; i < horizontalCuts.length; i++){
            maxhcut = Math.max(maxhcut, i == 0 ? horizontalCuts[i] : horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        maxhcut = Math.max(maxhcut, h - horizontalCuts[horizontalCuts.length - 1]);
        for(int i = 0; i < verticalCuts.length; i++){
            maxvcut = Math.max(maxvcut, i == 0 ? verticalCuts[i] : verticalCuts[i] - verticalCuts[i - 1]);
        }
        maxvcut = Math.max(maxvcut, w - verticalCuts[verticalCuts.length - 1]);
        return (int)(maxhcut%(1e9 + 7) * maxvcut%(1e9 + 7));
    }
}