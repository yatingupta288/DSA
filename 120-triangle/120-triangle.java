class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer dp[][] = new Integer[triangle.size()][triangle.size()];
        return minimumTotalHelper(triangle, 0, 0, dp);
        // return min;
    }
    
    public Integer minimumTotalHelper(List<List<Integer>> triangle, int i , int j, Integer[][] dp){
        if(dp[i][j] != null){
            return dp[i][j];
        }
        Integer number = triangle.get(i).get(j);
        if(i < dp.length - 1){
            Integer left = minimumTotalHelper(triangle, i + 1, j, dp);
            Integer right = minimumTotalHelper(triangle, i + 1, j + 1,dp);
            number = number + Math.min(left, right);
        }
        return dp[i][j] = number;
    }
}

// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int m = triangle.size();
//         // use null to distinguish whether it is empty
//         Integer[][] memo = new Integer[m][m];
//         List<Integer> bottom = triangle.get(m-1);
//         for (int i=0;i<bottom.size();i++){
//             memo[m-1][i] = bottom.get(i);
//         }
        
//         return getMemo(0,0,memo,triangle);
        
        
//     }
    
//     private int getMemo(int x, int y, Integer[][]memo, List<List<Integer>> triangle ){
//         if (x>=triangle.size() || y >=triangle.get(x).size())
//             return 0;
//         // Key point
//         if (memo[x][y] != null)
//             return memo[x][y];
        
//         int self = triangle.get(x).get(y);
//         int left = getMemo(x+1,y,memo,triangle) + self;
//         int right = getMemo(x+1,y+1,memo,triangle) + self;
        
//         return memo[x][y] = Math.min(left,right);

//     }
// }