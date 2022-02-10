class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int lo = matrix[0][0];
        int hi = matrix[n - 1][m - 1];
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            int count = smallerThanMid(matrix, mid, n);
            if(count < k){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return lo;
    }
    
    public int smallerThanMid(int[][] matrix, int val, int n){
        int i = n - 1;
        int j = 0;
        int res = 0;
        while(i >= 0 && j < n){
            if(matrix[i][j] > val){
                i--;
            }else{
                res += i + 1;
                j++;
            }
        }
        return res;
    }
}