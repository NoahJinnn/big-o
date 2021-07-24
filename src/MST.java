import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MST {

    // Create MST with sum of all edge weight is smallest
    public void doGrim(MyNode src, Map<Integer, List<MyNode>> graph, int[] dist, int[] path, boolean[] check) {
        Arrays.fill(dist, -1);
        Arrays.fill(path, Integer.MAX_VALUE);
        PriorityQueue<MyNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        dist[src.id] = 0;
        path[src.id] = src.id;
        check[src.id] = true;
        while(!q.isEmpty()) {
            MyNode cur = q.poll();
            check[cur.id] = true;
            if(cur.val != dist[cur.id]) continue;
            List<MyNode> l = graph.get(cur.id);
            if(l != null) {
                for(MyNode n : l) {
                    if(!check[n.id] && n.val < dist[n.id]) {
                        q.add(new MyNode(n.id, n.val));
                        dist[n.id] = n.val;
                        path[n.id] = cur.id;
                    }
                }
            }
        }
    }
}
