// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> list = new ArrayList<>();
        solve(0, 0, m, n, list,"");
        return list;
    }
    
    public static void solve(int i, int j, int[][] m, int n, List<String> list, String s){
        if(i < 0 || j < 0 || i == n || j == n || m[i][j] == 0 || m[i][j] == 2){
            return;
        }
        if(i == n - 1 && j == n - 1){
            list.add(s);
            return;
        }
        m[i][j] = 2;
        solve(i - 1, j, m, n, list, s + "U");
        solve(i + 1, j, m, n, list, s + "D");
        solve(i, j - 1, m, n, list, s + "L");
        solve(i, j + 1, m, n, list, s + "R");
        m[i][j] = 1;
        return;
    }
}