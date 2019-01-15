package URI.Trying.NOSTATUS.GRAPH;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 1790 - Detecting Bridges
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1790
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: counting bridges in graph
 * @Note:
 */

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;


public class P1790_Detecting_Bridges {

    static class Graph {
        private int V;   // No. of vertices

        // Array  of lists for Adjacency List Representation
        private LinkedList<Integer> adj[];
        int time = 0;
        static final int NIL = -1;

        // Constructor
        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        // Function to add an edge into the graph
        void addEdge(int v, int w) {
            adj[v].add(w);  // Add w to v's list.
            adj[w].add(v);    //Add v to w's list
        }

        // A recursive function that finds and prints bridges
        // using DFS traversal
        // u --> The vertex to be visited next
        // visited[] --> keeps tract of visited vertices
        // disc[] --> Stores discovery times of visited vertices
        // parent[] --> Stores parent vertices in DFS tree
        void bridgeUtil(int u, boolean visited[], int disc[],
                        int low[], int parent[]) {
            int b = 0;
            // Mark the current node as visited
            visited[u] = true;

            // Initialize discovery time and low value
            disc[u] = low[u] = ++time;

            // Go through all vertices aadjacent to this
            Iterator<Integer> i = adj[u].iterator();
            while (i.hasNext()) {
                int v = i.next();  // v is current adjacent of u

                // If v is not visited yet, then make it a child
                // of u in DFS tree and recur for it.
                // If v is not visited yet, then recur for it
                if (!visited[v]) {
                    parent[v] = u;
                    bridgeUtil(v, visited, disc, low, parent);

                    // Check if the subtree rooted with v has a
                    // connection to one of the ancestors of u
                    low[u] = Math.min(low[u], low[v]);

                    // If the lowest vertex reachable from subtree
                    // under v is below u in DFS tree, then u-v is
                    // a bridge
                    if (low[v] > disc[u]) {
                        System.out.println(u + " " + v);
                    }
                }

                // Update low value of u for parent function calls.
                else if (v != parent[u])
                    low[u] = Math.min(low[u], disc[v]);
            }
        }


        // DFS based function to find all bridges. It uses recursive
        // function bridgeUtil()
        void bridge() {

            // Mark all the vertices as not visited
            boolean visited[] = new boolean[V];
            int disc[] = new int[V];
            int low[] = new int[V];
            int parent[] = new int[V];


            // Initialize parent and visited, and ap(articulation point)
            // arrays
            for (int i = 0; i < V; i++) {
                parent[i] = NIL;
                visited[i] = false;
            }

            // Call the recursive helper function to find Bridges
            // in DFS tree rooted with vertex 'i'
            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    bridgeUtil(i, visited, disc, low, parent);


        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String in;
        while ((in = br.readLine()) != null) {
            String[] st = in.split(" ");
            int c = Integer.parseInt(st[0]);
            int p = Integer.parseInt(st[1]);
            Graph g = new Graph(1251);
            for (int i = 0; i < p; i++) {
                st = br.readLine().split(" ");
                int a = Integer.parseInt(st[0]);
                int b = Integer.parseInt(st[1]);

                g.addEdge(a, b);
                g.addEdge(a, b);
            }
            g.bridge();
//            bw.append(g.bridge() + "\n");
            bw.flush();
        }
        bw.flush();

    }

}
