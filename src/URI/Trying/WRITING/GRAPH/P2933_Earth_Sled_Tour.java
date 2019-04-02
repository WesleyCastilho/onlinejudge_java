/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 2933 - Earth Sled Tour
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2933
 * @Level:
 * @Timelimit:
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note: it always selects the path where the largest road is as minimum as possible.
   Can you help the Santa Claus determine what X value of gas he should use
    *** คำตอบยังไม่ถูก
 */

package URI.Trying.WRITING.GRAPH;

import java.io.*;
import java.util.LinkedList;

public class P2933_Earth_Sled_Tour {

    private static int N, M;
    private static City[] city;
    private static int[][] cost;

    private static class City {
        int id;
        LinkedList<City> link;

        public City(int id) {
            this.id = id;
            this.link = new LinkedList<>();
        }

        void addLink(City city) {
            this.link.add(city);
        }
    }

    private static class Travel {
        LinkedList<City> history;
        City lastTravel;
        int passed;

        public Travel() {
            this.passed = 0;
            this.history = new LinkedList<City>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] st = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);
        M = Integer.parseInt(st[1]);
        city = new City[N];
        cost = new int[N][N];
        for (int i = 0; i < N; i++) city[i] = new City(i);
        for (int i = 0; i < M; i++) {
            st = br.readLine().split(" ");
            int u = Integer.parseInt(st[0]);
            int v = Integer.parseInt(st[1]);
            int w = Integer.parseInt(st[2]);
            city[u].addLink(city[v]);
            cost[u][v] = w;
        }

        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            int totalPassed = 0;
            st = br.readLine().split(" ");
            int start = Integer.parseInt(st[0]);
            int end = Integer.parseInt(st[1]);
            if (start != end) {
                int[] v = new int[N];
                LinkedList<Travel> queue = new LinkedList<Travel>();
                Travel travel = new Travel();
                travel.lastTravel = city[start];
                travel.history.add(city[start]);
                queue.add(travel);
                v[start] = 1;
                int minimumPassed = Integer.MAX_VALUE;
                while (!queue.isEmpty()) {
                    Travel now = queue.poll();
                    for (City c : now.lastTravel.link) {
                        int passed = cost[now.lastTravel.id][c.id];
                        if (c.id == end && minimumPassed > now.passed) {
                            minimumPassed = passed;
                        } else if (v[c.id] == 0) {
                            v[c.id] = 1;
                            Travel t = new Travel();
                            t.passed = passed;
                            t.lastTravel = c;
                            t.history.addAll(now.history);
                            queue.add(t);
                        }
                    }
                }
                totalPassed = minimumPassed;
            }
            bw.append(totalPassed + "\n");
        }
        bw.flush();
    }

}