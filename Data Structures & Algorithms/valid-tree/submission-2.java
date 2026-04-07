class Solution {
    Map<Integer, List<Integer>> adj;
    boolean vis[];

    public boolean validTree(int n, int[][] edges) {
        adj = new HashMap<>();
        vis = new boolean[n];

        for(int i = 0; i < n; i++)
            adj.put(i, new ArrayList<>());
        
        for(int p[] : edges){
            adj.get(p[0]).add(p[1]);
            adj.get(p[1]).add(p[0]);
        }

        boolean cycle = dfs(0, -1);

        if(cycle)
            return false;
        
        for(boolean p : vis)
            if(!p)
                return false;
        
        return true;
    }

    boolean dfs(int node, int parent){
        vis[node] = true;

        for(int nei : adj.get(node)){
            if(nei != parent){
                if(vis[nei])
                    return true;
                
                boolean curr = dfs(nei, node);

                if(curr)
                    return true;
            }
        }

        return false;
    }
}
