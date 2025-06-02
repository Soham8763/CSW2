package Assignment6;
import java.util.*;
public class q7 {
    private static int vertices;
    private static int[][] adjMatrix;
    private static LinkedList<Integer>[] adjList;
    public q7(int V){
        this.vertices = V;
        adjMatrix = new int[V][V];
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    public void addEdge(int src,int dest){
        adjList[src].add(dest);adjList[dest].add(src);
        adjMatrix[src][dest] = 1;adjMatrix[dest][src] = 1;
    }
    public void matrix(){
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjMatrix[i][j]);
            }
            System.out.println();
        }
    }
    public static void list(){
        for (int i = 0; i < vertices; i++) {
            System.out.print(i+" -> ");
            for (int j = 0; j < adjList[i].size(); j++) {
                System.out.print(adjList[i].get(j)+" ");
            }
            System.out.println();
        }
    }
    public static void dfs(int startVertex){
        boolean[] visited = new boolean[vertices];
        dfsUtil(startVertex,visited);
    }
    public static void dfsUtil(int startVertex, boolean[] visited){
        visited[startVertex] = true;
        System.out.print(startVertex+" ");
        for (Integer neighbour : adjList[startVertex]) {
            if(!visited[neighbour]){
                dfsUtil(neighbour, visited);
            }
        }
    }
    public static void main(String[] args) {
        q7 g = new q7(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 2);
        g.dfs(0);
    }
}
