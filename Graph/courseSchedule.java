public boolean canFinish(int numCourses, int[][] prerequisites){
    int[] incomingEdges = new int[numCourses];
    List<Integer>[] goCourses = new List[numCourses];
    for(int i=0;i<goCourses.length;i++){
        goCourses[i] = new LinkedList<Integer>();
    }
    for(int[] pair: prerequisites){
        incomingEdges[pair[0]]++;
        goCourses[pair[1]].add(pair[0]);
    }
    Queue<Integer> queue = new LinkedList<Integer>();
    for(int i=0;i<incomingEdges.length;i++){
        if(incomingEdges[i]==0){
            queue.add(i);
        }
    }
    int edgeCnt = prerequisites.length;
    while(!queue.isEmpty()){
        int cur = queue.poll();
        for(int goCrs: goCourses[cur]){
             edgeCnt--;
             if(--incomingEdges[goCrs]==0)
                queue.add(goCrs);
        }
    }
    return edgeCnt==0;
}