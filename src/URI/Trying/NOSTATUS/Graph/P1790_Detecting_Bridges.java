package URI.Trying.NOSTATUS.GRAPH;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 1610 : Dudu Service Maker
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1790
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: group node
 * @Note:
 */

import java.io.*;
import java.util.LinkedList;


public class P1790_Detecting_Bridges {

    static int[][] map;
    static int[][] visited;
    static int[] cityVisited;
    static int c, p;
    static int totalBridge = 0;

    static private class City {
        int id;
        public LinkedList<City> bridges;
        int group;

        public City(int id) {
            bridges = new LinkedList<>();
            this.id = id;
        }

        void addBrid(City desination) {
            if (!bridges.contains(desination)) {
                bridges.add(desination);
            }
        }

        void setGroup(int group) {
            this.group = group;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String in;
        while ((in = br.readLine()) != null) {
            String[] st = in.split(" ");
            c = Integer.parseInt(st[0]);
            p = Integer.parseInt(st[1]);

            map = new int[c][p];
            visited = new int[c][p];
            cityVisited = new int[c];

            //init City
            City[] cities = new City[c + 1];
            for (int i = 1; i <= c; i++) {
                cities[i] = new City(i);
                cities[i].setGroup(i);
            }

            for (int i = 0; i < p; i++) {
                st = br.readLine().split(" ");
                int a = Integer.parseInt(st[0]);
                int b = Integer.parseInt(st[1]);
                cities[a].addBrid(cities[b]);
            }

            LinkedList<City> Q = new LinkedList<>();
            Q.add(cities[0]);


            for (City c : cities) {
                Q.add(c);
            }

            boolean[] visited = new boolean[c + 1];
            while (!Q.isEmpty()) {
                City c = Q.pollFirst();
                if (c != null) {
                    visited[c.id] = true;
                    System.out.println("city >> " + c.id);
                    for (City c2 : c.bridges) {
                        System.out.println("-> " + c2.id + " visit=" + visited[c2.id]);
                    }
                }
            }


            bw.append(totalBridge + "\n");
            bw.flush();
        }
        bw.flush();

    }

}
