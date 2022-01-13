class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1] ,b[1]));
        int count = 0;
        // int burst = points.length;
        int i = 0;
        while(i < points.length){
            int arrowpos = points[i][1];
            while(i < points.length && arrowpos >= points[i][0]){
                i++;
            }
            count++;
            
        }
        return count;
    }
    
}