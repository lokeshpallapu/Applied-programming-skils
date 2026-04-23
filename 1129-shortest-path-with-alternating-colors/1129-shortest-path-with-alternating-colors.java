class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[][] adj = new ArrayList[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = new ArrayList<>();
            }
        }

        for (int[] edge : redEdges) adj[0][edge[0]].add(edge[1]);
        for (int[] edge : blueEdges) adj[1][edge[0]].add(edge[1]);

        int[][] dists = new int[2][n];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dists[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        dists[0][0] = 0;
        dists[1][0] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int u = curr[0];
            int color = curr[1];
            int nextColor = 1 - color;

            for (int v : adj[nextColor][u]) {
                if (dists[nextColor][v] == -1) {
                    dists[nextColor][v] = dists[color][u] + 1;
                    queue.offer(new int[]{v, nextColor});
                }
            }
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int d1 = dists[0][i];
            int d2 = dists[1][i];
            if (d1 == -1 || d2 == -1) {
                res[i] = Math.max(d1, d2);
            } else {
                res[i] = Math.min(d1, d2);
            }
        }
        return res;
    }
}