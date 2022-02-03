class Solution {
    public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < b.length; j++){
                map.put(a[i] + b[j], map.getOrDefault(a[i] + b[j], 0) + 1);
            }
        }
        
        for(int i = 0; i < c.length; i++){
            for(int j = 0; j < d.length; j++){
                count += map.getOrDefault(-1 * (c[i] + d[j]), 0);
            }
        }
        return count;
    }
}