// public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
//         PriorityQueue<double[]> pq = new PriorityQueue<double[]>((a, b) -> ((int)((b[1] - a[1]) * 1000000000)));
//         Map<Integer, Map<Integer, Double>> g = buildGraph(edges, succProb);
//         pq.offer(new double[]{start, 1.0});
//         Set<Integer> vs = new HashSet<>();
//         Map<Integer, Double> probs = new HashMap<>();
//         probs.put(start, 1.0);
//         while (!pq.isEmpty()){
//             double[] curr = pq.poll();
//             if (vs.contains((int) curr[0])) continue;
//             vs.add((int) curr[0]);
//             if (((int) curr[0]) == end) return curr[1];
//             for (int neig : g.getOrDefault((int) curr[0], new HashMap<>()).keySet()) {
//                 if (vs.contains(neig)) continue;
//                 double prob = curr[1] * g.get((int) curr[0]).get(neig);
//                 if (prob > probs.getOrDefault(neig, 0.0)) {
//                     probs.put(neig, prob);
//                     pq.offer(new double[]{neig, prob});
//                 }
//             }
//         }
//         return 0;
//     }
    
//     private Map<Integer, Map<Integer, Double>> buildGraph(int[][] edges, double[] succProb) {
//         Map<Integer, Map<Integer, Double>> g = new HashMap<>();
//         for (int i = 0; i < edges.length; i++) {
//             g.computeIfAbsent(edges[i][0], k -> new HashMap<>());
//             g.computeIfAbsent(edges[i][1], k -> new HashMap<>());
//             g.get(edges[i][0]).put(edges[i][1], succProb[i]);
//             g.get(edges[i][1]).put(edges[i][0], succProb[i]);
//         }
//         return g;
//     }

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        HashMap<Integer, Double>graph[] = new HashMap[n];
        for (int i = 0; i < n; i++)
			graph[i] = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
           int a = edges[i][0];
           int b = edges[i][1];
           graph[a].put(b, succProb[i]);
           graph[b].put(a, succProb[i]);
        }
        double[] prob = new double[n];
        prob[start] = 1.0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingDouble(i -> -prob[i]));
        pq.offer(start);
        while(!pq.isEmpty()){
            int curr = pq.poll();
            if(curr == end){
                return prob[curr];
            }
            
            for(int neigh : graph[curr].keySet()){
                double neighprob = graph[curr].get(neigh);
                if(prob[curr] * neighprob > prob[neigh]){
                    prob[neigh] = prob[curr] * neighprob;
                    pq.offer(neigh);
                }
            }
        }
        return 0.0;
    }
}



//  class State {
//         int node;
//         double prob;
//         State(int _node, double _prob) {
//             node = _node;
//             prob = _prob;
//         }
//     }

//     public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

//         // build graph -> double[0]: node, double[1]: parent-to-node prob
//         Map<Integer, List<double[]>> map = new HashMap<>();
//         for (int i = 0; i < edges.length; ++i) {
//             int[] edge = edges[i];

//             map.putIfAbsent(edge[0], new ArrayList<>());
//             map.putIfAbsent(edge[1], new ArrayList<>());

//             map.get(edge[0]).add(new double[] {edge[1], succProb[i]});
//             map.get(edge[1]).add(new double[] {edge[0], succProb[i]});
//         }

//         double[] probs = new double[n];  // best prob so far for each node
//         PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> (((Double) b.prob).compareTo((Double) a.prob)));
//         pq.add(new State(start, 1.0));

//         while (!pq.isEmpty()) {

//             State state = pq.poll();
//             int parent = state.node;
//             double prob = state.prob;

//             if (parent == end) return prob;

//             for (double[] child : map.getOrDefault(parent, new ArrayList<>())) {
//                 // add to pq only if: it can make a better prob
//                 if (probs[(int) child[0]] >= prob * child[1]) continue;

//                 pq.add(new State((int) child[0], prob * child[1]));
//                 probs[(int) child[0]] = prob * child[1];
//             }

//         }

//         return 0;
//     }