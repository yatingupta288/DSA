class Solution{
    public static int doUnion(int a[], int n, int b[], int m) 
    {
        //Your code here
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int i = 0; i < n; i++){
            h.put(a[i], i);
        }
        for(int i = 0; i < m; i++){
            h.put(b[i], i);
        }
        
        
        return h.size();
    }
}