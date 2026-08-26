class Solution {
    public boolean isNegativeWeightCycle(int V, int[][] edges) {
        // code here
        long[] dist = new long[V];



        // Run V iterations

        for (int i = 0; i < V; i++) {

            boolean updated = false;



            for (int[] edge : edges) {

                int u = edge[0];

                int v = edge[1];

                int w = edge[2];



                if (dist[v] > dist[u] + w) {

                    dist[v] = dist[u] + w;

                    updated = true;



                    // Relaxation on V-th iteration => negative cycle

                    if (i == V - 1) {

                        return true;

                    }

                }

            }



            // No relaxation means no negative cycle

            if (!updated) {

                return false;

            }

        }



        return false;
    }
}