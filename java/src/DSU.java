public class DSU {
    int[] parent = new int[Integer.MAX_VALUE];
    int[] rank = new int[Integer.MAX_VALUE];
    public void createSet() {
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public int findParent(int u) {
        if(u != parent[u]) {
            parent[u] = findParent(parent[u]);
        }
        return u;
    }

    public void joinSet(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if(pu == pv) return;
        if(rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else if(rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else {
            parent[pu] = pv;
            rank[pv]++;
        }

    }

}
