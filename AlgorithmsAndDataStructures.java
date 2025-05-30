import java.util.*;

public class AlgorithmsAndDataStructures {

    // Graph representation using adjacency list
    private Map<Integer, List<Edge>> adjList;
    // Graph representation using adjacency matrix
    private int[][] adjMatrix;
    private int vertices;

    // Edge class for weighted graphs
    static class Edge implements Comparable<Edge> {
        int dest, weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    // Constructor
    public AlgorithmsAndDataStructures(int vertices) {
        this.vertices = vertices;
        this.adjList = new HashMap<>();
        this.adjMatrix = new int[vertices][vertices];

        // Initialize adjacency list
        for (int i = 0; i < vertices; i++) {
            adjList.put(i, new ArrayList<>());
        }

        // Initialize adjacency matrix
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                adjMatrix[i][j] = (i == j) ? 0 : Integer.MAX_VALUE;
            }
        }
    }

    // Add edge for unweighted graph
    public void addEdge(int src, int dest) {
        addEdge(src, dest, 1);
    }

    // Add edge for weighted graph
    public void addEdge(int src, int dest, int weight) {
        // Add to adjacency list
        adjList.get(src).add(new Edge(dest, weight));

        // Add to adjacency matrix
        adjMatrix[src][dest] = weight;
    }

    // Add undirected edge
    public void addUndirectedEdge(int src, int dest, int weight) {
        addEdge(src, dest, weight);
        addEdge(dest, src, weight);
    }

    // DFS Algorithm
    public void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS traversal: ");
        dfsUtil(start, visited);
        System.out.println();
    }

    private void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (Edge edge : adjList.get(vertex)) {
            if (!visited[edge.dest]) {
                dfsUtil(edge.dest, visited);
            }
        }
    }

    // BFS Algorithm
    public void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        System.out.print("BFS traversal: ");
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (Edge edge : adjList.get(vertex)) {
                if (!visited[edge.dest]) {
                    visited[edge.dest] = true;
                    queue.offer(edge.dest);
                }
            }
        }
        System.out.println();
    }

    // Kruskal's Algorithm
    public void kruskalsAlgorithm() {
        List<Edge> edges = new ArrayList<>();

        // Get all edges
        for (int i = 0; i < vertices; i++) {
            for (Edge edge : adjList.get(i)) {
                edges.add(new Edge(i * vertices + edge.dest, edge.weight));
            }
        }

        // Sort edges by weight
        edges.sort(Comparator.comparingInt(e -> e.weight));

        // Union-Find data structure
        int[] parent = new int[vertices];
        int[] rank = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        List<Edge> mst = new ArrayList<>();
        int totalWeight = 0;

        for (Edge edge : edges) {
            int src = edge.dest / vertices;
            int dest = edge.dest % vertices;

            int srcParent = find(parent, src);
            int destParent = find(parent, dest);

            if (srcParent != destParent) {
                mst.add(new Edge(dest, edge.weight));
                totalWeight += edge.weight;
                union(parent, rank, srcParent, destParent);
            }
        }

        System.out.println("Kruskal's MST weight: " + totalWeight);
    }

    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    private void union(int[] parent, int[] rank, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);

        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }

    // Prim's Algorithm
    public void primsAlgorithm() {
        boolean[] inMST = new boolean[vertices];
        int[] key = new int[vertices];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0));

        int totalWeight = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.dest;

            if (inMST[u]) continue;

            inMST[u] = true;
            totalWeight += current.weight;

            for (Edge edge : adjList.get(u)) {
                int v = edge.dest;
                if (!inMST[v] && edge.weight < key[v]) {
                    key[v] = edge.weight;
                    pq.offer(new Edge(v, edge.weight));
                }
            }
        }

        System.out.println("Prim's MST weight: " + totalWeight);
    }

    // Dijkstra's Algorithm
    public void dijkstrasAlgorithm(int src) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(src, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.dest;

            if (current.weight > dist[u]) continue;

            for (Edge edge : adjList.get(u)) {
                int v = edge.dest;
                int newDist = dist[u] + edge.weight;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.offer(new Edge(v, newDist));
                }
            }
        }

        System.out.println("Dijkstra's shortest distances from vertex " + src + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To vertex " + i + ": " +
                (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }

    // Brute Force String Matching
    public static List<Integer> bruteForceStringMatch(String text, String pattern) {
        List<Integer> matches = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                matches.add(i);
            }
        }

        return matches;
    }

    // Rabin-Karp Algorithm
    public static List<Integer> rabinKarpStringMatch(String text, String pattern) {
        List<Integer> matches = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        int prime = 101;
        int base = 256;

        if (m > n) return matches;

        long patternHash = 0;
        long textHash = 0;
        long h = 1;

        // Calculate h = base^(m-1) % prime
        for (int i = 0; i < m - 1; i++) {
            h = (h * base) % prime;
        }

        // Calculate hash for pattern and first window
        for (int i = 0; i < m; i++) {
            patternHash = (base * patternHash + pattern.charAt(i)) % prime;
            textHash = (base * textHash + text.charAt(i)) % prime;
        }

        // Slide the pattern over text
        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash) {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    matches.add(i);
                }
            }

            // Calculate hash for next window
            if (i < n - m) {
                textHash = (base * (textHash - text.charAt(i) * h) + text.charAt(i + m)) % prime;
                if (textHash < 0) {
                    textHash += prime;
                }
            }
        }

        return matches;
    }

    // Merge Sort Algorithm
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) return;
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    private static void mergeSortHelper(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortHelper(arr, left, mid);
            mergeSortHelper(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    // Counting Inversions using Merge Sort
    public static long countInversions(int[] arr) {
        return countInversionsHelper(arr, 0, arr.length - 1);
    }

    private static long countInversionsHelper(int[] arr, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count += countInversionsHelper(arr, left, mid);
            count += countInversionsHelper(arr, mid + 1, right);
            count += mergeAndCount(arr, left, mid, right);
        }
        return count;
    }

    private static long mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        long count = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, left, temp.length);
        return count;
    }

    // Quick Sort Algorithm
    public static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }

    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortHelper(arr, low, pi - 1);
            quickSortHelper(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Distance in unweighted graph using BFS
    public int distanceUnweighted(int src, int dest) {
        if (src == dest) return 0;

        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> distQueue = new LinkedList<>();

        visited[src] = true;
        queue.offer(src);
        distQueue.offer(0);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            int dist = distQueue.poll();

            for (Edge edge : adjList.get(vertex)) {
                if (!visited[edge.dest]) {
                    if (edge.dest == dest) {
                        return dist + 1;
                    }
                    visited[edge.dest] = true;
                    queue.offer(edge.dest);
                    distQueue.offer(dist + 1);
                }
            }
        }

        return -1; // No path found
    }

    // Distance in weighted graph using Dijkstra
    public int distanceWeighted(int src, int dest) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(src, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.dest;

            if (u == dest) {
                return dist[dest];
            }

            if (current.weight > dist[u]) continue;

            for (Edge edge : adjList.get(u)) {
                int v = edge.dest;
                int newDist = dist[u] + edge.weight;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.offer(new Edge(v, newDist));
                }
            }
        }

        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }

    // Display adjacency list
    public void displayAdjacencyList() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + ": ");
            for (Edge edge : adjList.get(i)) {
                System.out.print("(" + edge.dest + "," + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    // Display adjacency matrix
    public void displayAdjacencyMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (adjMatrix[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(adjMatrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    // Main method to test all algorithms
    public static void main(String[] args) {
        System.out.println("=== Testing Algorithms and Data Structures ===\n");

        // Create a graph with 6 vertices
        AlgorithmsAndDataStructures graph = new AlgorithmsAndDataStructures(6);

        // Add edges for testing
        graph.addUndirectedEdge(0, 1, 4);
        graph.addUndirectedEdge(0, 2, 3);
        graph.addUndirectedEdge(1, 2, 1);
        graph.addUndirectedEdge(1, 3, 2);
        graph.addUndirectedEdge(2, 3, 4);
        graph.addUndirectedEdge(3, 4, 2);
        graph.addUndirectedEdge(4, 5, 6);

        System.out.println("1. Graph Representations:");
        graph.displayAdjacencyList();
        System.out.println();
        graph.displayAdjacencyMatrix();
        System.out.println();

        System.out.println("2. Graph Traversal Algorithms:");
        graph.dfs(0);
        graph.bfs(0);
        System.out.println();

        System.out.println("3. Minimum Spanning Tree Algorithms:");
        graph.kruskalsAlgorithm();
        graph.primsAlgorithm();
        System.out.println();

        System.out.println("4. Shortest Path Algorithm:");
        graph.dijkstrasAlgorithm(0);
        System.out.println();

        System.out.println("5. String Matching Algorithms:");
        String text = "ABABDABACDABABCABCABCABCABC";
        String pattern = "ABABCAB";

        List<Integer> bruteForceMatches = bruteForceStringMatch(text, pattern);
        System.out.println("Brute Force matches: " + bruteForceMatches);

        List<Integer> rabinKarpMatches = rabinKarpStringMatch(text, pattern);
        System.out.println("Rabin-Karp matches: " + rabinKarpMatches);
        System.out.println();

        System.out.println("6. Sorting Algorithms:");
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(arr1));
        mergeSort(arr1);
        System.out.println("Merge sorted: " + Arrays.toString(arr1));

        int[] arr2 = {64, 34, 25, 12, 22, 11, 90};
        quickSort(arr2);
        System.out.println("Quick sorted: " + Arrays.toString(arr2));
        System.out.println();

        System.out.println("7. Counting Inversions:");
        int[] invArr = {8, 4, 2, 1};
        System.out.println("Array: " + Arrays.toString(invArr));
        System.out.println("Number of inversions: " + countInversions(invArr.clone()));
        System.out.println();

        System.out.println("8. Distance Calculation:");
        System.out.println("Distance from 0 to 4 (unweighted): " + graph.distanceUnweighted(0, 4));
        System.out.println("Distance from 0 to 4 (weighted): " + graph.distanceWeighted(0, 4));
        System.out.println("Distance from 0 to 5 (unweighted): " + graph.distanceUnweighted(0, 5));
        System.out.println("Distance from 0 to 5 (weighted): " + graph.distanceWeighted(0, 5));

        System.out.println("\n=== All tests completed successfully! ===");
    }
}