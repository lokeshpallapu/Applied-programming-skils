class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int groupId = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = groupId++;
            }
        }

        List<List<Integer>> itemGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) itemGraph.add(new ArrayList<>());
        int[] itemIndegree = new int[n];

        List<List<Integer>> groupGraph = new ArrayList<>();
        for (int i = 0; i < groupId; i++) groupGraph.add(new ArrayList<>());
        int[] groupIndegree = new int[groupId];

        for (int i = 0; i < n; i++) {
            for (int prev : beforeItems.get(i)) {
                itemGraph.get(prev).add(i);
                itemIndegree[i]++;

                if (group[prev] != group[i]) {
                    groupGraph.get(group[prev]).add(group[i]);
                    groupIndegree[group[i]]++;
                }
            }
        }

        List<Integer> itemOrder = topologicalSort(itemGraph, itemIndegree, n);
        List<Integer> groupOrder = topologicalSort(groupGraph, groupIndegree, groupId);

        if (itemOrder.isEmpty() || groupOrder.isEmpty()) {
            return new int[0];
        }

        Map<Integer, List<Integer>> orderedGroups = new HashMap<>();
        for (int item : itemOrder) {
            orderedGroups.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);
        }

        int[] result = new int[n];
        int idx = 0;
        for (int g : groupOrder) {
            List<Integer> items = orderedGroups.getOrDefault(g, new ArrayList<>());
            for (int item : items) {
                result[idx++] = item;
            }
        }

        return result;
    }

    private List<Integer> topologicalSort(List<List<Integer>> graph, int[] indegree, int count) {
        List<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order.add(curr);
            for (int next : graph.get(curr)) {
                indegree[next]--;
                if (indegree[next] == 0) queue.offer(next);
            }
        }

        return order.size() == count ? order : new ArrayList<>();
    }
}