class Solution {
    private HashSet<String> visited = new HashSet<>();
    public int openLock(String[] deadends, String target) {
    if(target == null || target.length() == 0){
        return -1;
    }
    int level = 0;
    for(String dead : deadends){
        visited.add(dead);
    }

    Queue<String> q = new LinkedList<>();
    q.offer("0000");
    while(q.size() > 0){
        int size = q.size();
        level++;
        for(int i = 0; i < size; i++){
            String curr = q.poll();
            if(visited.contains(curr))continue;
            visited.add(curr);
            if(curr.equals(target))return level - 1;
            for(String next : getNextState(curr)){
                if(!visited.contains(next))q.offer(next);
            }
        }
    }
        return -1;
        
    }
    
    private HashSet<String> getNextState(String lock){
         Set<String> newLocks = new HashSet<>();
        char[] lockChar = lock.toCharArray();
        for (int i = 0; i < 4; i++) {

            char c = lockChar[i];
            // moving clockwise
            lockChar[i] = c == '9' ? '0' : (char) (c + 1);
            newLocks.add(new String(lockChar)); // 1000 added
            // moving anticlockwise
            lockChar[i] = c == '0' ? '9' : (char) (c -1);
            newLocks.add(new String(lockChar));// 9000 added
            lockChar[i] = c; // to return the character to its original form for eg 0000
        }
        return newLocks;
}