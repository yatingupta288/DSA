class Solution {
    public int numTrees(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(0,1);
        map.put(1, 1);
        
        return getTotal(n, map);
    }
    
    public int getTotal(int n, Map<Integer, Integer> map){
        if(map.containsKey(n)){
            return map.get(n);
        }
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += getTotal(i - 1, map) * getTotal(n - i, map);
        }
        
        map.put(n, sum);
        return sum;
    }
}