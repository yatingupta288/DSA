class Pair {
	int city, cost;

	Pair(int city, int cost) {
		this.city = city;
		this.cost = cost;
	}
}

class City {
	int city, distFromSrc, costFromSrc;

	City(int city, int distFromSrc, int cost) {
		this.city = city;
		this.distFromSrc = distFromSrc;
		this.costFromSrc = cost;
	}
}

class Solution {

       public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // DFS
        if(n <= 0 || flights.length == 0 || K < 0)
            return -1;

        List<List<Pair>> graph = new ArrayList<>();
        this.buildGraph(graph, n, flights);

        Queue<City> pQueue = new PriorityQueue<>((City c1, City c2) -> c1.costFromSrc - c2.costFromSrc);
        pQueue.offer(new City(src, 0, 0));

        HashMap<Integer, Integer> seen = new HashMap<>();

        int totalCost = 0;

        while (!pQueue.isEmpty()) {
            City top = pQueue.poll();

            if(seen.containsKey(top.city) && seen.get(top.city)<=top.distFromSrc)
                continue;
            seen.put(top.city, top.distFromSrc);

            if (top.city == dst) {
                return top.costFromSrc;
            }

            if (top.distFromSrc > K) {
                continue;
            }

            List<Pair> neighbors = graph.get(top.city);
            for (Pair neighbor: neighbors) {
                pQueue.offer(new City(neighbor.city, top.distFromSrc + 1, top.costFromSrc + neighbor.cost));
            }
        }

        return -1;
    }

    private void buildGraph(List<List<Pair>> graph, int n, int[][] flights) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight: flights) {
            graph.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
    }
}

// class Solution {
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//         int[][] adjMatrix = new int[n][n];
//         int[] visited = new int[n];
     
//         for (int i = 0; i<flights.length; i++) {
//             int s = flights[i][0];
//             int e = flights[i][1];
//             int p = flights[i][2];
//             adjMatrix[s][e] = p;
//         }
        
//         Queue<int[]> queue = new LinkedList<>();
//         queue.add(new int[]{src, 0});
        
//         int min = Integer.MAX_VALUE;
//         K++;
//         while (!queue.isEmpty() && K >= 0) {
//             int size = queue.size();
//             for (int i = 0; i<size; i++) {
//                 int[] pair = queue.poll();
//                 int s = pair[0];
//                 int p = pair[1];
//                 if (s == dst) {
//                     min = Math.min(p, min);
//                 }
                
//                 for (int j = 0; j<adjMatrix[0].length; j++) {
//                     if (adjMatrix[s][j] != 0) {
//                         if (visited[j] == 0 || visited[j] > p + adjMatrix[s][j]) {
//                             visited[j] = p + adjMatrix[s][j];
//                             queue.add(new int[]{j, p + adjMatrix[s][j]});    
//                         }
                        
//                     }
//                 }
//             }
//             K--;
//         }
//         return min == Integer.MAX_VALUE? -1: min;
//     }
// }