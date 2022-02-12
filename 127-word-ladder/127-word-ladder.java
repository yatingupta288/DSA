class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))return 0;
        HashSet<String> list = new HashSet<>(wordList);
        Queue<String> q = new ArrayDeque<>();
        HashSet<String> set = new HashSet<>();
        q.add(beginWord);
        set.add(beginWord);
        int steps = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String s = q.poll();
                if(s.equals(endWord)){
                    return steps;
                }
                for(int j = 0; j < s.length(); j++){
                    for(char k = 'a'; k <='z'; k++){
                        char ch[] = s.toCharArray();
                        ch[j] = k;
                        String s1 = new String(ch);
                        if(list.contains(s1) && !set.contains(s1)){
                            set.add(s1);
                            q.add(s1);
                        }
                    }
                }
            }
            ++steps;
        }
        return 0;
            
    }
}
