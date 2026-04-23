class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == destination) return true;

            for (int neighbor : adj.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return false;
    }
}