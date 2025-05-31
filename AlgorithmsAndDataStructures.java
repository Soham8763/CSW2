// Graph Theory (Easy to Medium)

// Q1: Check if graph is connected
// Q2: Count connected components
// Q3: Check if path exists between vertices
// Q4: Find all paths from source to destination
// Q5: Check if graph is bipartite

// MST (Minimum Spanning Tree)

// Q6: Find second minimum spanning tree weight
// Implementation includes Kruskal's with edge exclusion

// Dijkstra's & Shortest Paths

// Q7: Find k shortest paths (framework provided)
// Q8: Check if negative cycle exists (Bellman-Ford)

// Hashing Questions

// Q9: Find first non-repeating character
// Q10: Find pairs with given sum
// Q11: Check if strings are anagrams
// Q12: Longest substring without repeating characters

// Sorting Questions

// Q13: Find kth largest element (QuickSelect)
// Q14: Count elements smaller than target
// Q15: Merge k sorted arrays
// Q16: Check if array can be sorted by adjacent swaps

// String Matching Questions

// Q17: Case-insensitive pattern matching
// Q18: Count distinct substrings using rolling hash
// Q19: Check if string is rotation of another
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

    // ====================== EXAM QUESTIONS AND SOLUTIONS ======================

    // GRAPH THEORY QUESTIONS

    // Q1: Check if graph is connected (Easy)
    public boolean isConnected() {
        boolean[] visited = new boolean[vertices];
        dfsUtil(0, visited);

        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    // Q2: Find number of connected components (Easy-Medium)
    public int countConnectedComponents() {
        boolean[] visited = new boolean[vertices];
        int components = 0;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfsUtil(i, visited);
                components++;
            }
        }
        return components;
    }

    // Q3: Check if path exists between two vertices (Easy)
    public boolean hasPath(int src, int dest) {
        if (src == dest) return true;

        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[src] = true;
        queue.offer(src);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (Edge edge : adjList.get(vertex)) {
                if (edge.dest == dest) return true;
                if (!visited[edge.dest]) {
                    visited[edge.dest] = true;
                    queue.offer(edge.dest);
                }
            }
        }
        return false;
    }

    // Q4: Find all paths from source to destination (Medium)
    public List<List<Integer>> findAllPaths(int src, int dest) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        boolean[] visited = new boolean[vertices];

        currentPath.add(src);
        findAllPathsUtil(src, dest, visited, currentPath, allPaths);
        return allPaths;
    }

    private void findAllPathsUtil(int current, int dest, boolean[] visited,
                                 List<Integer> currentPath, List<List<Integer>> allPaths) {
        visited[current] = true;

        if (current == dest) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            for (Edge edge : adjList.get(current)) {
                if (!visited[edge.dest]) {
                    currentPath.add(edge.dest);
                    findAllPathsUtil(edge.dest, dest, visited, currentPath, allPaths);
                    currentPath.remove(currentPath.size() - 1);
                }
            }
        }
        visited[current] = false;
    }

    // Q5: Check if graph is bipartite (Medium)
    public boolean isBipartite() {
        int[] color = new int[vertices];
        Arrays.fill(color, -1);

        for (int i = 0; i < vertices; i++) {
            if (color[i] == -1) {
                if (!isBipartiteUtil(i, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBipartiteUtil(int vertex, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        color[vertex] = 0;
        queue.offer(vertex);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (Edge edge : adjList.get(u)) {
                int v = edge.dest;
                if (color[v] == -1) {
                    color[v] = 1 - color[u];
                    queue.offer(v);
                } else if (color[v] == color[u]) {
                    return false;
                }
            }
        }
        return true;
    }

    // CYCLE DETECTION ALGORITHMS

    // Q6: Detect cycle in undirected graph using DFS (Medium)
    public boolean hasCycleUndirected() {
        boolean[] visited = new boolean[vertices];

        // Check for cycle in each connected component
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (hasCycleUndirectedUtil(i, -1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycleUndirectedUtil(int vertex, int parent, boolean[] visited) {
        visited[vertex] = true;

        for (Edge edge : adjList.get(vertex)) {
            int neighbor = edge.dest;

            // If neighbor is not visited, recursively check
            if (!visited[neighbor]) {
                if (hasCycleUndirectedUtil(neighbor, vertex, visited)) {
                    return true;
                }
            }
            // If neighbor is visited and is not parent, then cycle exists
            else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    // Q7: Detect cycle in directed graph using DFS (Medium)
    public boolean hasCycleDirected() {
        boolean[] visited = new boolean[vertices];
        boolean[] recStack = new boolean[vertices]; // Recursion stack

        // Check for cycle in each connected component
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (hasCycleDirectedUtil(i, visited, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycleDirectedUtil(int vertex, boolean[] visited, boolean[] recStack) {
        visited[vertex] = true;
        recStack[vertex] = true;

        for (Edge edge : adjList.get(vertex)) {
            int neighbor = edge.dest;

            // If neighbor is not visited, recursively check
            if (!visited[neighbor]) {
                if (hasCycleDirectedUtil(neighbor, visited, recStack)) {
                    return true;
                }
            }
            // If neighbor is in recursion stack, then cycle exists
            else if (recStack[neighbor]) {
                return true;
            }
        }

        recStack[vertex] = false; // Remove from recursion stack
        return false;
    }

    // Q8: Detect cycle in directed graph using colors (Three-color DFS) (Medium)
    public boolean hasCycleDirectedColors() {
        int[] color = new int[vertices]; // 0: white, 1: gray, 2: black

        for (int i = 0; i < vertices; i++) {
            if (color[i] == 0) {
                if (hasCycleColorsUtil(i, color)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycleColorsUtil(int vertex, int[] color) {
        color[vertex] = 1; // Mark as gray (being processed)

        for (Edge edge : adjList.get(vertex)) {
            int neighbor = edge.dest;

            if (color[neighbor] == 1) { // Back edge found (gray vertex)
                return true;
            }

            if (color[neighbor] == 0 && hasCycleColorsUtil(neighbor, color)) {
                return true;
            }
        }

        color[vertex] = 2; // Mark as black (completely processed)
        return false;
    }

    // Q9: Detect cycle using Union-Find (for undirected graphs) (Medium)
    public boolean hasCycleUnionFind() {
        int[] parent = new int[vertices];
        int[] rank = new int[vertices];

        // Initialize parent and rank arrays
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // Check each edge
        for (int u = 0; u < vertices; u++) {
            for (Edge edge : adjList.get(u)) {
                int v = edge.dest;

                // Only process each edge once (avoid processing both u->v and v->u)
                if (u < v) {
                    int parentU = find(parent, u);
                    int parentV = find(parent, v);

                    // If both vertices have same parent, cycle exists
                    if (parentU == parentV) {
                        return true;
                    }

                    // Union the sets
                    union(parent, rank, parentU, parentV);
                }
            }
        }
        return false;
    }

    // Q10: Find all cycles in undirected graph (Advanced)
    public List<List<Integer>> findAllCyclesUndirected() {
        List<List<Integer>> allCycles = new ArrayList<>();
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                List<Integer> currentPath = new ArrayList<>();
                findAllCyclesUtil(i, -1, visited, currentPath, allCycles);
            }
        }
        return allCycles;
    }

    private void findAllCyclesUtil(int vertex, int parent, boolean[] visited,
                                  List<Integer> currentPath, List<List<Integer>> allCycles) {
        visited[vertex] = true;
        currentPath.add(vertex);

        for (Edge edge : adjList.get(vertex)) {
            int neighbor = edge.dest;

            if (!visited[neighbor]) {
                findAllCyclesUtil(neighbor, vertex, visited, currentPath, allCycles);
            } else if (neighbor != parent && currentPath.contains(neighbor)) {
                // Found a cycle, extract it
                List<Integer> cycle = new ArrayList<>();
                int startIndex = currentPath.indexOf(neighbor);
                for (int i = startIndex; i < currentPath.size(); i++) {
                    cycle.add(currentPath.get(i));
                }
                cycle.add(neighbor); // Complete the cycle
                allCycles.add(cycle);
            }
        }

        currentPath.remove(currentPath.size() - 1);
    }

    // Q11: Detect negative weight cycle using Bellman-Ford (Medium)
    public boolean hasNegativeWeightCycle() {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        // Relax all edges V-1 times
        for (int i = 0; i < vertices - 1; i++) {
            boolean updated = false;
            for (int u = 0; u < vertices; u++) {
                if (dist[u] != Integer.MAX_VALUE) {
                    for (Edge edge : adjList.get(u)) {
                        if (dist[u] + edge.weight < dist[edge.dest]) {
                            dist[edge.dest] = dist[u] + edge.weight;
                            updated = true;
                        }
                    }
                }
            }
            if (!updated) break; // Early termination if no updates
        }

        // Check for negative cycles (Vth iteration)
        for (int u = 0; u < vertices; u++) {
            if (dist[u] != Integer.MAX_VALUE) {
                for (Edge edge : adjList.get(u)) {
                    if (dist[u] + edge.weight < dist[edge.dest]) {
                        return true; // Negative cycle found
                    }
                }
            }
        }

        return false;
    }

    // Q12: Find length of shortest cycle (Medium)
    public int shortestCycleLength() {
        int minCycleLength = Integer.MAX_VALUE;

        // Try BFS from each vertex
        for (int start = 0; start < vertices; start++) {
            int[] dist = new int[vertices];
            int[] parent = new int[vertices];
            Arrays.fill(dist, -1);
            Arrays.fill(parent, -1);

            Queue<Integer> queue = new LinkedList<>();
            dist[start] = 0;
            queue.offer(start);

            while (!queue.isEmpty()) {
                int u = queue.poll();

                for (Edge edge : adjList.get(u)) {
                    int v = edge.dest;

                    if (dist[v] == -1) {
                        dist[v] = dist[u] + 1;
                        parent[v] = u;
                        queue.offer(v);
                    } else if (parent[u] != v) {
                        // Found a cycle
                        minCycleLength = Math.min(minCycleLength, dist[u] + dist[v] + 1);
                    }
                }
            }
        }

        return minCycleLength == Integer.MAX_VALUE ? -1 : minCycleLength;
    }

    // MST QUESTIONS

    // Q13: Find second minimum spanning tree weight (Medium)
    public int secondMinimumSpanningTree() {
        // First find MST using Kruskal's
        List<Edge> allEdges = getAllEdges();
        allEdges.sort(Comparator.comparingInt(e -> e.weight));

        int[] parent = new int[vertices];
        int[] rank = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        List<Edge> mstEdges = new ArrayList<>();
        int mstWeight = 0;

        for (Edge edge : allEdges) {
            int src = edge.dest / vertices;
            int dest = edge.dest % vertices;

            int srcParent = find(parent, src);
            int destParent = find(parent, dest);

            if (srcParent != destParent) {
                mstEdges.add(edge);
                mstWeight += edge.weight;
                union(parent, rank, srcParent, destParent);
                if (mstEdges.size() == vertices - 1) break;
            }
        }

        int secondMstWeight = Integer.MAX_VALUE;

        // Try removing each MST edge and find next best
        for (Edge removedEdge : mstEdges) {
            int tempWeight = findMSTExcluding(allEdges, removedEdge);
            if (tempWeight > mstWeight && tempWeight < secondMstWeight) {
                secondMstWeight = tempWeight;
            }
        }

        return secondMstWeight == Integer.MAX_VALUE ? -1 : secondMstWeight;
    }

    private List<Edge> getAllEdges() {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            for (Edge edge : adjList.get(i)) {
                edges.add(new Edge(i * vertices + edge.dest, edge.weight));
            }
        }
        return edges;
    }

    private int findMSTExcluding(List<Edge> edges, Edge excludedEdge) {
        int[] parent = new int[vertices];
        int[] rank = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int weight = 0;
        int edgesUsed = 0;

        for (Edge edge : edges) {
            if (edge.dest == excludedEdge.dest && edge.weight == excludedEdge.weight) {
                continue;
            }

            int src = edge.dest / vertices;
            int dest = edge.dest % vertices;

            int srcParent = find(parent, src);
            int destParent = find(parent, dest);

            if (srcParent != destParent) {
                weight += edge.weight;
                edgesUsed++;
                union(parent, rank, srcParent, destParent);
                if (edgesUsed == vertices - 1) break;
            }
        }

        return edgesUsed == vertices - 1 ? weight : Integer.MAX_VALUE;
    }

    // DIJKSTRA'S QUESTIONS

    // Q14: Find k shortest paths (Medium)
    public List<Integer> kShortestPaths(int src, int dest, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> {
            int sumA = a.stream().mapToInt(Integer::intValue).sum();
            int sumB = b.stream().mapToInt(Integer::intValue).sum();
            return Integer.compare(sumA, sumB);
        });

        List<Integer> initialPath = new ArrayList<>();
        initialPath.add(0); // Start with distance 0 to src
        pq.offer(initialPath);

        List<Integer> kShortestDistances = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        while (!pq.isEmpty() && kShortestDistances.size() < k) {
            List<Integer> currentPath = pq.poll();
            int currentDist = currentPath.stream().mapToInt(Integer::intValue).sum();

            if (currentPath.size() > 1 && currentPath.get(currentPath.size() - 1) == dest) {
                kShortestDistances.add(currentDist);
                continue;
            }

            // This is a simplified version - full implementation would be more complex
        }

        return kShortestDistances;
    }

    // Q15: Check if negative cycle exists (Medium)
    public boolean hasNegativeCycle() {
        // Bellman-Ford algorithm implementation
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        // Relax all edges V-1 times
        for (int i = 0; i < vertices - 1; i++) {
            for (int u = 0; u < vertices; u++) {
                if (dist[u] != Integer.MAX_VALUE) {
                    for (Edge edge : adjList.get(u)) {
                        if (dist[u] + edge.weight < dist[edge.dest]) {
                            dist[edge.dest] = dist[u] + edge.weight;
                        }
                    }
                }
            }
        }

        // Check for negative cycles
        for (int u = 0; u < vertices; u++) {
            if (dist[u] != Integer.MAX_VALUE) {
                for (Edge edge : adjList.get(u)) {
                    if (dist[u] + edge.weight < dist[edge.dest]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // HASHING QUESTIONS

    // Q16: Find first non-repeating character (Easy)
    public static char firstNonRepeatingChar(String str) {
        Map<Character, Integer> frequency = new HashMap<>();

        // Count frequencies
        for (char c : str.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        // Find first non-repeating
        for (char c : str.toCharArray()) {
            if (frequency.get(c) == 1) {
                return c;
            }
        }

        return '\0'; // Not found
    }

    // Q17: Find pairs with given sum (Easy-Medium)
    public static List<int[]> findPairsWithSum(int[] arr, int targetSum) {
        List<int[]> pairs = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = targetSum - num;
            if (seen.contains(complement)) {
                pairs.add(new int[]{complement, num});
            }
            seen.add(num);
        }

        return pairs;
    }

    // Q18: Check if arrays are anagrams (Easy)
    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        Map<Character, Integer> freq1 = new HashMap<>();
        Map<Character, Integer> freq2 = new HashMap<>();

        for (char c : str1.toCharArray()) {
            freq1.put(c, freq1.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            freq2.put(c, freq2.getOrDefault(c, 0) + 1);
        }

        return freq1.equals(freq2);
    }

    // Q19: Find longest substring without repeating characters (Medium)
    public static int longestSubstringWithoutRepeating(String str) {
        Set<Character> seen = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < str.length(); right++) {
            while (seen.contains(str.charAt(right))) {
                seen.remove(str.charAt(left));
                left++;
            }
            seen.add(str.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    // SORTING QUESTIONS

    // Q20: Find kth largest element (Medium)
    public static int findKthLargest(int[] arr, int k) {
        // Using QuickSelect algorithm
        return quickSelect(arr, 0, arr.length - 1, arr.length - k);
    }

    private static int quickSelect(int[] arr, int low, int high, int k) {
        if (low == high) return arr[low];

        int pivotIndex = partition(arr, low, high);

        if (pivotIndex == k) {
            return arr[pivotIndex];
        } else if (pivotIndex > k) {
            return quickSelect(arr, low, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, high, k);
        }
    }

    // Q21: Count elements smaller than or equal to given element (Easy)
    public static int countSmallerElements(int[] arr, int target) {
        int count = 0;
        for (int num : arr) {
            if (num <= target) count++;
        }
        return count;
    }

    // Q22: Merge k sorted arrays (Medium)
    public static int[] mergeKSortedArrays(int[][] arrays) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        List<Integer> result = new ArrayList<>();

        // Add first element of each array to heap
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                pq.offer(new int[]{arrays[i][0], i, 0}); // {value, arrayIndex, elementIndex}
            }
        }

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int value = current[0];
            int arrayIndex = current[1];
            int elementIndex = current[2];

            result.add(value);

            // Add next element from same array
            if (elementIndex + 1 < arrays[arrayIndex].length) {
                pq.offer(new int[]{arrays[arrayIndex][elementIndex + 1], arrayIndex, elementIndex + 1});
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    // Q23: Check if array can be sorted by swapping adjacent elements (Medium)
    public static boolean canBeSortedByAdjacentSwaps(int[] arr) {
        int inversions = (int) countInversions(arr.clone());
        // If inversions can be resolved by adjacent swaps
        return true; // This is always possible with adjacent swaps
    }

    // STRING MATCHING QUESTIONS

    // Q24: Find all occurrences of pattern in text with case insensitive (Easy)
    public static List<Integer> findPatternCaseInsensitive(String text, String pattern) {
        return bruteForceStringMatch(text.toLowerCase(), pattern.toLowerCase());
    }

    // Q25: Count distinct substrings using rolling hash (Medium)
    public static int countDistinctSubstrings(String str) {
        Set<Long> hashes = new HashSet<>();
        int n = str.length();
        long prime = 1000000007L;
        long base = 31;

        for (int len = 1; len <= n; len++) {
            long hash = 0;
            long pow = 1;

            for (int i = 0; i < len; i++) {
                hash = (hash + (str.charAt(i) - 'a' + 1) * pow) % prime;
                if (i < len - 1) pow = (pow * base) % prime;
            }
            hashes.add(hash);

            for (int i = len; i < n; i++) {
                hash = (hash - (str.charAt(i - len) - 'a' + 1)) / base;
                hash = (hash + (str.charAt(i) - 'a' + 1) * pow) % prime;
                hashes.add(hash);
            }
        }

        return hashes.size();
    }

    // Q26: Check if string is a rotation of another string (Easy-Medium)
    public static boolean isRotation(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        String concatenated = str1 + str1;
        return bruteForceStringMatch(concatenated, str2).size() > 0;
    }

    // ADDITIONAL UTILITY METHODS FOR TESTING

    // Method to run all exam questions
    public static void runExamQuestions() {
        System.out.println("\n=== EXAM QUESTIONS AND SOLUTIONS ===\n");

        // Create test graph
        AlgorithmsAndDataStructures graph = new AlgorithmsAndDataStructures(5);
        graph.addUndirectedEdge(0, 1, 2);
        graph.addUndirectedEdge(1, 2, 3);
        graph.addUndirectedEdge(2, 3, 1);
        graph.addUndirectedEdge(3, 4, 4);

        System.out.println("GRAPH THEORY QUESTIONS:");
        System.out.println("Q1. Is graph connected? " + graph.isConnected());
        System.out.println("Q2. Number of connected components: " + graph.countConnectedComponents());
        System.out.println("Q3. Path exists between 0 and 4? " + graph.hasPath(0, 4));
        System.out.println("Q4. All paths from 0 to 4: " + graph.findAllPaths(0, 4));
        System.out.println("Q5. Is graph bipartite? " + graph.isBipartite());

        System.out.println("\nCYCLE DETECTION QUESTIONS:");
        System.out.println("Q6. Has cycle (undirected)? " + graph.hasCycleUndirected());
        System.out.println("Q7. Has cycle (directed)? " + graph.hasCycleDirected());
        System.out.println("Q8. Has cycle (colors method)? " + graph.hasCycleDirectedColors());
        System.out.println("Q9. Has cycle (Union-Find)? " + graph.hasCycleUnionFind());
        System.out.println("Q10. All cycles: " + graph.findAllCyclesUndirected());
        System.out.println("Q11. Has negative weight cycle? " + graph.hasNegativeWeightCycle());
        System.out.println("Q12. Shortest cycle length: " + graph.shortestCycleLength());

        System.out.println("\nMST QUESTIONS:");
        System.out.println("Q13. Second MST weight: " + graph.secondMinimumSpanningTree());

        System.out.println("\nDIJKSTRA'S QUESTIONS:");
        System.out.println("Q15. Has negative cycle? " + graph.hasNegativeCycle());

        System.out.println("\nHASHING QUESTIONS:");
        System.out.println("Q16. First non-repeating char in 'aabbcc': " + firstNonRepeatingChar("aabbcc"));
        System.out.println("Q17. Pairs with sum 7 in [1,2,3,4,5,6]: " +
            Arrays.deepToString(findPairsWithSum(new int[]{1,2,3,4,5,6}, 7).toArray()));
        System.out.println("Q18. Are 'listen' and 'silent' anagrams? " + areAnagrams("listen", "silent"));
        System.out.println("Q19. Longest substring without repeating in 'abcabcbb': " +
            longestSubstringWithoutRepeating("abcabcbb"));

        System.out.println("\nSORTING QUESTIONS:");
        int[] testArr = {3, 1, 4, 1, 5, 9, 2, 6};
        System.out.println("Q20. 3rd largest in [3,1,4,1,5,9,2,6]: " + findKthLargest(testArr.clone(), 3));
        System.out.println("Q21. Elements <= 4 in array: " + countSmallerElements(testArr, 4));

        int[][] sortedArrays = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        System.out.println("Q22. Merged k sorted arrays: " +
            Arrays.toString(mergeKSortedArrays(sortedArrays)));

        System.out.println("\nSTRING MATCHING QUESTIONS:");
        System.out.println("Q24. Pattern 'AB' in 'abAB' (case insensitive): " +
            findPatternCaseInsensitive("abAB", "AB"));
        System.out.println("Q25. Distinct substrings in 'abc': " + countDistinctSubstrings("abc"));
        System.out.println("Q26. Is 'abcde' rotation of 'cdeab'? " + isRotation("abcde", "cdeab"));
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

        // Run exam questions
        runExamQuestions();
    }
}