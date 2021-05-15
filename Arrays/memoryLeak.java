class Solution {
    public int[] memLeak(int memory1, int memory2) {
        int count = 0; 
        int i = 1;
        int m = memory1;
        int n = memory2;
        while(m >= i || n >= i ){
            if(m >= n){
                m = m - i;
                i++;
            }else{
                n = n - i;
                i++;
            }
        }
        int arr3[] = {i, m, n};
        return arr3;
    }
}
