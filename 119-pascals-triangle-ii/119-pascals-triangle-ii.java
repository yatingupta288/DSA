class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> sublist = new ArrayList<>();
        sublist.add(1);
        list.add(sublist);
        for(int i = 1; i <=rowIndex; i++){
            list.add(new ArrayList<>());
            for(int j = 0; j < i; j++){
                if(j == 0){
                    list.get(i).add(1);
                }else{
                    int val = list.get(i - 1).get(j) + list.get(i - 1).get(j - 1);
                    list.get(i).add(val);
                }
            }
            list.get(i).add(1);
        }
        return list.get(rowIndex);
    }
}