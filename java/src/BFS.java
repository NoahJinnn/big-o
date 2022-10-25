import java.util.*;

public class BFS {

    /*
     * @src root node
     * @trace finding search path
     * @check marking visited
     * @dist distance from root
     */
    static void doBFS(MyNode src, Map<Integer, List<MyNode>> graph, int[] trace, int[] dist, boolean[] check) {
        Arrays.fill(trace, -1);
        Queue<MyNode> q = new LinkedList<>();
        q.add(src);

        trace[src.id] = src.id;
        dist[src.id] = src.val;
        check[src.id] = true;

        while(!q.isEmpty()) {
            MyNode cur = q.poll();
            List<MyNode> l = graph.get(cur.id);
            if(l != null) {
                for(MyNode n : l) {
                    if(!check[n.id]) {
                        q.add(n);
                        trace[n.id] = cur.id;
                        dist[n.id] = dist[cur.id] + n.val;
                        // do sth with n.val
                    }
                    check[n.id] = true;
                }
            }
        }
    }

    static void doBFSMatrix(Point src, char[][] matrix, boolean[][] check) {
        Queue<Point> q = new LinkedList<>();
        // Init q with start point
        q.add(src);

        // Mark start
        check[src.y][src.x] = true;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};


        while(!q.isEmpty()) {
            Point cur = q.poll();

            // Scan around the node
            for(int i = 0; i < 4; i++) {
                int nxtX = dx[i] + cur.x;
                int nxtY = dy[i] + cur.y;
                
                // Search condition
                if(nxtX >= 0 && nxtX < matrix[0].length && nxtY >= 0 && nxtY < matrix.length && !check[nxtY][nxtX]) {
                    
                    // Mart as searched
                    check[nxtY][nxtX] = true;
                    // if(...) -> Business condition 
                    // Add to queue to search further from this point
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


