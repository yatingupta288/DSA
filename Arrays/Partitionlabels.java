class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        int arr[] = new int[26];
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a'] = i;
        }
        
        int end = 0;
        int start = 0;
        
        for(int i = 0; i < s.length(); i++){
            end = Math.max(end, arr[s.charAt(i) - 'a']);
            if(i == end){
                list.add(end - start + 1);
                start = i + 1;
            }
        }
        return list;
    }
}

// public List<Integer> partitionLabels(String s) {
//         List<Integer> list = new ArrayList<>();
//         Map<Character, Integer> hm = new HashMap<>();
//         for(int i = 0; i < s.length(); i++){
//             hm.put(s.charAt(i), i);
//         }
        
//         int i = 0;
//         while(i < s.length()){
//             int end = hm.get(s.charAt(i));
//             int j = i;
//             while(j != end){
//                 end = Math.max(end, hm.get(s.charAt(j++)));
//             }
//             list.add(end - i + 1);
//             i = end + 1;
//         }
//         return list;
//     }