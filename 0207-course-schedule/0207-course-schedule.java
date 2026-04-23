class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }

        int[] visit = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(adj, visit, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> adj, int[] visit, int curr) {
        if (visit[curr] == 1) return true;
        if (visit[curr] == 2) return false;

        visit[curr] = 1;
        for (int next : adj.get(curr)) {
            if (hasCycle(adj, visit, next)) {
                return true;
            }
        }
        visit[curr] = 2;
        return false;
    }
}