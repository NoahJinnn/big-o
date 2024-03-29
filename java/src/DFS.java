import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;


public class DFS {
    /*
     * @src root node
     * @trace finding search path
     * @check marking visited
     * @dist distance from root
     */
    static void doDFS(MyNode src, Map<Integer, List<MyNode>> graph, int[] trace, int[] dist, boolean[] check) {
        Arrays.fill(trace, -1);
        Stack<MyNode> s = new Stack<>();
        s.add(src);

        trace[src.id] = src.id;
        dist[src.id] = src.val;
        check[src.id] = true;

        while (!s.isEmpty()) {
            MyNode cur = s.pop();
            List<MyNode> l = graph.get(cur.id);
            if (l != null) {
                for (MyNode n : l) {
                    if (!check[n.id]) {
                        s.add(n);
                        trace[n.id] = cur.id;
                        dist[n.id] = dist[cur.id] + n.val;
                    }
                    check[n.id] = true;
                }
            }
        }
    }

    static void doDFSRecur(MyNode src, Map<Integer, List<MyNode>> graph, int[] trace, int[] dist, boolean[] check) {
        trace[src.id] = src.id;
        dist[src.id] = src.val;
        check[src.id] = true;

        List<MyNode> l = graph.get(src.id);
        if (l != null) {
            for (MyNode n : l) {
                if (!check[n.id]) {
                    check[n.id] = true;
                    trace[n.id] = src.id;
                    ;
                    dist[n.id] = dist[src.id] + n.val;
                    doDFSRecur(n, graph, trace, dist, check);
                }
            }
        }
    }

}
