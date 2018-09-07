package URI.Trying.NOSTATUS.GRAPH;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Teerapat-BSD on 2/5/2018.
 * https://www.urionlinejudge.com.br/judge/en/problems/view/1790
 * algorithm : Detecting_Bridges find non cycle node dp
 */
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
        LinkedList<Integer> bridges;

        public City(int id) {
            bridges = new LinkedList<>();
            this.id = id;
        }

        void addBrid(int desination) {
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

            LinkedList<Bridges> Q = new LinkedList<Bridges>();
            Bridges[] bridges = new Bridges[p];
            for (int i = 0; i < p; i++) {
                st = br.readLine().split(" ");
                int a = Integer.parseInt(st[0]);
                int b = Integer.parseInt(st[1]);
                cities[a].addBrid(b);
                map[a - 1][b - 1] = 1;
//                bridges[i] = new Bridges(a, b);
                Q.add(bridges[i]);
            }

            //findAllCycle

            buildLoop:
            while (true) {
                LinkedList<Bridges> next = new LinkedList<>();
                LinkedList<Bridges> moved = new LinkedList<>();

                while (!Q.isEmpty()) {
                    Bridges b = Q.pollFirst();
//                    visited[b.cityA - 1][b.cityB - 1] = 1;
//                    visited[b.cityB - 1][b.cityA - 1] = 1;
//
//                    if (cityVisited[b.cityB - 1] != 1) {
//                        for (int i = 0; i < c; i++) {
//                            if (map[b.cityB - 1][i] == 1 && visited[b.cityB - 1][i] != 1) {
//                                next.add(new Bridges(b.cityB, i + 1));
//                            }
//                        }
//                        cityVisited[b.cityB - 1] = 1;
//                    }
                    System.out.println(b.cityA + " " + b.cityB);
                }
                Q.addAll(next);
                if (Q.isEmpty()) {
                    break buildLoop;
                }
                System.out.println("next");
            }

            for (int i = 0; i < c; i++) {
                if (checkNonCycle(bridges[i])) {
                    totalBridge++;
                }
            }

            bw.append(totalBridge + "\n");
            bw.flush();
        }
        bw.flush();

    }


    static private boolean checkNonCycle(Bridges bridges) {
        Bridges b = cycleBridges.get(bridges.cityA + " " + bridges.cityB);
        if (b != null) {
            return true;
        }
        return false;
    }

}
