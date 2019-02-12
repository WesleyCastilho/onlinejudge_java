package URI.Trying.NOSTATUS.GRAPH;

import MYTOOLS.DB_BufferedFileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        public City(int id) {
            this.id = id;
            link = new LinkedList<>();
        }

        void addLink(City c) {
            if (!link.contains(c))
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
            cityArr[s].addLink(cityArr[d]);
        }
        int answer = 0;
        int count = 0;
        boolean[] visited = new boolean[v + 1];
        int[] p = new int[c + 1];
        LinkedList<City> Q = new LinkedList<>();
        Q.add(cityArr[1]);//start at 1
        visited[1] = true;
        boolean isOK = false;
        while (!Q.isEmpty()) {
            City curCity = Q.pollFirst();
            if (curCity.id == c && count % 2 == 0) {

                //find answer
                int last = c;
                while (p[last] != 0) {
                    answer += cost[last][p[last]];
                    last = p[last];
                }
                isOK = true;
                break;
            }

            for (int i = 1; i <= c; i++) {
                if (!visited[cityArr[i].id]) {
                    p[cityArr[i].id] = curCity.id;
                    visited[cityArr[i].id] = true;
                    Q.add(cityArr[i]);
                }
            }

        }
        System.out.println(isOK ? answer : "-1");
    }

}

