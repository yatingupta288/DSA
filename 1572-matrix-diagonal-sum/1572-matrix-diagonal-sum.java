class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for(int i = 0; i < mat.length; i++){
            sum += mat[i][i];
            sum += i == mat.length - i - 1 ? 0 : mat[i][mat.length - i - 1];
        }
        return sum;
    }
}