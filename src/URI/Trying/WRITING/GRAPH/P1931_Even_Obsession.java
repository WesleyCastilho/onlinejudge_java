package URI.Trying.WRITING.GRAPH;

import MYTOOLS.DB_BufferedFileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 1931 - Even Obsession
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1931
 * @Level:
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
public class P1931_Even_Obsession {

    private static int[][] cost;

    private static class City {
        int id;
        LinkedList<City> link;
        int d;
        City prev;

        public City(int id) {
            this.id = id;
            link = new LinkedList<>();
            this.d = Integer.MAX_VALUE;
        }

        void addLink(City c) {
            link.add(c);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new DB_BufferedFileReader("input/P1931_input.txt").build(P1931_Even_Obsession.class);

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int c = Integer.parseInt(st[0]);
        int v = Integer.parseInt(st[1]);
        cost = new int[c + 1][c + 1];
        City[] cityArr = new City[c + 1];
        for (int i = 1; i <= c; i++) {
            cityArr[i] = new City(i);
        }

        for (int i = 0; i < v; i++) {
            st = br.readLine().split(" ");
            int s = Integer.parseInt(st[0]);
            int d = Integer.parseInt(st[1]);
            int h = Integer.parseInt(st[2]);
            cost[s][d] = h;
            cost[d][s] = h;
            cityArr[s].addLink(cityArr[d]);
            cityArr[d].addLink(cityArr[s]);
        }


        boolean itOK = false;
        int[] p = new int[c + 1];
        LinkedList<City> Q = new LinkedList<>();
        Q.add(cityArr[c]);
        loop:
        while (!Q.isEmpty()) {
            City city = Q.poll();
            for (City cur : city.link) {
                cur.prev = city;
                cur.d = cost[city.id][cur.id];
                if (cur.id == 1) {
                    break loop;
                }
                Q.add(cur);
            }

        }

        int answer = 0;
        int count = 0;
        City cur = cityArr[c];
        while (true) {
            if (cur.prev == null) break;
            answer += cost[cur.id][cur.prev.id];
            cur = cur.prev;
            count++;
        }
//        int e = c;
//        while (p[e] != 0) {
//            answer += cost[e][p[e]];
//            count++;
//            e = p[e];
//            System.out.println("ss");
//        }

        System.out.println((count % 2 == 0 ? answer : "-1") + "\n");
    }

}

