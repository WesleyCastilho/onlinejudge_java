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
 * @Solution:
 * @Note:
 */

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class P1790_Detecting_Bridges {

    static int[][] map;
    static int[][] visited;
    static int[] cityVisited;
    static int c, p;
    static int totalBridge = 0;

    static private class Bridges {
        City cityA;
        City cityB;

        public Bridges(City cityA, City cityB) {
            this.cityA = cityA;
            this.cityB = cityB;
        }
    }

    static private class City {
        int id;
        public LinkedList<City> bridges;

        public City(int id) {
            bridges = new LinkedList<>();
            this.id = id;
        }

        void addBrid(City desination) {
            if (!bridges.contains(desination)) {
                bridges.add(desination);
            }
        }
    }

    static private HashMap<String, Bridges> cycleBridges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String in;
        while ((in = br.readLine()) != null) {
            String[] st = in.split(" ");
            c = Integer.parseInt(st[0]);
            p = Integer.parseInt(st[1]);

            cycleBridges = new HashMap<>();
            map = new int[c][p];
            visited = new int[c][p];
            cityVisited = new int[c];

            //init City
            City[] cities = new City[c + 1];
            for (int i = 1; i <= c; i++) {
                cities[i] = new City(i);
            }

            for (int i = 0; i < p; i++) {
                st = br.readLine().split(" ");
                int a = Integer.parseInt(st[0]);
                int b = Integer.parseInt(st[1]);
                cities[a].addBrid(cities[b]);
            }

            LinkedList<City> Q = new LinkedList<>();
            LinkedList<City> nextQ = new LinkedList<>();
            boolean[] visited = new boolean[c + 1];
            for (City c : cities) {
                if (c == null) continue;
                visited[c.id] = true;
                for (City city : c.bridges) {

                }
            }


            for (City c : cities) {
                if (c == null) continue;
                System.out.println("city: " + c.id);
                for (City c2 : c.bridges) {
                    System.out.println("->" + c2.id);
                }
            }

            bw.append(totalBridge + "\n");
            bw.flush();
        }
        bw.flush();

    }


}
