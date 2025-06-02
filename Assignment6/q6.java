package Assignment6;
import java.util.*;
public class q6 {
    private static int vertices;
    private static int[][] adjMatrix;
    private static List<List<Integer>> adjList;
    public q6(int V){
        this.vertices = V;
        adjMatrix = new int[V][V];
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }
    public void addEdge(int src,int dest){
        adjList.get(src).add(dest);adjList.get(dest).add(src);
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
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        q6 g = new q6(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 2);
        g.matrix();
        g.list();
    }
}
