// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0; i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.offerings(N, arr));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    int offerings(int N, int arr[]){
        // code here
        int offer[] = new int[arr.length];
        offer[0] = 1;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > arr[i - 1]){
                offer[i] = offer[i - 1] + 1;
            }else{
                if(offer[i - 1] > 1){
                    offer[i] = min;
                }else{
                    offer[i] = offer[i - 1];
                }
            }
            min = Math.min(min, offer[i-1]);
        }
        
        for(int j = arr.length - 2; j >= 0; j--){
            if(arr[j] > arr[j + 1]){
                if(offer[j]  > offer[j + 1]){
                    continue;
                }else{
                    offer[j] = 1 + offer[j + 1];
                }
            }else{
                continue;
            }
        }
        int sum = 0;
        for(int i = 0; i < offer.length; i++){
            sum += offer[i];
        }
        
        return sum;
    }
}