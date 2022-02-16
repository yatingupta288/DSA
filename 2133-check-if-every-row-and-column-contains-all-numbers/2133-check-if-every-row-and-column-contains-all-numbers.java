class Solution {
    public boolean checkValid(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> set2 = new HashSet<>();
            for(int j = 0; j < matrix.length; j++){
                if(!set1.add(matrix[i][j]) || !set2.add(matrix[j][i])){
                    return false;
                }
            }
        }
        return true;
    }
}