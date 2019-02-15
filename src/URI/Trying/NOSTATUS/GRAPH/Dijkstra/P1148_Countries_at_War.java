package URI.Trying.NOSTATUS.GRAPH.Dijkstra;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 1148 - Countries at War
 * @Link: https://www.urionlinejudge.com.br/repository/UOJ_1148_en.html
 * @Level:
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: Dijkstra
 * @Note:
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class P1148_Countries_at_War {

    static private int n, e, k;

    static private int[][] cost;
    static int[] p;

    static private class Country {
        int id;
        int d;
        LinkedList<Country> link;

        public Country(int id) {
            link = new LinkedList<>();
            this.id = id;
            this.d = Integer.MAX_VALUE;
        }

        void addLink(Country country) {
            if (!link.contains(country))
                link.add(country);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            String[] st = input.split(" ");
            n = Integer.parseInt(st[0]);
            e = Integer.parseInt(st[1]);
            cost = new int[n + 1][n + 1];
            p = new int[n + 1];
            Country[] country = new Country[n + 1];
            for (int i = 1; i <= n; i++) {
                country[i] = new Country(i);
            }
            for (int i = 1; i <= e; i++) {
                st = br.readLine().split(" ");
                int c1 = Integer.parseInt(st[0]);
                int c2 = Integer.parseInt(st[1]);
                int h = Integer.parseInt(st[2]);
                cost[c1][c2] = h;
                country[c1].addLink(country[c2]);
            }

            Comparator<Country> comparator = new Comparator<Country>() {

                @Override
                public int compare(Country country1, Country country2) {
                    if (country1.d < country2.d) return -1;
                    else if (country1.d > country2.d) return 1;
                    return 0;
                }
            };
            PriorityQueue<Country> minHeap = new PriorityQueue<>(n + 1, comparator);
            country[1].d = 0;
            minHeap.add(country[1]);
            while (!minHeap.isEmpty()) {
                Country c = minHeap.poll();
                for (Country cur : c.link) {
                    if (cost[c.id][cur.id] < cur.d) {
                        cur.d = cost[c.id][cur.id];
                        p[cur.id] = c.id;
                        minHeap.add(cur);
                    }
                }
            }
           for(Country c : country){
               if( c == null) continue;
               System.out.println(c.d);
           }


            bw.newLine();
        }
        bw.flush();
    }


}
