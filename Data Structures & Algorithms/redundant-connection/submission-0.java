class Solution {
    Map<Integer, Set<Integer>> adj;
    int n;
    boolean vis[];

    public int[] findRedundantConnection(int[][] edges) {
        adj = new HashMap<>();

        for (int p[] : edges) {
            if (!adj.containsKey(p[0]))
                adj.put(p[0], new HashSet<>());

            if (!adj.containsKey(p[1]))
                adj.put(p[1], new HashSet<>());

            adj.get(p[0]).add(p[1]);
            adj.get(p[1]).add(p[0]);
        }

        int len = edges.length;
        n = adj.size();
        // System.out.println(adj);

        for (int i = len - 1; i >= 0; i--) {
            // remove edge and check for number of components
            adj.get(edges[i][0]).remove(edges[i][1]);
            adj.get(edges[i][1]).remove(edges[i][0]);

            int components = count();
            // System.out.println(Arrays.toString(edges[i]) + " " + components);

            if (components == 1) {
                return new int[] { edges[i][0], edges[i][1] };
            }

            // backtrack
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        // System.out.println(adj);

        return new int[] { -1, -1 };
    }

    int count() {
        int k = 0;
        vis = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                k++;
                vis[i] = true;

                dfs(i);
            }
        }

        // System.out.println(Arrays.toString(vis));

        return k;
    }

    void dfs(int node) {
        for (int nei : adj.get(node)) {
            if (!vis[nei]) {
                vis[nei] = true;
                dfs(nei);
            }
        }
    }
}
