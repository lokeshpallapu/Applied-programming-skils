class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int emailsCount = 0;
        
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailsCount++);
                    emailToName.put(email, name);
                }
            }
        }

        DSU dsu = new DSU(emailsCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            for (int i = 2; i < account.size(); i++) {
                dsu.union(emailToIndex.get(firstEmail), emailToIndex.get(account.get(i)));
            }
        }

        Map<Integer, List<String>> merged = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int root = dsu.find(emailToIndex.get(email));
            merged.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> component : merged.values()) {
            Collections.sort(component);
            List<String> account = new ArrayList<>();
            account.add(emailToName.get(component.get(0)));
            account.addAll(component);
            result.add(account);
        }

        return result;
    }
}

class DSU {
    int[] parent;
    public DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    public int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }
    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) parent[rootI] = rootJ;
    }
}