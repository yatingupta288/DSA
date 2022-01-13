// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String a = sc.next ();
            String b = sc.next();
            Solution obj = new Solution();
    		System.out.println (obj.check (a, b));
        }
        
    }
}// } Driver Code Ends


//User function Template for Java
class Solution
{
    int check (String a, String b)
    {
        // your code here
        a = remove(a);
        b = remove(b);
        // System.out.print(a + " " + b);
        if(a.length() > b.length()){
            return 2;
        }else if(a.length() < b.length()){
            return 1;
        }else{
            int result = a.compareTo(b);
            if(result > 0){
                return 2;
            }else if(result < 0){
                return 1;
            }else{
                return 3;
            }
        }
    }
    public String remove(String a){
        int i = 0;
        while(a.charAt(i) == '0' && i < a.length() - 1){
            i++;
        }
        // System.out.print(i + " ");
        
        return a.substring(i, a.length());
    }
}