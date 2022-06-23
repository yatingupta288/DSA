// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}
// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        helper(0, list, N, 0, arr);
        return list;
    }
    
    void helper(int idx, ArrayList<Integer> list, int n, int sum, ArrayList<Integer> nums){
        list.add(sum);
        if(idx == n){
            return;
        }
        
        for(int i = idx; i < nums.size(); i++){
            sum += nums.get(i);
            helper(i + 1, list, n, sum, nums);
            sum -= nums.get(i);
        }
        
        return;
    }
}