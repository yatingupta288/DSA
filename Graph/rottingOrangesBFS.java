class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        //Put the position of all rotten oranges in queue
        //count the number of fresh oranges
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                }
                else if(grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }
        //if count of fresh oranges is zero --> return 0 
        if(count_fresh == 0) return 0;
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        //bfs starting from initially rotten oranges
        while(!queue.isEmpty()) {
            ++count;
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                int[] point = queue.poll();
                for(int dir[] : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    //if x or y is out of bound
                    //or the orange at (x , y) is already rotten
                    //or the cell at (x , y) is empty
                        //we do nothing
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    //mark the orange at (x , y) as rotten
                    grid[x][y] = 2;
                    //put the new rotten orange at (x , y) in queue
                    queue.offer(new int[]{x , y});
                    //decrease the count of fresh oranges by 1
                    count_fresh--;
                }
            }
        }
        return count_fresh == 0 ? count-1 : -1;
    }
}
// public int orangesRotting(int[][] grid) {
//         if(grid.length==0) return 0;
//         List<int[]> rotted = new ArrayList();
//         int fresh = 0;
//         int ans = 0;
//         for(int i=0;i<grid.length;i++){
//             for(int j=0;j<grid[0].length;j++){
//                 if(grid[i][j]==2) rotted.add(new int[]{i,j});
//                 if(grid[i][j]==1) fresh++;
//             }
//         }
//         if(fresh==0) return 0;
//         while(rotted.size()>0){
//             List<int[]> temp =new ArrayList();
//             for(int[] coor:rotted){
//                 int i=coor[0], j=coor[1];
//                 if(i-1>=0&&grid[i-1][j]==1){
//                     temp.add(new int[]{i-1,j});
//                     grid[i-1][j]=2;
//                     fresh--;
//                 }
//                 if(i+1<grid.length&&grid[i+1][j]==1){
//                     temp.add(new int[]{i+1,j});
//                     grid[i+1][j]=2;
//                     fresh--;
//                 }
//                 if(j-1>=0&&grid[i][j-1]==1){
//                     temp.add(new int[]{i,j-1});
//                     grid[i][j-1]=2;
//                     fresh--;
//                 }
//                 if(j+1<grid[0].length&&grid[i][j+1]==1){
//                     temp.add(new int[]{i,j+1});
//                     grid[i][j+1]=2;
//                     fresh--;
//                 }
//             }
//             rotted=temp;
//             ans++;
//         }
//         if(fresh>0) return -1;
//         return --ans;
//     }