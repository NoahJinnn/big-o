import java.util.Scanner;

public class FloydWarshall {
    static int V = 105; // example amount of vertexes
    static int[][] graph = new int[V][V];
    static int[][] dist= new int[V][V];
    static int[][] path= new int[V][V];;
    FloydWarshall() {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                int w = sc.nextInt();
                if(i != j && w == 0) {
                    graph[i][j] = Integer.MAX_VALUE;
                    dist[i][j] = Integer.MAX_VALUE;
                } else {
                    graph[i][j] = w;
                    graph[i][j] = w;
                }
            }
        }
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
               if(i == j) {
                   path[i][j] = 0;
               } else if(dist[i][j] != Integer.MAX_VALUE) {
                   path[i][j] = i;
               } else {
                   path[i][j] = -1;
               }
            }
        }
    }

    public static boolean doFW() {
        for(int k = 0; k < V; k++) {
            for(int i = 0; i < V; i++) {
                for(int j = 0; j < V; j++) {
                    if(dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = path[k][j];
                    }
                }
                if(dist[i][i] < 0) {
                    return false; //graph contains negative weight cycle
                }
            }
        }
        return true;
    }

    public void printPath(int src, int des) {
        while(path[src][des] != src) {
            System.out.println(path[src][des]);
            des = path[src][des];
        }
    }
}
