package th.in.devboom.uri.trying.Graph;

import java.io.*;
import java.util.LinkedList;

/**
 * Created by Teerapat-BSD on 2/5/2018.
 * https://www.urionlinejudge.com.br/judge/en/problems/view/1790
 * algorithm : Detecting_Bridges find non cycle node
 */
public class P1790_Detecting_Bridges {

    static int[][] bridges;
    static City[] city;
    static boolean[] visited;

    static class pair {
        int a, b;
    }

    static class City {
        int cityId;
        LinkedList<City> bridges = new LinkedList<City>();


        public City(int cityId) {
            this.cityId = cityId;
        }

        void addBrid(int cityId) {
            boolean found = false;
            loop:
            for (City c : bridges) {
                if (cityId == c.cityId) {
                    found = true;
                    break loop;
                }
            }
            if (!found) {

                this.bridges.add(new City(cityId));
            }
        }

        public LinkedList<City> getBridges() {
            return bridges;
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
            city = new City[c + 1];
            bridges = new int[c][p];
            int totalBridge = 0;
            for (int i = 0; i < p; i++) {
                st = br.readLine().split(" ");
                int a = Integer.parseInt(st[0]);
                int b = Integer.parseInt(st[1]);
                if (city[a] == null) {
                    city[a] = new City(a);
                }
                if (city[b] == null) {
                    city[b] = new City(b);
                }
                city[a].addBrid(b);
            }



            visited = new boolean[c + 1];
            for (City now : city) {
                if (now != null) {
                    visited[now.cityId] = true;
                    LinkedList<City> bridList = now.getBridges();
                    for (City nextB : bridList) {
                        if (!visited[nextB.cityId]) {
                            totalBridge++;
                        } else {
                            totalBridge--;
                        }
                    }
                }
            }
            bw.append(totalBridge + "\n");
            bw.flush();
        }
        bw.flush();

    }
}
