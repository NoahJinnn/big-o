import java.util.*;

public class BFS {
    static void doBFS(MyNode src, Map<Integer, List<MyNode>> graph, int[] trace, int[] dist, boolean[] check) {
        Arrays.fill(trace, -1);
        Queue<MyNode> q = new LinkedList<>();
        q.add(src);
        check[src.id] = true;
        trace[src.id] = src.id;
        dist[src.id] = src.val;
        while(!q.isEmpty()) {
            MyNode cur = q.poll();
            List<MyNode> l = graph.get(cur.id);
            if(l != null) {
                for(MyNode n : l) {
                    check[n.id] = true;
                    trace[n.id] = cur.id;
                    dist[n.id] = dist[cur.id] + n.val;
                    // do sth with n.val
                }
            }
        }
    }

    static void doBFSMatrix(Point src, char[][] matrix, boolean[][] check) {
        Queue<Point> q = new LinkedList<>();
        q.add(src);
        check[src.y][src.x] = true;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int nxtX = dx[i] + cur.x;
                int nxtY = dy[i] + cur.y;
                if(nxtX >= 0 && nxtX < matrix[0].length && nxtY >= 0 && nxtY < matrix.length && !check[nxtY][nxtX]) {
                    check[nxtY][nxtX] = true;
                    q.add(new Point(nxtX, nxtY));
                }
            }
        }
    }

    static List<Integer> getPath(int src, int des, int[] trace) {
        List<Integer>  path = new ArrayList<>();
        path.add(des);
        if(des == src) {
            return path;
        }
        if(trace[des] == -1) {
            // no path
            return path;
        }
        int nxt = trace[des];
        while(true) {
            path.add(nxt);
            if(nxt == src) {
                return path;
            }
            nxt = trace[des];
        }
    }

}


