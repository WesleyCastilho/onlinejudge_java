package URI.Trying.NOSTATUS.GRAPH;

import MYTOOLS.DB_BufferedFileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

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

        Comparator<City> comparator = new Comparator<City>() {

            @Override
            public int compare(City country1, City country2) {
                if (country1.d < country2.d) return -1;
                else if (country1.d > country2.d) return 1;
                return 0;
            }
        };
        int[] p = new int[c + 1];
        PriorityQueue<City> minHeap = new PriorityQueue<>(c + 1, comparator);
        cityArr[c].d = 0;
//        System.out.println(cityArr[c].id);
        minHeap.add(cityArr[c]);

        while (!minHeap.isEmpty()) {
            City city = minHeap.poll();
//            System.out.println(city.link.size());
            for (City cur : city.link) {
                if (cost[city.id][cur.id] < cur.d) {
                    p[cur.id] = city.id;
                    cur.d = cost[city.id][cur.id];
                    minHeap.add(cur);
                }
            }
//            System.out.println("size=" + minHeap.size());
        }
        for (int i = 1; i <= c; i++) {
            System.out.print(" " + cityArr[i].id + "=" + cityArr[i].d);
        }
        System.out.println();


        for (int i = 1; i <= c; i++)
            System.out.print(" " + i);
        System.out.println();
        for (int i = 1; i <= c; i++) {
            System.out.print(" " + p[i]);
        }
        System.out.println();


        int answer = 0;
        int count = 0;
        int e = 1;
        while (p[e] != 0) {
            answer += cost[e][p[e]];
            count++;
            e = p[e];
        }
        System.out.println(count);
        System.out.println(answer);

        System.out.println((count % 2 == 0 ? answer : "-1") + "\n");
    }

}

