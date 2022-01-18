class Solution {
    public boolean canPlaceFlowers(int[] a, int n) {
        for(int i = 0; i < a.length; i++){
            if(a[i] == 0){
                int prev = i == 0 ? 0 : a[i - 1];
                int next = i == a.length - 1 ? 0 : a[i + 1];
                
                if(prev == 0 && next == 0){
                    a[i] = 1;
                    n--;
                }
            }
        }
        return n <= 0;
    }
}