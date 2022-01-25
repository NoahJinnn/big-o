import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
    // find smallest ways from src to every point
    static void dijkstra(MyNode src, Map<Integer, List<MyNode>> graph, int[] dist, int[] path) {
        PriorityQueue<MyNode> q = new PriorityQueue<>((a, b) -> a.val - b.val); // to get next min destination
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, -1);
        src.val = 0; // dist to itself
        dist[src.id] = 0; // dist to itself
        path[src.id] = src.id;
        q.add(src);
        while(!q.isEmpty()) {
            MyNode cur = q.poll();
            if(cur.val != dist[cur.id]) continue; // bypass larger route
            List<MyNode> l = graph.get(cur.id);
            if(l != null) {
                for(MyNode n : l) {
                    if(cur.val + n.val < dist[n.id]) {
                        // Relaxation
                        int smallerDist = cur.val + n.val;
                        dist[n.id] = smallerDist;
                        path[n.id] = cur.id;
                        q.add(new MyNode(n.id, smallerDist));
                    }
                }
            }
        }
    }

    // minimum dist form A,B,C...nth node to D node (destination) equals to minimum dist from D to A,B,C...nth node
    // Distance from S node (source) to D node:
    //      dmin[S,D] = dmin[S,a] + d[a,b] + dmin[b,D];
}
