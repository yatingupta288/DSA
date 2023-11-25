//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        int max = Integer.MIN_VALUE;
        int sum = 0;
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum == 0){
                max = i + 1;
            }
            if(!sumMap.containsKey(sum)){
                sumMap.put(sum, i);
            }else{
                int lengthOfZeroSumArray = i - sumMap.get(sum);
                max = Math.max(max, lengthOfZeroSumArray);
            }
        }
        
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}