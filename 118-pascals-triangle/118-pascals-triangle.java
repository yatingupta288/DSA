class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> row, pre = null;
        for(int i = 0; i < n; i++){
            row = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    row.add(1);
                }else{
                    row.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = row;
            list.add(row);
        }
        
        return list;
    }
}





















